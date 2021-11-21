import { Button, Card, Group, Modal, Text, ThemeIcon } from "@mantine/core";
import { CheckCircledIcon } from "@radix-ui/react-icons";
import React, { useState } from "react";
import styles from "./CourseCard.module.css";
import axios from "axios";
import { MAIN_URL } from "../../utils/url";
import { useSelector } from "react-redux";

const CourseCard = ({ name, description, courseId, ...props }) => {
  const [QR, setQR] = useState({});
  const [qrModal, setQrModal] = useState(false);

  const getQrCode = async () => {
    let ENDPOINT = "get-QR";
    await axios
      .post(MAIN_URL + ENDPOINT, { courseId: courseId })
      .then((res) => {setQR(res.data); console.log(res.data)});
  };

  return (
    <>
      <Card className={styles.courseContainer} shadow="sm" radius="md">
        <ThemeIcon color="teal" size={48} radius="xl">
          <CheckCircledIcon style={{ width: 48, height: 48 }} />
        </ThemeIcon>
        <Group className={styles.course}>
          <Text className={styles.title}>{name}</Text>
          <Text className={styles.description}>{description}</Text>
        </Group>
        <div>
          <Button
            className={styles.qrCodeButton}
            onClick={() => {
              getQrCode();
              setQrModal(true);
            }}
          >
            QR CODE
          </Button>
          <Button color="red">Close</Button>
        </div>
      </Card>
      <Modal opened={qrModal} onClose={() => setQrModal(false)} title={name} size="lg">
        <div className="qr">
          <img src={"data:image/png;base64, " + QR} alt="QR" />
        </div>
      </Modal>
    </>
  );
};

export default CourseCard;
