import React from "react";
import DisciplineCard from "./DisciplineCard";
import styles from "./DisciplineList.module.css";

const mock = [
  { name: "Materia de cacat 1", description: "E marfa tare nimeni nu doarme" },
  { name: "Sa-mi bag pula in gura mea", description: "Salutare mos craciun" },
  { name: "Arpede", description: "Salutare mos craciun" },
];

const DisciplineList = () => {
  return (
    <div className={styles.list}>
      {mock.map((obj, index) => (
        <DisciplineCard
          key={index}
          name={obj.name}
          description={obj.description}
        />
      ))}
    </div>
  );
};

export default DisciplineList;
