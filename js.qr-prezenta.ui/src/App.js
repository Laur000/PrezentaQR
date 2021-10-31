import "./App.css";
import React from "react";
import { Redirect, Route, Switch } from "react-router";
import { UserContext } from "./context/UserContext";
import Login from "./Pages/LoginPage/Login";
import Dashboard from "./Pages/Dashboard/Dashboard";

function App() {
  const [user] = React.useContext(UserContext);
  console.log(user);
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
