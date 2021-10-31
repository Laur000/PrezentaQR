import React from "react";
import { AppShell, Navbar, Header } from "@mantine/core";
import { UserContext } from "../../context/UserContext";
import NavbarContent from "./NavbarContent";
import HeaderContent from "./HeaderContent/HeaderContent";

const Dashboard = () => {
  const [user, setUser] = React.useContext(UserContext);

  return (
    <AppShell
      padding="md"
      navbar={
        <Navbar width={{ base: 300 }} padding="xs">
          <NavbarContent />
        </Navbar>
      }
      header={
        <Header height={60} padding="xs">
          <HeaderContent />
        </Header>
      }
      styles={(theme) => ({
        main: {
          backgroundColor:
            theme.colorScheme === "dark"
              ? theme.colors.dark[8]
              : theme.colors.gray[0],
        },
      })}
    >
      <p> Welcome back, {user && user.username} </p>
      <button onClick={() => setUser(null)}>sign out</button>
    </AppShell>
  );
};

export default Dashboard;
