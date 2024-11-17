import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [serverData, setServerData] = useState('')

  useEffect(() => {
    const getServerData = () => {
      axios.get("http://34.135.64.14/api/demo").then(res => setServerData(res))
    }

    getServerData()
  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          리액트 프로젝트 띄우기 성공!!!!!!!<br />
          서버 응답 데이터 : {serverData}
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          hahaha😀
        </a>
      </header>
    </div>
  );
}

export default App;
