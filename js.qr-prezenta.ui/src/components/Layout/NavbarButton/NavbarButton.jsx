import { Group, Text, ThemeIcon, UnstyledButton } from "@mantine/core";
import React from "react";
import { Link } from "react-router-dom";
import styles from "./styles.module.css";

const NavbarButton = (props) => {
  const isSelected = () => window.location.pathname === props.to;

  return (
    <Link to={props.to || "/404"}>
      <UnstyledButton
        {...props}
        className={
          !isSelected() ? styles.unstyledButton : styles.unstyledButtonSelected
        }
      >
        <Group>
          <ThemeIcon
            variant="light"
            color={isSelected() ? "green" : "gray"}
            radius="xl"
            size="xl"
          >
            {props.icon}
          </ThemeIcon>
          <Text
            className={
              isSelected()
                ? styles.unstyledButtonTextSelected
                : styles.unstyledButtonText
            }
          >
            {props.text}
          </Text>
        </Group>
      </UnstyledButton>
    </Link>
  );
};

export default NavbarButton;
