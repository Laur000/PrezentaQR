import { Button, Input, TextInput } from "@mantine/core";
import { useNotifications } from "@mantine/notifications";
import axios from "axios";
import React, { useState } from "react";
import { useSelector } from "react-redux";
import { MAIN_URL } from "../../utils/url";

const DisciplineForm = (props) => {
  let ENDPOINT = "save-discipline";
  const notifications = useNotifications();
  const user = useSelector((state) => state.user.userData);
  const [newDiscipline, setNewDiscpline] = useState({
    materie: { id: 0, cursuri: [] },
    emailProfesor: user.email,
  });

  const saveNewDiscipline = async () => {
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
    <div>
      <TextInput
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
        color="teal"
        onClick={() => {
          saveNewDiscipline();
        }}
      >
        Save
      </Button>
    </div>
  );
};

export default DisciplineForm;
