import { Button, Card, Group, Text, ThemeIcon } from "@mantine/core";
import { CheckCircledIcon } from "@radix-ui/react-icons";
import React from "react";
import styles from "./CourseCard.module.css";

const CourseCard = ({ name, description, ...props }) => {
  return (
    <Card className={styles.courseContainer} shadow="sm" radius="md">
      <ThemeIcon color="teal" size={48} radius="xl">
        <CheckCircledIcon style={{ width: 48, height: 48 }} />
      </ThemeIcon>
      <Group className={styles.course}>
        <Text className={styles.title}>{name}</Text>
        <Text className={styles.description}>{description}</Text>
      </Group>
      <div>
        <Button className={styles.qrCodeButton}>QR CODE</Button>
        <Button color="red">Close</Button>
      </div>
    </Card>
  );
};

export default CourseCard;
