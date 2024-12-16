import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

import PaginationTable from "./PaginationTable";
import {
  getPaginationBoardList,
  getBoardList,
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
  const [infiniteScrollCurrentPage, setInfiniteScrollCurrentPage] = useState(0);
  const [infiniteScrollServerData, setInfiniteScrollServerData] = useState("");

  useEffect(() => {
    const getPaginationBoard = async () => {
      try {
        // const res = await getBoardList();
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

  const handleBasePntChange = (pageNumber) =>
    setBasePntCurrentPage(pageNumber - 1);
  const handleInfiniteScrollPntChange = (pageNumber) =>
    setInfiniteScrollCurrentPage(pageNumber - 1);

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
        <PaginationTable
          title="무한스크롤 페이지네이션"
          serverData={infiniteScrollServerData}
          size={infiniteScrollSize}
          currentPage={infiniteScrollCurrentPage}
          handlePageChange={handleInfiniteScrollPntChange}
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
