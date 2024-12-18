import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { Input, FloatButton } from "antd";
import { SyncOutlined } from "@ant-design/icons";

import InfinitePaginationTable from "./InfinitePaginationTable";
import { getInfinitePaginationBoardList } from "../../utils/api/board/boardApi";
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

const { Search } = Input;
const InfinitePaginationBoardPage = () => {
  const navigate = useNavigate();
  // 무한 스크롤 상태
  const [infiniteScrollSize, setInfiniteScrollSize] = useState(10);
  const [infiniteScrollLastId, setInfiniteScrollLastId] = useState(null);
  const [infiniteScrollServerData, setInfiniteScrollServerData] = useState("");
  const [infiniteScrollTotalCnt, setInfiniteScrollTotalCnt] = useState(0);
  const [hasMore, setHasMore] = useState(true);
  const [keyword, setKeyword] = useState("");

  const getInfinitePaginationBoard = async (isReset) => {
    try {
      const res = await getInfinitePaginationBoardList(
        infiniteScrollSize,
        isReset ? null : infiniteScrollLastId,
        keyword
      );

      isReset
        ? setInfiniteScrollServerData(res.data.boardList)
        : setInfiniteScrollServerData((prev) => [
            ...prev,
            ...res.data.boardList,
          ]);
      setInfiniteScrollLastId(res.data.boardList.at(-1)["board_id"]);
      setHasMore(res.data.hasMore ? true : false);
      setInfiniteScrollTotalCnt(res.data.totalCnt);
    } catch (err) {
      console.log(err);
    }
  };

  const handleSearchInput = (e) => setKeyword(e.target.value);

  const handleInfiniteScrollPntChange = () => {
    if (hasMore) getInfinitePaginationBoard();
  };

  const handleSearchBtn = async () => getInfinitePaginationBoard(true);

  useEffect(() => {
    getInfinitePaginationBoard();
  }, []);

  return (
    <div>
      <Header>
        <h1>무한스크롤 페이지네이션 {infiniteScrollTotalCnt}개</h1>
        <SearchInputContainer>
          <Search
            type="text"
            placeholder="검색어를 입력하세요"
            value={keyword}
            onChange={(e) => handleSearchInput(e)}
            allowClear
            onSearch={handleSearchBtn}
            size="large"
          />
        </SearchInputContainer>
      </Header>
      <BoardContainer>
        <InfinitePaginationTable
          serverData={infiniteScrollServerData}
          handleScrollChange={handleInfiniteScrollPntChange}
          hasMore={hasMore}
          totalCnt={infiniteScrollTotalCnt}
        />
      </BoardContainer>
      <FloatButton
        icon={<SyncOutlined />}
        onClick={() => navigate("/board-pagination")}
      />
      <FloatButton.BackTop
        shape="circle"
        type="primary"
        style={{ insetInlineEnd: 94 }}
      />
    </div>
  );
};

export default InfinitePaginationBoardPage;

const Header = styled.div`
  text-align: center;

  h1 {
    font-size: 30px;
    text-align: center;
    margin-top: 100px;
    margin-bottom: 50px;
  }
`;

const SearchInputContainer = styled.div`
  width: 50vw;
  margin: 0 auto;
`;

const BoardContainer = styled.div`
  display: flex;
`;
