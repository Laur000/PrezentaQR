import LoginForm from "../../Components/LoginForm/Loginform";
import styles from "./Login.module.css";
import React from "react";
const Login = () => {
  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <h1 className={styles.title}> QR Attendance </h1>
        <LoginForm className={styles.loginForm} />
      </div>
    </div>
  );
};

export default Login;
