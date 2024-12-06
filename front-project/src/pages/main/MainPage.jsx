import { useNavigate } from "react-router-dom";
import { NavigateButtonStyle } from "../../styles";

const MainPage = () => {
  const navigate = useNavigate();

  const handleNavigateBoard = () => navigate("/board");

  return (
    <NavigateButtonStyle>
      <button type="button" onClick={handleNavigateBoard}>
        게시판으로 이동하기
      </button>
    </NavigateButtonStyle>
  );
};

export default MainPage;
