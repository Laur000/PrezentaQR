import { Button, Input, TextInput } from "@mantine/core";
import { useNotifications } from "@mantine/notifications";
import axios from "axios";
import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { MAIN_URL } from "../../utils/url";
import styles from "./CourseForm.module.css";
import { getProfDisciplineCourses } from "../../store/profDisciplineSlice";

const CourseForm = (props) => {
  const notifications = useNotifications();
  const dispatch = useDispatch();

  const [newCourse, setNewCourse] = useState({
    disciplineId: props.disciplineId,
    cursDTO: { cursId: 0 },
  });

  const saveNewCourse = async () => {
    const ENDPOINT = "save-course";

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

          dispatch(
            getProfDisciplineCourses({
              disciplineId: props.selectedDiscipline.id,
            })
          );
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
          newCourse.cursDTO.nume && saveNewCourse();
        }}
      >
        Save
      </Button>
    </div>
  );
};

export default CourseForm;
