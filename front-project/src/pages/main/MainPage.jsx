import { useNavigate } from "react-router-dom";
import { NavigateButtonStyle } from "../../styles";

const MainPage = () => {
  const navigate = useNavigate();

  const handleNavigatePaginationBoard = () => navigate("/board-pagination");
  const handleNavigateInfinitePaginationBoard = () =>
    navigate("/board-infinite-pagination");

  return (
    <NavigateButtonStyle>
      <button type="button" onClick={handleNavigatePaginationBoard}>
        페이지네이션 게시판으로 이동하기
      </button>
      <button type="button" onClick={handleNavigateInfinitePaginationBoard}>
        무한스크롤 게시판으로 이동하기
      </button>
    </NavigateButtonStyle>
  );
};

export default MainPage;
