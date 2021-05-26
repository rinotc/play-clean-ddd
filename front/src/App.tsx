import React from 'react';
import './App.css';
import {BrowserRouter, Route} from "react-router-dom";
import Home from "./components/Home";
import {Layout} from "./components/Layout";

function App() {
  return (
      <BrowserRouter>
        <Layout>
          <Route exact path={"/"} component={Home} />
        </Layout>
      </BrowserRouter>
  );
}

export default App;
