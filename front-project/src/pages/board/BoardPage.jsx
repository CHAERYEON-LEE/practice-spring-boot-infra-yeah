import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

import PaginationTable from "./PaginationTable";
import InfinitePaginationTable from "./InfinitePaginationTable";
import {
  getPaginationBoardList,
  getInfinitePaginationBoardList,
} from "../../utils/api/board/boardApi";
/**
 * /api/list response data
 * board_id; 게시물 id
 * title; 제목
 * content; 내용
 * views; 조회수
 * tags; 태그이름
 * created_at; 작성일자
 * updated_at; 수정일자
 * delete_yn; 삭제여부 Y, N
 */

const BoardPage = () => {
  const navigate = useNavigate();
  // 기본 페이지네이션 상태
  const [basePntSize, setBasePntSize] = useState(10);
  const [basePntCurrentPage, setBasePntCurrentPage] = useState(0);
  const [basePntServerData, setBasePntServerData] = useState("");
  // 무한 스크롤 상태
  const [infiniteScrollSize, setInfiniteScrollSize] = useState(10);
  const [infiniteScrollLastId, setInfiniteScrollLastId] = useState(null);
  const [infiniteScrollServerData, setInfiniteScrollServerData] = useState("");
  const [hasMore, setHasMore] = useState(true);

  useEffect(() => {
    getInfinitePaginationBoard();
  }, []);

  useEffect(() => {
    const getPaginationBoard = async () => {
      try {
        const res = await getPaginationBoardList(
          basePntSize,
          basePntCurrentPage
        );
        setBasePntServerData(res.data);
      } catch (err) {
        console.log(err);
      }
    };

    getPaginationBoard();
  }, [basePntCurrentPage]);

  const getInfinitePaginationBoard = async () => {
    try {
      const res = await getInfinitePaginationBoardList(
        infiniteScrollSize,
        infiniteScrollLastId
      );
      setInfiniteScrollServerData((prev) => [...prev, ...res.data.boardList]);
      setInfiniteScrollLastId(res.data.boardList.at(-1)["board_id"]);
      setHasMore(res.data.hasMore ? true : false);
    } catch (err) {
      console.log(err);
    }
  };

  const handleBasePntChange = (pageNumber) =>
    setBasePntCurrentPage(pageNumber - 1);

  const handleInfiniteScrollPntChange = (boardLastId) => {
    if (hasMore) getInfinitePaginationBoard();
  };

  return (
    <div>
      <Header>
        <button type="button" onClick={() => navigate("/board/create")}>
          게시글 등록하기
        </button>
      </Header>
      <BoardContainer>
        <PaginationTable
          title="기본 페이지네이션"
          serverData={basePntServerData}
          size={basePntSize}
          currentPage={basePntCurrentPage}
          handlePageChange={handleBasePntChange}
        />
        <InfinitePaginationTable
          serverData={infiniteScrollServerData}
          handleScrollChange={handleInfiniteScrollPntChange}
          hasMore={hasMore}
        />
      </BoardContainer>
    </div>
  );
};

export default BoardPage;

const Header = styled.div`
  text-align: center;
`;

const BoardContainer = styled.div`
  display: flex;
`;
