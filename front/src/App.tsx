import React from 'react';
import './App.css';
import {BrowserRouter, Route} from "react-router-dom";
import Home from "./components/Home";
import {Layout} from "./components/Layout";

function App() {
  return (
      <Layout>
        <BrowserRouter>
          <Route exact path={"/"} component={Home} />
        </BrowserRouter>
      </Layout>
  );
}

export default App;
