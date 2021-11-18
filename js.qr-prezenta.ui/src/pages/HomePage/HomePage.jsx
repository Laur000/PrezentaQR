import { Button, Modal } from "@mantine/core";
import React, { useState } from "react";
import { useSelector } from "react-redux";
import DisciplineForm from "../../components/DisciplineForm/DisciplineForm";
import styles from "./HomePage.module.css";
import DisciplineList from "../../components/DisciplineList/DisciplineList";
const HomePage = () => {
  const userType = useSelector((state) => state.user.userType);
  const [modalState, setModalState] = useState(false);
  return (
    <>
      <div>
        <div className={styles.buttonContainer}>
          <h1>Disciplines</h1>
          <Button
            variant="gradient"
            gradient={{ from: "teal", to: "blue", deg: 60 }}
            onClick={() => {
              setModalState(true);
            }}
          >
            Add Discipline
          </Button>
        </div>

        <DisciplineList />
      </div>
      <Modal
        opened={modalState}
        onClose={() => {
          setModalState(false);
        }}
        title="New Discipline"
      >
        <DisciplineForm closeModal={() => setModalState(false)} />
      </Modal>
    </>
  );
};

export default HomePage;
