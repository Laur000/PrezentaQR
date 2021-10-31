import React from "react";
import { Button, Navbar } from "@mantine/core";
import { HomeIcon } from "@radix-ui/react-icons";
import styles from "./Dashboard.module.css";

const NavbarContent = () => {
  return (
    <>
      <Navbar.Section grow mt="lg">
        <Button
          fullWidth
          size="md"
          variant="light"
          color="gray"
          leftIcon={<HomeIcon size={14} />}
          className={styles.leftAlignText}
        >
          Home
        </Button>
      </Navbar.Section>
      <Navbar.Section>Copyright</Navbar.Section>
    </>
  );
};

export default NavbarContent;
