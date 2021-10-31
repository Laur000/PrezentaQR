import React from "react";
import { UserContext } from "../../../context/UserContext";
import { Avatar, ThemeIcon, Menu } from "@mantine/core";
import styles from "./HeaderContent.module.css";
import { ExitIcon, LightningBoltIcon} from "@radix-ui/react-icons";

const HeaderContent = () => {
  const [user, setUser] = React.useContext(UserContext);

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
      <div className={styles.user}>
        <span>{user && user.username}</span>
        <Menu control={<Avatar radius="lg" size="md" />}>
          <Menu.Item
            component="button"
            icon={<ExitIcon />}
            onClick={() => setUser(null)}
          >
            Sign Out
          </Menu.Item>
        </Menu>
      </div>
    </div>
  );
};

export default HeaderContent;
