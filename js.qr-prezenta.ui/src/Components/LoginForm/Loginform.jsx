import React, {useState} from "react";
import { Button, PasswordInput, TextInput } from '@mantine/core';
import styles from './Loginform.module.css';
import axios from 'axios';

const LoginForm = (props) => {

    const [formData, setFormData] = useState({email: "", password: ""});

    return (
        <div className={props.className}>
            
            <TextInput className={styles.field} placeholder="Email" label="Email" required onChange={ (event) => {
                setFormData(prev => ({...prev, email: event.target.value }) )}}/>
            <PasswordInput className={styles.field} label="Password" placeholder="Password" required onChange={ (event) => {
                setFormData(prev => ({...prev, password: event.target.value }) )}}/>
            <Button color="violet" radius="lg" uppercase fullWidth onClick={ () => {

                validateStudentEmail(formData.email) ? 
                    axios.post('http://localhost:8080/get-student-data',{email:formData.email, password:formData.password})
                    .then(res => {
                        })
                : validateProfessorEmail(formData.email) ?
                    axios.post('http://localhost:8080/get-profesor-data',{email:formData.email, password:formData.password})
                    .then(res => {
                        })
                : validateAdminEmail(formData.email) &&
                    axios.post('http://localhost:8080/get-admin-data',{email:formData.email, password:formData.password})
                    .then(res => {
                        })
                
            }}>
                login
            </Button>
        </div>
    );
}

const validateStudentEmail = (email) => 
{
    var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.stud+\.+ro+$/;
    return re.test(email);
}

const validateProfessorEmail = (email) => 
{
    var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.prof+\.+ro+$/;
    return re.test(email);
}
const validateAdminEmail = (email) => 
{
    var re = /^([a-zA-Z0-9_.-]{3,})+@facultate+\.admin+\.+ro+$/;
    return re.test(email);
}

export default LoginForm;