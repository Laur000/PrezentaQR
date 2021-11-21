import React from "react";
import DisciplineCard from "./DisciplineCard";
import { useSelector, useDispatch } from "react-redux";
import styles from "./DisciplineList.module.css";
import { getProfDisciplines } from "../../store/profDisciplineSlice";
import { Skeleton } from "@mantine/core";

const loadingInterface = () => {
  return (
    <div style={{ display: "flex", padding: 10 }}>
      <Skeleton height={200} width={300} mr={15} radius="xs" />
      <Skeleton height={200} width={300} mr={15} radius="xs" />
      <Skeleton height={200} width={300} mr={15} radius="xs" />
    </div>
  );
};

const DisciplineList = () => {
  const dispatch = useDispatch();
  const user = useSelector((state) => state.user.userData);
  const userType = useSelector((state) => state.user.userType);

  const profDisciplines = useSelector(
    (state) => state.profDisciplines.disciplines
  );
  
  React.useEffect(() => {
    setTimeout(() => {
      dispatch(getProfDisciplines({ email: user.email, userType }));
    }, 500);
  }, []);

  return (
    <div className={styles.list}>
      {!profDisciplines && loadingInterface()}
      {profDisciplines?.map((obj) => (
        <DisciplineCard
          key={obj.id}
          id={obj.id}
          name={obj.nume}
          description={obj.detalii}
        />
      ))}
    </div>
  );
};

export default DisciplineList;
