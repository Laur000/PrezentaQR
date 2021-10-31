import React from "react";
import { UserContext } from "../../context/UserContext";

const Dashboard = () => {
  const [user, setUser] = React.useContext(UserContext);

  return (
    <div>
      <p> Welcome back, {user && user.username} </p>
      <button onClick={() => setUser(null)}>sign out</button>
    </div>
  );
};

export default Dashboard;
