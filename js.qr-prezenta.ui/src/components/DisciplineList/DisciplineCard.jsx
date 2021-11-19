import React from "react";
import {
  Card,
  Image,
  Text,
  Badge,
  Button,
  Group,
  useMantineTheme,
} from "@mantine/core";
import img from "../../assets/discipline-img.jpg";
import { Link } from "react-router-dom";

const DisciplineCard = ({ name, description, id }) => {
  const theme = useMantineTheme();
  const secondaryColor =
    theme.colorScheme === "dark" ? theme.colors.dark[1] : theme.colors.gray[7];

  return (
    <div style={{ width: 340, margin: "10px" }}>
      <Card shadow="sm" padding="lg">
        <Card.Section>
          <Image src={img} height={160} alt="Discipline" />
        </Card.Section>

        <Group
          position="apart"
          style={{ marginBottom: 5, marginTop: theme.spacing.sm }}
        >
          <Text weight={500}>{name}</Text>
          <Badge color="green" variant="light">
            On Going
          </Badge>
        </Group>

        <Text size="sm" style={{ color: secondaryColor, lineHeight: 1.5 }}>
          {description}
        </Text>

        <Button
          component={Link}
          to={"/dashboard/discipline/" + id}
          variant="light"
          color="blue"
          fullWidth
          style={{ marginTop: 14 }}
        >
          Launch
        </Button>
      </Card>
    </div>
  );
};

export default DisciplineCard;
