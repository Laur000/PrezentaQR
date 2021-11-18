import { Button } from "@mantine/core";
import React from "react";
import { ArrowLeftIcon } from "@radix-ui/react-icons";
import { useHistory } from "react-router";

const DisciplinePage = (props) => {
  const params = props.match.params;
  const history = useHistory();

  return (
    <div>
      <Button
        leftIcon={<ArrowLeftIcon />}
        variant="white"
        style={{ background: "transparent", padding: 0}}
        onClick={() => history.goBack()}
      >
        Back to Disciplines
      </Button>
      <h1>{params.id}</h1>
    </div>
  );
};

export default DisciplinePage;
