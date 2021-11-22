import { Button, Modal, PasswordInput, TextInput } from "@mantine/core";
import { useMantineTheme } from "@mantine/styles";
import { useNotifications } from "@mantine/notifications";
import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import styles from "./AttendanceLogin.module.css";
import {
  updateUserType,
  authenticateUser,
  deleteUser,
} from "../../store/userSlice";
import axios from "axios";
import { MAIN_URL } from "../../utils/url";
import { CheckCircledIcon } from "@radix-ui/react-icons";

const AttendanceLogin = (props) => {
  const theme = useMantineTheme();
  const notifications = useNotifications();
  const dispatch = useDispatch();
  const params = props.match.params;
  const user = useSelector((state) => state.user.userData);

  const [formData, setFormData] = useState({ email: "", password: "" });
  const [success, setSuccess] = useState(null);

  React.useEffect(() => {
    if (user === null) {
      dispatch(deleteUser());
      setSuccess(false);
    }
    if (user) {
      axios
        .post(MAIN_URL + "save-attendance", {
          email: formData.email,
          password: formData.password,
          courseId: params.courseId,
          securityCode: params.securityCode,
        })
        .then((response) => response.data)
        .then((data) => {
          if (data) setSuccess(true);
          else {
            setSuccess(false);
          }
        });
    }
  }, [user]);

  React.useEffect(() => {
    if (success === false) {
      notifications.showNotification({
        title: "Login",
        message: "Something went wrong with your authentication 🤥",
        color: "red",
      });
    }
  }, [success]);

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <h1 className={styles.title}> LOGIN TO GET ATTENDANCE </h1>
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
          onClick={() => {
            dispatch(authenticateUser({ userType: "student", formData }));
          }}
        >
          Validate Attendance
        </Button>
        <Modal
          opened={success}
          hideCloseButton
          size="full"
          overlayColor={
            theme.colorScheme === "dark"
              ? theme.colors.dark[9]
              : theme.colors.gray[2]
          }
          overlayOpacity={0.95}
        >
          <div
            style={{
              display: "flex",
              minHeight: "85vh",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <div
              style={{
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
              }}
            >
              <CheckCircledIcon style={{ width: 100, height: 100 }} />
              <h2> Your attendance has been successfully saved! </h2>
              <h3>* You can close this tab!</h3>
            </div>
          </div>
        </Modal>
-      </div>
    </div>
  );
};

export default AttendanceLogin;
