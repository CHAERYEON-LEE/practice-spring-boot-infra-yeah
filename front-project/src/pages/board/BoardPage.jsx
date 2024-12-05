import { useState, useEffect } from "react";
import axios from "axios";
import { Table } from "antd";
import { BoardColumns } from "../../utils/boardColum";
import { useNavigate } from "react-router-dom";
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
  const [serverData, setServerData] = useState("");

  useEffect(() => {
    const getServerData = () => {
      axios
        .get("/api/board/list")
        .then((res) => {
          setServerData(res.data);
        })
        .catch((err) => console.log(err));
    };

    getServerData();
  }, []);

  return (
    <div>
      <h1>게시판</h1>
      <h3>목록</h3>
      <button type="button" onClick={() => navigate("/board/create")}>
        게시글 등록하기
      </button>
      <Table dataSource={serverData} columns={BoardColumns} pagination={10} />
    </div>
  );
};

export default BoardPage;
