import React from "react";
import { AppShell, Navbar, Header } from "@mantine/core";
import { Route} from "react-router-dom";
import { UserContext } from "../../context/UserContext";
import NavbarContent from "./NavbarContent";
import CalendarPage from "../CalendarPage/CalendarPage";
import HomePage from "../HomePage/HomePage";
import AttendancePage from "../AttendancePage/AttendancePage";
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
      <Route path="/dashboard/" exact component={HomePage} />
      <Route path="/dashboard/attendance" exact component={AttendancePage} />
      <Route path="/dashboard/calendar" exact component={CalendarPage} />
    </AppShell>
  );
};

export default Dashboard;
