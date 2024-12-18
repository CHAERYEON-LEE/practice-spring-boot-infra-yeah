import { Suspense, lazy } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

const Main = lazy(() => import("./pages/main/MainPage"));
const PaginationBoard = lazy(() => import("./pages/board/PaginationBoardPage"));
const InfinitePaginationBoard = lazy(() =>
  import("./pages/board/InfinitePaginationBoardPage")
);
const CreateBoard = lazy(() => import("./pages/board/AddBoardPage"));
const BoardDetail = lazy(() => import("./pages/board/BoardDetail"));

export const Routers = () => {
  return (
    <Router>
      <Suspense fallback={<div>Loading...</div>}>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/board-pagination" element={<PaginationBoard />} />
          <Route
            path="/board-infinite-pagination"
            element={<InfinitePaginationBoard />}
          />
          <Route path="/board/create" element={<CreateBoard />} />
          <Route path="/board/detail" element={<BoardDetail />} />
        </Routes>
      </Suspense>
    </Router>
  );
};
