import './App.css';
import React from "react";
import { Route, Switch } from 'react-router';
import Login from './Pages/LoginPage/Login';
import Dashboard from './Pages/Dashboard/Dashboard';

function App() {
  return (
     <Switch>
       <Route path="/" component={Login} exact/>
       <Route path="/dashboard" component={Dashboard}/>
     </Switch>
  );
}

export default App;
