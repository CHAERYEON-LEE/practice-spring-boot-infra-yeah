import { useEffect, useState } from "react";
import { useSearchParams, useNavigate, useLocation } from "react-router-dom";
import { deleteBoard, getBoardDetail } from "../../utils/api/board/boardApi";
import UpdateBoard from "./UpdateBoard";

const BoardDetail = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [searchParams, setSearchParams] = useSearchParams();
  const detailId = searchParams.get("board-id");
  const [serverData, setServerData] = useState("");
  const [updateMode, setUpdateMode] = useState(false);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const getDetail = async () => {
      setLoading(true);
      const res = await getBoardDetail(detailId);
      setServerData(res.data);
      setLoading(false);
    };

    getDetail();
  }, [updateMode]);

  const handleDeleteBoard = async () => {
    const res = await deleteBoard(detailId);
    if (res.data === 1) window.history.back();
  };

  return (
    <div>
      {loading ? (
        <div>로딩중...</div>
      ) : (
        <>
          <h1>상세페이지</h1>
          <button type="button" onClick={() => window.history.back()}>
            목록으로 돌아가기
          </button>
          {updateMode ? (
            <UpdateBoard
              boardId={detailId}
              prevTitle={serverData.title}
              prevContent={serverData.content}
              setUpdateMode={setUpdateMode}
            />
          ) : (
            <>
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
              <button type="button" onClick={() => setUpdateMode(true)}>
                게시글 수정하기
              </button>
            </>
          )}
        </>
      )}
    </div>
  );
};

export default BoardDetail;
