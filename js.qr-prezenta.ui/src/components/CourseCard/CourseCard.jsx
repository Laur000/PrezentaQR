import { Button, Card, Group, Modal, Text, ThemeIcon } from "@mantine/core";
import { CheckCircledIcon } from "@radix-ui/react-icons";
import React, { useState } from "react";
import styles from "./CourseCard.module.css";
import axios from "axios";
import { useSelector } from "react-redux";
import { MAIN_URL } from "../../utils/url";
import AttendanceChart from "../AttendanceChart/AttendanceChart";

const CourseCard = ({ name, description, courseId, ...props }) => {
  const userType = useSelector((state) => state.user.userType);

  const [QR, setQR] = useState({});
  const [qrModal, setQrModal] = useState(false);
  const [PDF, setPDF] = useState({});
  const [pdfModal, setPdfModal] = useState(false);
  const [attendanceData, setAttendanceData] = useState(0);

  const getQrCode = async () => {
    let ENDPOINT = "get-QR";
    await axios
      .post(MAIN_URL + ENDPOINT, { courseId: courseId })
      .then((res) => {
        setQR(res.data);
      });
  };
  const getAttendanceData = () => {
    let ENDPOINT = "get-attendance";
    setInterval(() => {
      axios.post(MAIN_URL + ENDPOINT, { courseId: courseId }).then((res) => {
        setAttendanceData(res.data.length);
      });
    }, 5000);
  };
  const exportAttendance = async () => {
    let ENDPOINT = "export-attendance-list";
    await axios.post(MAIN_URL + ENDPOINT, { cursId: courseId }).then((res) => {
      setPDF(res.data);
    });
  };

  React.useEffect(() => {

    attendanceData && getAttendanceData();
  }, [attendanceData]);

  return (
    <>
      <Card shadow="sm" radius="md">
        <Card.Section className={styles.courseContainer}>
          <ThemeIcon color="teal" size={48} radius="xl">
            <CheckCircledIcon style={{ width: 48, height: 48 }} />
          </ThemeIcon>
          <Group className={styles.course}>
            <Text className={styles.title}>{name}</Text>
            <Text className={styles.description}>{description}</Text>
          </Group>
          {userType !== "student" && (
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
              <Button
                color="red"
                onClick={() => {
                  exportAttendance();
                  setPdfModal(true);
                }}
              >
                View Attendance
              </Button>
            </div>
          )}
        </Card.Section>
        <Card.Section style={{ height: 200, display: "flex", justifyContent: "center"  }}>
          <div style={{ width: 400}}>
          <AttendanceChart data={attendanceData} />
          </div>
        </Card.Section>
      </Card>
      <Modal
        opened={qrModal}
        onClose={() => setQrModal(false)}
        title={name}
        size="lg"
      >
        <div className="qr">
          <img src={"data:image/png;base64, " + QR} alt="QR" />
        </div>
      </Modal>
      <Modal
        opened={pdfModal}
        onClose={() => setPdfModal(false)}
        title={name}
        size="70%"
      >
        <div className="qr">
          <iframe
            src={"data:application/pdf;base64," + PDF}
            height="650px"
            width="900px"
          />
        </div>
      </Modal>
    </>
  );
};

export default CourseCard;
