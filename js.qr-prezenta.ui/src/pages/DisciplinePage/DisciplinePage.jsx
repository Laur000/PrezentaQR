import { Button } from "@mantine/core";
import React from "react";
import { ArrowLeftIcon } from "@radix-ui/react-icons";
import { useHistory } from "react-router";
import axios from "axios";
import { MAIN_URL } from "../../utils/url";
import { useSelector } from "react-redux";

const DisciplinePage = (props) => {
  const params = props.match.params;
  const history = useHistory();
  const userEmail = useSelector((state) => state.user.userData.email);

  React.useEffect(() => {
    axios
      .post(MAIN_URL + "get-prof-disciplines", { email: userEmail })
      .then((response) => console.log(response.data));
  }, []);

  return (
    <div>
      <Button
        leftIcon={<ArrowLeftIcon />}
        variant="white"
        style={{ background: "transparent", padding: 0 }}
        onClick={() => history.goBack()}
      >
        Back to Disciplines
      </Button>
      <h1>{params.id}</h1>
    </div>
  );
};

export default DisciplinePage;
