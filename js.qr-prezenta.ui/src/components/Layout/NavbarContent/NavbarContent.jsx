import React from "react";
import {
  Text,
  Group,
  Menu,
  Navbar,
  ThemeIcon,
  UnstyledButton,
} from "@mantine/core";
import {
  BarChartIcon,
  CalendarIcon,
  GearIcon,
  HomeIcon,
} from "@radix-ui/react-icons";
import NavbarButton from "../NavbarButton/NavbarButton";

const NavbarContent = () => {
  return (
    <>
      <Navbar.Section grow mt="lg">
        <NavbarButton
          icon={<HomeIcon style={{ height: 20, width: 20 }} />}
          text="Home"
          to="/dashboard"
        />
        <NavbarButton
          icon={<CalendarIcon style={{ height: 20, width: 20 }} />}
          text="Calendar"
          to="/dashboard/calendar"
        />
        <NavbarButton
          icon={<BarChartIcon style={{ height: 20, width: 20 }} />}
          text="Attendance"
          to="/dashboard/attendance"
        />
        <NavbarButton
          icon={<GearIcon style={{ height: 20, width: 20 }} />}
          text="Settings"
          to="/dashboard/settings"
        />
      </Navbar.Section>
      <Navbar.Section>Copyright</Navbar.Section>
    </>
  );
};

export default NavbarContent;
