import styled from "styled-components";

export const NavigateButtonStyle = styled.div`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;

  button {
    border: none;
    color: #000;
    margin: 20px;
    width: 500px;
    height: 80px;
    color: #fff;
    border-radius: 5px;
    padding: 10px 25px;
    font-family: "Lato", sans-serif;
    font-weight: 500;
    font-size: 20px;
    background: transparent;
    cursor: pointer;
    transition: all 0.3s ease;
    position: relative;
    display: inline-block;
    box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, 0.5),
      7px 7px 20px 0px rgba(0, 0, 0, 0.1), 4px 4px 5px 0px rgba(0, 0, 0, 0.1);
    outline: none;
  }
  button:after {
    position: absolute;
    content: "";
    width: 0;
    height: 100%;
    top: 0;
    left: 0;
    direction: rtl;
    z-index: -1;
    box-shadow: -7px -7px 20px 0px #fff9, -4px -4px 5px 0px #fff9,
      7px 7px 20px 0px #0002, 4px 4px 5px 0px #0001;
    transition: all 0.3s ease;
  }
  button:hover {
    color: #000;
  }
  button:hover:after {
    left: auto;
    right: 0;
    width: 100%;
  }
  button:active {
    top: 2px;
  }
`;