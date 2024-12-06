import { useState } from "react";
import { postBoardUpdate } from "../../utils/api/board/boardApi";

const UpdateBoard = (props) => {
  const { boardId, prevTitle, prevContent, setUpdateMode } = props;
  const [title, setTitle] = useState(prevTitle);
  const [content, setContent] = useState(prevContent);

  const handleUpdateBoard = async () => {
    const res = await postBoardUpdate({ boardId, title, content });
    if (res.data === 1) setUpdateMode(false);
  };

  return (
    <div>
      <h1>{boardId}번 게시글 수정하기</h1>
      <div>
        <label htmlFor="title">제목을 입력하세요</label>
        <input
          type="text"
          id="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
      </div>

      <div>
        <label htmlFor="content">내용을 입력하세요</label>
        <input
          type="text"
          id="content"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
      </div>

      <button type="button" onClick={handleUpdateBoard}>
        수정 완료
      </button>
      <button type="button" onClick={() => setUpdateMode(false)}>
        수정 취소
      </button>
    </div>
  );
};

export default UpdateBoard;
