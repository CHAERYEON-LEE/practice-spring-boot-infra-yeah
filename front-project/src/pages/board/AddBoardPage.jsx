import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { Modal, Alert } from "antd";
import { postBoardCreate } from "../../utils/api/board/boardApi";
import styled from "styled-components";

const AddBoardPage = () => {
  const navigate = useNavigate();
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [modalOpen, setModalOpen] = useState(false);
  const [alert, setAlert] = useState(false);
  const [loading, setLoading] = useState(false);

  const postBoard = async () => {
    if (title === "" || content === "") {
      setAlert(true);
      setTimeout(() => {
        setAlert(false);
      }, 3000);
      return;
    }

    setLoading(true);

    const res = await postBoardCreate({ title, content });

    if (res.data === 1) {
      setModalOpen(true);
      setTitle("");
      setContent("");
    }

    setLoading(false);
  };

  const handleModalOk = () => {
    setModalOpen(false);
    navigate("/board");
  };

  return (
    <>
      {loading ? (
        <div>로딩중입니다</div>
      ) : (
        <div>
          <h1>게시글 등록하기</h1>
          <button type="button" onClick={() => navigate("/board")}>
            목록으로 돌아가기
          </button>

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

          <button type="button" onClick={postBoard}>
            게시글 등록
          </button>
          {alert ? (
            <Alert message="입력란을 모두 채워주세요!" type="error" closable />
          ) : (
            ""
          )}
          {modalOpen ? (
            <Modal title="Basic Modal" open={modalOpen} onOk={handleModalOk}>
              <p>게시글 등록이 완료되었습니다</p>
            </Modal>
          ) : (
            ""
          )}
        </div>
      )}
    </>
  );
};

export default AddBoardPage;
