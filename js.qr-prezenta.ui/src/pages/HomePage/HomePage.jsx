import { Button, Modal } from "@mantine/core";
import React, { useState } from "react";
import { useSelector } from "react-redux";
import DisciplineForm from "../../components/DisciplineForm/DisciplineForm";
import styles from "./HomePage.module.css";
const HomePage = () => {
  const userType = useSelector((state) => state.user.userType);
  const [modalState, setModalState] = useState(false);

  React.useEffect(() => {
    // request
  }, [userType]);
  return (
    <div>
      <div className={styles.buttonContainer}>
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
      <Modal
        opened={modalState}
        onClose={() => {
          setModalState(false);
        }}
        title="New Discipline"
      >
        <DisciplineForm closeModal={() => setModalState(false)} />
      </Modal>
    </div>
  );
};

export default HomePage;
