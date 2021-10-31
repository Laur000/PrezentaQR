import React from "react";
import { Button, PasswordInput, TextInput } from '@mantine/core';
import styles from './Loginform.module.css';

const LoginForm = (props) => {

    return (
        <div className={props.className}>
            
            <TextInput className={styles.field} placeholder="Username" label="Username" required />
            <PasswordInput className={styles.field} label="Password" placeholder="Password" required />
            <Button color="violet" radius="lg" uppercase fullWidth>
                login
            </Button>
        </div>
    );
}

export default LoginForm;