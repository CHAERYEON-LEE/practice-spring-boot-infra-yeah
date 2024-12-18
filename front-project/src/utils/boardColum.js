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
export const BoardColumns = [
  {
    title: "board_id",
    dataIndex: "board_id",
    key: "board_id",
  },
  {
    title: "제목",
    dataIndex: "title",
    key: "title",
  },
  {
    title: "내용",
    dataIndex: "content",
    key: "content",
    render: (text, record) => (
      <a href={`/board/detail?board-id=${record.board_id}`}>{record.content}</a> // 링크를 클릭하면 상세 페이지로 이동
    ),
  },
  {
    title: "조회수",
    dataIndex: "views",
    key: "views",
  },
  {
    title: "태그명",
    dataIndex: "tags",
    key: "tags",
  },
  {
    title: "작성일자",
    dataIndex: "created_at",
    key: "created_at",
  },
  {
    title: "수정일자",
    dataIndex: "updated_at",
    key: "updated_at",
  },
];
