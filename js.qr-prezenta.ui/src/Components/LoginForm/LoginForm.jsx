import React from "react";
import { Button, PasswordInput, TextInput } from "@mantine/core";
import styles from "./LoginForm.module.css";

import { UserContext } from "../../context/UserContext";

const LoginForm = (props) => {
  const [, setUser] = React.useContext(UserContext);

  const doesLogin = () => {
    setUser({ username: "Ionut" });
  };

  return (
    <div className={props.className}>
      <TextInput
        className={styles.field}
        placeholder="Username"
        label="Username"
        required
      />
      <PasswordInput
        className={styles.field}
        label="Password"
        placeholder="Password"
        required
      />
      <Button
        color="violet"
        radius="lg"
        uppercase
        fullWidth
        onClick={() => doesLogin()}
      >
        login
      </Button>
    </div>
  );
};

export default LoginForm;
