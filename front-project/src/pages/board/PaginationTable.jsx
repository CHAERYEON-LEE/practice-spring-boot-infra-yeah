import { useNavigate } from "react-router-dom";
import { Table, Pagination } from "antd";
import styled from "styled-components";

import { BoardColumns } from "../../utils/boardColum";

const PaginationTable = (props) => {
  const { title, serverData, size, currentPage, handlePageChange } = props;
  const navigate = useNavigate();

  return (
    <TableStyle>
      {serverData ? (
        <>
          <button
            type="button"
            onClick={() =>
              navigate("/board/create", {
                state: { path: "/board-pagination" },
              })
            }
          >
            게시글 등록하기
          </button>
          <Table
            dataSource={serverData.boardList}
            columns={BoardColumns}
            pagination={false}
          />
          <Pagination
            defaultCurrent={currentPage + 1}
            total={serverData.totalCnt}
            onChange={handlePageChange}
          />
        </>
      ) : (
        <p>데이터를 불러오는 중입니다</p>
      )}
    </TableStyle>
  );
};

export default PaginationTable;

const TableStyle = styled.div`
  margin: 80px auto;
  width: 80vw;

  h1 {
    font-size: 30px;
    text-align: center;
    margin-bottom: 16px;
  }
`;
