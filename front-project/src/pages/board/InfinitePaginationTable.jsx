import { Table } from "antd";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import InfiniteScroll from "react-infinite-scroll-component";

import { BoardColumns } from "../../utils/boardColum";

const InfinitePaginationTable = (props) => {
  const navigate = useNavigate();
  const { serverData, handleScrollChange, hasMore, totalCnt } = props;

  return (
    <TableStyle>
      <button
        type="button"
        onClick={() =>
          navigate("/board/create", {
            state: { path: "/board-infinite-pagination" },
          })
        }
      >
        게시글 등록하기
      </button>
      {serverData ? (
        <>
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
        </>
      ) : (
        <p>데이터를 불러오는 중입니다</p>
      )}
    </TableStyle>
  );
};

export default InfinitePaginationTable;

const TableStyle = styled.div`
  margin: 50px auto;
  width: 80vw;
`;
