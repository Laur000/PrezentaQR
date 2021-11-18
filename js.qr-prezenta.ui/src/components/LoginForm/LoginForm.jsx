import React, { useState } from "react";
import {
  Button,
  Card,
  Notification,
  PasswordInput,
  SegmentedControl,
  TextInput,
} from "@mantine/core";
import styles from "./LoginForm.module.css";
import { useNotifications } from "@mantine/notifications";
import { useSelector, useDispatch } from "react-redux";
import {
  updateUserType,
  authenticateUser,
  deleteUser,
} from "../../store/userSlice";

const LoginForm = (props) => {
  const notifications = useNotifications();
  const dispatch = useDispatch();
  const userType = useSelector((state) => state.user.userType);
  const user = useSelector((state) => state.user.userData);

  const [formData, setFormData] = useState({ email: "", password: "" });

  React.useEffect(() => {
    if (user === null)
      notifications.showNotification({
        title: "Login",
        message: "Something went wrong with your authentication 🤥",
        color: "red",
        onClose: () => {
          dispatch(deleteUser());
        },
      });
  }, [user]);

  /* const validateStudentEmail = (email) => {
    var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.stud+\.+ro+$/;
    return re.test(email);
  };

  const validateProfessorEmail = (email) => {
    var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.prof+\.+ro+$/;
    return re.test(email);
  };
  const validateAdminEmail = (email) => {
    var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.admin+\.+ro+$/;
    return re.test(email);
  }; */

  return (
    <>
      <Card className={props.className} shadow="xl" padding="30px" radius="md">
        <div className={styles.segmentedControlWrapper}>
          <SegmentedControl
            value={userType}
            onChange={(value) => dispatch(updateUserType(value))}
            data={[
              { label: "Student", value: "student" },
              { label: "Teacher", value: "teacher" },
              { label: "Admin", value: "admin" },
            ]}
          />
        </div>
        <TextInput
          className={styles.field}
          placeholder="Username"
          label="Username"
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
            dispatch(authenticateUser({ userType, formData }));
          }}
        >
          login
        </Button>
      </Card>
    </>
  );
};

export default LoginForm;
