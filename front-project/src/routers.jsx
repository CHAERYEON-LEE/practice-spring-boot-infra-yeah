import { Suspense, lazy } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

const Board = lazy(() => import("./pages/board/BoardPage"));
const CreateBoard = lazy(() => import("./pages/board/AddBoardPage"));
const BoardDetail = lazy(() => import("./pages/board/BoardDetail"));

export const Routers = () => {
  return (
    <Router>
      <Suspense fallback={<div>Loading...</div>}>
        <Routes>
          <Route path="/" element={<Board />} />
          <Route path="/board" element={<Board />} />
          <Route path="/board/create" element={<CreateBoard />} />
          <Route path="/board/detail" element={<BoardDetail />} />
        </Routes>
      </Suspense>
    </Router>
  );
};
