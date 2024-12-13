import { useState, useEffect } from "react";
import { Table, Pagination } from "antd";
import { BoardColumns } from "../../utils/boardColum";
import { useNavigate } from "react-router-dom";
import {
  getBoardList,
  getPaginationBoardList,
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
  const [size, setSize] = useState(10);
  const [currentPage, setCurrentPage] = useState(0);
  const [serverData, setServerData] = useState("");

  useEffect(() => {
    const getPaginationBoard = async () => {
      try {
        const res = await getBoardList();
        // const res = await getPaginationBoardList(size, currentPage);
        setServerData(res.data);
      } catch (err) {
        console.log(err);
      }
    };

    getPaginationBoard();
  }, [currentPage]);

  const handlePageChange = (pageNumber) => setCurrentPage(pageNumber - 1);

  return (
    <div>
      <h1>게시판</h1>
      <h3>목록</h3>
      <button type="button" onClick={() => navigate("/board/create")}>
        게시글 등록하기
      </button>
      <Table
        // dataSource={serverData.boardList}
        dataSource={serverData}
        columns={BoardColumns}
        // pagination={false}
      />
      <Pagination
        defaultCurrent={currentPage + 1}
        total={serverData.totalCount}
        onChange={handlePageChange}
      />
    </div>
  );
};

export default BoardPage;
