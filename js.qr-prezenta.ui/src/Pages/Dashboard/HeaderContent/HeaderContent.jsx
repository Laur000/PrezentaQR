import React from "react";
import { UserContext } from "../../../context/UserContext";
import { Avatar, ThemeIcon, Menu, Container } from "@mantine/core";
import styles from "./HeaderContent.module.css";
import { ExitIcon, LightningBoltIcon } from "@radix-ui/react-icons";

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


            <Menu control={<div className={styles.user}>{user && user.username}<Avatar radius="lg" size="md" /> </div>}>
                <Menu.Item
                    component="button"
                    icon={<ExitIcon />}
                    onClick={() => setUser(null)}
                >
                    Sign Out
                </Menu.Item>
            </Menu>

        </div>
    );
};

export default HeaderContent;
