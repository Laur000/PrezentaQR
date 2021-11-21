import { Button, List, Loader, Modal, Skeleton } from "@mantine/core";
import React, { useState } from "react";
import { ArrowLeftIcon } from "@radix-ui/react-icons";
import { useHistory } from "react-router";
import { useSelector, useDispatch } from "react-redux";
import CourseForm from "../../components/CourseForm/CourseForm";
import styles from "./DisciplinePage.module.css";

import {
  deleteCourses,
  getProfDisciplineCourses,
} from "../../store/profDisciplineSlice";
import CourseCard from "../../components/CourseCard/CourseCard";

const loadingInterface = () => {
  return (
    <>
      {Array(5)
        .fill(0)
        .map(() => (
          <Skeleton height={100} mt={16} radius="xs" />
        ))}
    </>
  );
};

const DisciplinePage = (props) => {
  const params = props.match.params;
  const history = useHistory();
  const dispatch = useDispatch();

  const [modalState, setModalState] = useState(false);
  const [selectedDiscipline, setSelectedDiscipline] = React.useState(null);

  const courses = useSelector((state) => state.profDisciplines.courses);
  const disciplines = useSelector((state) => state.profDisciplines.disciplines);
  const loading = useSelector((state) => state.profDisciplines.loading);

  React.useEffect(() => {
    setSelectedDiscipline(
      disciplines.find((obj) => obj.id === parseInt(params.id))
    );

    dispatch(deleteCourses());

    dispatch(getProfDisciplineCourses({ disciplineId: params.id }));
  }, [params]);

  const loadingDiscipline = () =>
    !(selectedDiscipline && selectedDiscipline.id === parseInt(params.id));

  return (
    <div>
      {!loadingDiscipline() && (
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
          <p
            style={{
              margin: "0px 20px 20px 20px",
              maxWidth: 450,
              whiteSpace: "pre-line",
            }}
          >
            {selectedDiscipline.detalii}
          </p>
          <List spacing="md" listStyleType="none">
            {!loading &&
              courses &&
              courses.map((obj, index) => (
                <List.Item key={index}>
                  <CourseCard name={obj.nume} description={obj.detalii} courseId={obj.cursId} />
                </List.Item>
              ))}
          </List>
          {!loading && courses?.length === 0 && (
            <h1
              style={{ textAlign: "center", marginTop: "8rem", width: "100%" }}
            >
              You have no courses yet.
            </h1>
          )}
          <Modal
            opened={modalState}
            onClose={() => {
              setModalState(false);
            }}
            title="New Course"
          >
            <CourseForm
              closeModal={() => setModalState(false)}
              selectedDiscipline={selectedDiscipline}
              disciplineId={params.id}
            />
          </Modal>
        </>
      )}
    </div>
  );
};

export default DisciplinePage;
