import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { Routers } from "./routers";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <Routers>
    <App />
  </Routers>
);
