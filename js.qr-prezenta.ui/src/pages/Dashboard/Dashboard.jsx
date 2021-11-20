import React from "react";
import { AppShell, Navbar, Header } from "@mantine/core";
import { Route } from "react-router-dom";
import NavbarContent from "../../components/Layout/NavbarContent/NavbarContent";
import CalendarPage from "../CalendarPage/CalendarPage";
import HomePage from "../HomePage/HomePage";
import AttendancePage from "../AttendancePage/AttendancePage";
import HeaderContent from "../../components/Layout/HeaderContent/HeaderContent";
import DisciplinePage from "../DisciplinePage/DisciplinePage";

const Dashboard = () => {
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
          overflowY: "auto",
          height: "93.5vh",
        },
      })}
    >
      <Route path="/dashboard/" exact component={HomePage} />
      <Route path="/dashboard/discipline/:id" component={DisciplinePage} />
      <Route path="/dashboard/attendance" exact component={AttendancePage} />
      <Route path="/dashboard/calendar" exact component={CalendarPage} />
    </AppShell>
  );
};

export default Dashboard;
