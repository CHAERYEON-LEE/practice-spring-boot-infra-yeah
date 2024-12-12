import { useEffect, useState } from "react";
import { Card, Space } from "antd";
import { useSearchParams, useNavigate } from "react-router-dom";
import { deleteBoard, getBoardDetail } from "../../utils/api/board/boardApi";
import UpdateBoard from "./UpdateBoard";

const BoardDetail = () => {
  const navigate = useNavigate();
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
    if (res.data === 1) navigate("/board");
  };

  return (
    <div>
      {loading ? (
        <div>로딩중...</div>
      ) : (
        <>
          <h1>상세페이지</h1>
          <button type="button" onClick={() => navigate("/board")}>
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
                  <Space direction="vertical" size={16}>
                    <Card
                      title={`게시글 번호 : ${serverData.board_id} ${serverData.title}`}
                      style={{ width: 300 }}
                    >
                      <p>{serverData.content}</p>
                      <div style={{ display: "float", float: "right" }}>
                        <button type="button" onClick={handleDeleteBoard}>
                          삭제
                        </button>
                        <button
                          type="button"
                          onClick={() => setUpdateMode(true)}
                        >
                          수정
                        </button>
                      </div>
                    </Card>
                  </Space>
                </>
              ) : (
                ""
              )}
            </>
          )}
        </>
      )}
    </div>
  );
};

export default BoardDetail;
