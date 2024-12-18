import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { Input, FloatButton } from "antd";
import { SyncOutlined } from "@ant-design/icons";

import PaginationTable from "./PaginationTable";
import { getPaginationBoardList } from "../../utils/api/board/boardApi";
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
const PaginationBoardPage = () => {
  const navigate = useNavigate();
  // 기본 페이지네이션 상태
  const [basePntSize, setBasePntSize] = useState(10);
  const [basePntCurrentPage, setBasePntCurrentPage] = useState(0);
  const [basePntServerData, setBasePntServerData] = useState("");
  const [keyword, setKeyword] = useState("");

  const getPaginationBoard = async () => {
    try {
      const res = await getPaginationBoardList(
        basePntSize,
        basePntCurrentPage,
        keyword
      );
      setBasePntServerData(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  const handleSearchInput = (e) => {
    setKeyword(e.target.value);
  };

  const handleBasePntChange = (pageNumber) =>
    setBasePntCurrentPage(pageNumber - 1);

  const handleSearchBtn = async () => {
    await getPaginationBoard();
  };

  useEffect(() => {
    getPaginationBoard();
  }, [basePntCurrentPage]);

  return (
    <div>
      <Header>
        <h1>기본 페이지네이션 {basePntServerData.totalCnt}개</h1>
        <SearchInputContainer>
          <Search
            type="text"
            placeholder="검색어를 입력하세요"
            value={keyword}
            onChange={(e) => handleSearchInput(e)}
            allowClear
            onSearch={handleSearchBtn}
          />
        </SearchInputContainer>
      </Header>
      <BoardContainer>
        <PaginationTable
          title="기본 페이지네이션"
          serverData={basePntServerData}
          size={basePntSize}
          currentPage={basePntCurrentPage}
          handlePageChange={handleBasePntChange}
        />
      </BoardContainer>
      <FloatButton
        icon={<SyncOutlined />}
        onClick={() => navigate("/board-infinite-pagination")}
      />
    </div>
  );
};

export default PaginationBoardPage;

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
