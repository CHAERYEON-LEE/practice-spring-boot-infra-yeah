import { useEffect, useState } from "react";
import { useSearchParams, useNavigate } from "react-router-dom";
import axios from "axios";

const BoardDetail = () => {
  const navigate = useNavigate();
  const [searchParams, setSearchParams] = useSearchParams();
  const detailId = searchParams.get("board-id");
  const [serverData, setServerData] = useState("");

  useEffect(() => {
    const getServerData = () => {
      axios
        .get(`/api/board/detail?boardId=${detailId}`)
        .then((res) => {
          setServerData(res.data);
        })
        .catch((err) => console.log(err));
    };

    getServerData();
  }, []);

  const handleDeleteBoard = () => {
    axios
      .delete(`/api/board/delete?boardId=${detailId}`)
      .then((res) => {
        console.log(res);
        navigate("/board");
      })
      .catch((err) => console.log(err));
  };

  return (
    <div>
      <h1>상세페이지</h1>
      <button type="button" onClick={() => navigate("/board")}>
        목록으로 돌아가기
      </button>
      {serverData ? (
        <>
          <div>
            <h1>게시글 번호 : {serverData.board_id}</h1>
            <h1>{serverData.title}</h1>
            <p>{serverData.content}</p>
          </div>
        </>
      ) : (
        ""
      )}
      <button type="button" onClick={handleDeleteBoard}>
        게시글 삭제하기
      </button>
      <button type="button" onClick={() => navigate("/board")}>
        게시글 수정하기
      </button>
    </div>
  );
};

export default BoardDetail;
