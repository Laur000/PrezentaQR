import React from "react";
import { Button, PasswordInput, TextInput } from '@mantine/core';
import styles from './Loginform.module.css';

const LoginForm = (props) => {

    return (
        <div className={props.className}>
            
            <TextInput className={styles.field} placeholder="Username" label="Username" required />
            <PasswordInput className={styles.field} label="Password" placeholder="Password" required />
            <Button color="violet" radius="lg" uppercase fullWidth onClick={() => {
                const requestOptions = {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ id:'1'})
                };
                fetch('http://localhost:8080/get-student-data',requestOptions)
                .then(response => response.json())
                .then(data => console.log(data));
            }}>
                login
            </Button>
        </div>
    );
}

export default LoginForm;