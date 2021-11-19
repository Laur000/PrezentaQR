import {
  Button,
  Card,
  Group,
  List,
  Text,
  ThemeIcon,
  Modal,
} from "@mantine/core";
import React, { useState } from "react";
import { ArrowLeftIcon, CheckCircledIcon } from "@radix-ui/react-icons";
import { useHistory } from "react-router";
import axios from "axios";
import { MAIN_URL } from "../../utils/url";
import { useSelector, useDispatch } from "react-redux";
import CourseForm from "../../components/CourseForm/CourseForm";
import styles from "./DisciplinePage.module.css";

import { getProfDisciplineCourses } from "../../store/profDisciplineSlice";

const DisciplinePage = (props) => {
  const params = props.match.params;
  const history = useHistory();
  const dispatch = useDispatch();

  const [modalState, setModalState] = useState(false);
  const [selectedDiscipline, setSelectedDiscipline] = React.useState(null);

  const courses = useSelector((state) => state.profDisciplines.courses);
  const disciplines = useSelector((state) => state.profDisciplines.disciplines);

  console.log(selectedDiscipline);
  console.log(courses);

  React.useEffect(() => {
    setSelectedDiscipline(
      disciplines.find((obj) => obj.id === parseInt(params.id))
    );

    dispatch(getProfDisciplineCourses({ id: params.id.toString() }));
  }, [params]);

  const mock = [
    { name: "Cursu unu", description: "Fresh nu-i bine deloc" },
    { name: "Cursul 2PM", description: "Salutare mos craciun" },
    {
      name: "Curva 3",
      description: "Sa ma arunc de pe camin sau sa ma arunc de pe camin",
    },
  ];

  const isLoading = () => {
    return !(
      selectedDiscipline && selectedDiscipline.id === parseInt(params.id)
    );
  };

  return (
    <div>
      {!isLoading() && (
        <>
          <Button
            className={styles.goBackButton}
            leftIcon={<ArrowLeftIcon />}
            variant="white"
            onClick={() => history.goBack()}
          >
            Back to Disciplines
          </Button>
          <div className={styles.buttonContainer}>
            <h1 style={{ margin: 0 }}>{selectedDiscipline.nume}</h1>
            <Button
              variant="gradient"
              gradient={{ from: "teal", to: "blue", deg: 60 }}
              onClick={() => {
                setModalState(true);
              }}
            >
              Add Course
            </Button>
          </div>
          <p style={{ margin: "0px 20px 20px 20px", maxWidth: 450 }}>
            {selectedDiscipline.detalii}
          </p>
          <List spacing="md" listStyleType="none">
            {mock.map((obj, idx) => (
              <List.Item>
                <Card
                  className={styles.courseContainer}
                  shadow="sm"
                  radius="md"
                >
                  <ThemeIcon color="teal" size={48} radius="xl">
                    <CheckCircledIcon style={{ width: 48, height: 48 }} />
                  </ThemeIcon>
                  <Group className={styles.course}>
                    <Text className={styles.title}>{obj.name}</Text>
                    <Text className={styles.description}>
                      {obj.description}
                    </Text>
                  </Group>
                </Card>
              </List.Item>
            ))}
          </List>
          <Modal
            opened={modalState}
            onClose={() => {
              setModalState(false);
            }}
            title="New Course"
          >
            <CourseForm closeModal={() => setModalState(false)} />
          </Modal>
        </>
      )}
    </div>
  );
};

export default DisciplinePage;
