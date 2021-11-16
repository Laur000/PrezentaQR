import "./App.css";
import React from "react";
import { Redirect, Route, Switch } from "react-router";
import { UserContext } from "./context/UserContext";
import Login from "./pages/LoginPage/Login";
import Dashboard from "./pages/Dashboard/Dashboard";
import { useSelector } from "react-redux";

function App() {
  const user = useSelector((state) => state.user.userData);

  return (
    <Switch>
      <Route
        path="/"
        render={(props) =>
          !user ? <Login {...props} /> : <Redirect to="/dashboard" />
        }
        exact
      />
      <Route
        path="/dashboard"
        render={(props) =>
          user ? <Dashboard {...props} /> : <Redirect to="/" />
        }
      />
    </Switch>
  );
}

export default App;
