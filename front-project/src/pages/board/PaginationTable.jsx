import { Table, Pagination } from "antd";
import styled from "styled-components";

import { BoardColumns } from "../../utils/boardColum";

const PaginationTable = (props) => {
  const { title, serverData, size, currentPage, handlePageChange } = props;

  return (
    <TableStyle>
      <h1>{title}</h1>
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
    </TableStyle>
  );
};

export default PaginationTable;

const TableStyle = styled.div`
  margin: 20px;
  width: 50vw;

  h1 {
    font-size: 30px;
    text-align: center;
    margin-bottom: 16px;
  }
`;
