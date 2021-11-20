import { Button, Input, TextInput } from "@mantine/core";
import { useNotifications } from "@mantine/notifications";
import axios from "axios";
import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { MAIN_URL } from "../../utils/url";
import styles from "./DisciplineForm.module.css";
import { getProfDisciplines } from "../../store/profDisciplineSlice";

const DisciplineForm = (props) => {
  const notifications = useNotifications();
  const dispatch = useDispatch();

  const user = useSelector((state) => state.user.userData);

  const [newDiscipline, setNewDiscpline] = useState({
    materie: { id: 0, cursuri: [] },
    emailProfesor: user.email,
  });

  const saveNewDiscipline = async () => {
    const ENDPOINT = "save-discipline";

    await axios
      .post(MAIN_URL + ENDPOINT, {
        ...newDiscipline,
      })
      .then((response) => response.data)
      .then((data) => {
        if (data) {
          notifications.showNotification({
            title: "Submit new discipline",
            message: "Discipline successfully added",
            color: "green",
          });
          props.closeModal();
          dispatch(getProfDisciplines({ email: user.email }));
        } else {
          notifications.showNotification({
            title: "Submit new discipline",
            message: "Something went wrong while adding the new discipline 🤥",
            color: "red",
          });
        }
      });
  };

  return (
    <div className={styles.container}>
      <TextInput
        className={styles.field}
        placeholder="Discipline name"
        label="Discipline name"
        onChange={(event) => {
          setNewDiscpline((prev) => ({
            ...prev,
            materie: { ...prev.materie, nume: event.target.value },
          }));
        }}
        required
      />

      <TextInput
        className={styles.field}
        placeholder="Details"
        label="Details"
        onChange={(event) => {
          setNewDiscpline((prev) => ({
            ...prev,
            materie: { ...prev.materie, detalii: event.target.value },
          }));
        }}
      />

      <Button
        className={styles.button}
        color="teal"
        onClick={() => {
          newDiscipline.materie.nume && saveNewDiscipline();
        }}
      >
        Save
      </Button>
    </div>
  );
};

export default DisciplineForm;
