import { Button, Input, TextInput } from "@mantine/core";
import { useNotifications } from "@mantine/notifications";
import axios from "axios";
import React, { useState } from "react";
import { useSelector } from "react-redux";
import { MAIN_URL } from "../../utils/url";
import styles from "./CourseForm.module.css";

const CourseForm = (props) => {
  let ENDPOINT = "save-course";
  const notifications = useNotifications();
  const user = useSelector((state) => state.user.userData);
  const [newCourse, setNewCourse] = useState({
    disciplineId: 0, cursDTO:{cursId: 0}
  });

  const saveNewCourse = async () => {
    await axios
      .post(MAIN_URL + ENDPOINT, {
        ...newCourse,
      })
      .then((response) => response.data)
      .then((data) => {
        console.log(data);
        if (data) {
          notifications.showNotification({
            title: "Submit new course",
            message: "Course successfully added",
            color: "green",
          });
          props.closeModal();
        } else {
          notifications.showNotification({
            title: "Submit new course",
            message: "Something went wrong while adding the new course 🤥",
            color: "red",
          });
        }
      });
  };
  return (
    <div className={styles.container}>
      <TextInput
        className={styles.field}
        placeholder="Course name"
        label="Course name"
        onChange={(event) => {
          setNewCourse((prev) => ({
            ...prev,
            cursDTO: { ...prev.cursDTO, nume: event.target.value },
          }));
        }}
        required
      />

      <TextInput
        className={styles.field}
        placeholder="Details"
        label="Details"
        onChange={(event) => {
          setNewCourse((prev) => ({
            ...prev,
            cursDTO: { ...prev.cursDTO, detalii: event.target.value },
          }));
        }}
      />

      <Button
        className={styles.button}
        color="teal"
        onClick={() => {
          saveNewCourse();
        }}
      >
        Save
      </Button>
    </div>
  );
};

export default CourseForm;
