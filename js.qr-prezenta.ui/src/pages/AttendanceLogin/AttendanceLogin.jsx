import { Button, PasswordInput, TextInput } from "@mantine/core";
import { useNotifications } from "@mantine/notifications";
import React, { useState } from "react";
import styles from "./AttendanceLogin.module.css";
const AttendanceLogin = (props) => {
  const notifications = useNotifications();
  const [formData, setFormData] = useState({ email: "", password: "" });

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <TextInput
          className={styles.field}
          placeholder="Email"
          label="Email"
          required
          value={formData.email}
          onChange={(event) =>
            setFormData((prev) => ({
              ...prev,
              email: event.target.value,
            }))
          }
        />
        <PasswordInput
          className={styles.field}
          label="Password"
          placeholder="Password"
          required
          value={formData.password}
          onChange={(event) =>
            setFormData((prev) => ({
              ...prev,
              password: event.target.value,
            }))
          }
        />
        <Button
          className={styles.loginButton}
          variant="gradient"
          gradient={{ from: "teal", to: "#2b8a3e" }}
          radius="lg"
          uppercase
          fullWidth
          onClick={() => {}}
        >
          Validate Attendance
        </Button>
      </div>
    </div>
  );
};

export default AttendanceLogin;
