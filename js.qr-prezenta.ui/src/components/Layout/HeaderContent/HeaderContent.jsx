import React from "react";
import { UserContext } from "../../../context/UserContext";
import { Avatar, ThemeIcon, Menu, Container } from "@mantine/core";
import styles from "./HeaderContent.module.css";
import { ExitIcon, LightningBoltIcon } from "@radix-ui/react-icons";
import { useSelector, useDispatch } from "react-redux";
import { deleteUser } from "../../../store/userSlice";

const HeaderContent = () => {
  const user = useSelector((state) => state.user.userData);
  const dispatch = useDispatch();
  console.log(user);
  return (
    <div className={styles.container}>
      <div className={styles.logo}>
        <ThemeIcon
          size="lg"
          radius="lg"
          variant="gradient"
          gradient={{ from: "teal", to: "grape" }}
        >
          <LightningBoltIcon />
        </ThemeIcon>
        <span className={styles.title}>QResent</span>
      </div>

      <Menu
        control={
          <div className={styles.user}>
            {user && user.firstName + " " + user.lastName}
            <Avatar radius="lg" size="md" />{" "}
          </div>
        }
      >
        <Menu.Item
          component="button"
          icon={<ExitIcon />}
          onClick={() => dispatch(deleteUser())}
        >
          Sign Out
        </Menu.Item>
      </Menu>
    </div>
  );
};

export default HeaderContent;
