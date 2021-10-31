import React, {useState} from "react";
import { Button, PasswordInput, TextInput } from "@mantine/core";
import styles from "./LoginForm.module.css";
import axios from 'axios';
import { UserContext } from "../../context/UserContext";

const LoginForm = (props) => {
    const [, setUser] = React.useContext(UserContext);
    const [formData, setFormData] = useState({ email: "", password: "" });

    const doesLogin = () => {

        validateStudentEmail(formData.email) ?
            axios.post('http://localhost:8080/get-student-data', { email: formData.email, password: formData.password })
                .then(res => {
                    setUser({ username: "Ionut" });
                })
            : validateProfessorEmail(formData.email) ?
                axios.post('http://localhost:8080/get-profesor-data', { email: formData.email, password: formData.password })
                    .then(res => {
                        setUser({ username: "Ionut" });
                    })
                : validateAdminEmail(formData.email) &&
                axios.post('http://localhost:8080/get-admin-data', { email: formData.email, password: formData.password })
                    .then(res => {
                        setUser({ username: "Ionut" });
                    })
    };

    const validateStudentEmail = (email) => {
        var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.stud+\.+ro+$/;
        return re.test(email);
    }
    
    const validateProfessorEmail = (email) => {
        var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.prof+\.+ro+$/;
        return re.test(email);
    }
    const validateAdminEmail = (email) => {
        var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.admin+\.+ro+$/;
        return re.test(email);
    }

    return (
        <div className={props.className}>
            <TextInput
                className={styles.field}
                placeholder="Username"
                label="Username"
                required
                onChange={event => setFormData(prev => ({ ...prev, email: event.target.value }))}
            />
            <PasswordInput
                className={styles.field}
                label="Password"
                placeholder="Password"
                required
                onChange={event => setFormData(prev => ({ ...prev, password: event.target.value }))}
            />
            <Button
                variant="gradient"
                gradient={{from:"teal", to:"#2b8a3e"}}
                radius="lg"
                uppercase
                fullWidth
                onClick={() => doesLogin()}
            >
                login
            </Button>
        </div>
    );
};

export default LoginForm;
