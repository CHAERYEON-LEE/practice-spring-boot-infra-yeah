import { Table } from "antd";
import styled from "styled-components";
import InfiniteScroll from "react-infinite-scroll-component";

import { BoardColumns } from "../../utils/boardColum";

const InfinitePaginationTable = (props) => {
  const { serverData, handleScrollChange, hasMore } = props;

  return (
    <TableStyle>
      <h1>무한스크롤 페이지네이션</h1>
      <InfiniteScroll
        dataLength={serverData.length}
        next={handleScrollChange}
        hasMore={hasMore}
        loader={<h4>데이터를 불러오는 중입니다!</h4>}
        endMessage={
          <p style={{ textAlign: "center" }}>
            <b>불러올 데이터가 없습니다</b>
          </p>
        }
      >
        <Table
          dataSource={serverData}
          columns={BoardColumns}
          pagination={false}
        />
      </InfiniteScroll>
    </TableStyle>
  );
};

export default InfinitePaginationTable;

const TableStyle = styled.div`
  margin: 20px;
  width: 50vw;

  h1 {
    font-size: 30px;
    text-align: center;
    margin-bottom: 16px;
  }
`;
