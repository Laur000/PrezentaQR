import React, { useState } from "react";

const UserContext = React.createContext([null, () => {}]);

const UserProvider = (props) => {
  const [state, setState] = useState(null);

  return (
    <UserContext.Provider value={[state, setState]}>
      {props.children}
    </UserContext.Provider>
  );
};

export { UserContext, UserProvider };
