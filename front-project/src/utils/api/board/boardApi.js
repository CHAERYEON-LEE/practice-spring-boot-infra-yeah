import axios from "axios";
import { CONST } from "../../constant";

// 게시판 목록
export const getBoardList = async () => {
  const data = await axios
    .get(`${CONST.BOARD_LIST}`)
    .then((res) => res.data)
    .catch((err) => err);

  return data;
};

export const getPaginationBoardList = async (size, currentPage, keyword) => {
  const data = await axios
    .get(
      `${CONST.BOARD_LIST_PAGINATION}?pageSize=${size}&pageNum=${currentPage}${
        keyword === null || keyword === "" ? "" : `&keyword=${keyword}`
      }`
    )
    .then((res) => res.data)
    .catch((err) => err);

  return data;
};

export const getInfinitePaginationBoardList = async (
  size,
  lastBoardId,
  keyword
) => {
  const data = await axios
    .get(
      `${CONST.BOARD_LIST_INFINITE_PAGINATION}?pageSize=${size}${
        lastBoardId === null ? "" : `&lastBoardId=${lastBoardId}`
      }${keyword === null || keyword === "" ? "" : `&keyword=${keyword}`}`
    )
    .then((res) => res.data)
    .catch((err) => err);

  return data;
};

// 게시판 상세
export const getBoardDetail = async (detailId) => {
  const data = await axios
    .get(`${CONST.BOARD_DETAIL}/${detailId}`)
    .then((res) => res.data)
    .catch((err) => err);

  return data;
};

// 게시판 생성
export const postBoardCreate = async ({ title, content }) => {
  const data = await axios
    .post(`${CONST.BOARD_CREATE}`, {
      title,
      content,
    })
    .then((res) => res.data)
    .catch((err) => err);

  return data;
};

// 게시판 삭제
export const deleteBoard = async (detailId) => {
  const data = await axios
    .delete(`${CONST.BOARD_DELETE}/${detailId}`)
    .then((res) => res.data)
    .catch((err) => err);

  return data;
};

// 게시판 수정
export const postBoardUpdate = async ({ boardId, title, content }) => {
  const data = await axios
    .post(`${CONST.BOARD_UPDATE}`, {
      board_id: boardId,
      title,
      content,
    })
    .then((res) => res.data)
    .catch((err) => err);

  return data;
};
