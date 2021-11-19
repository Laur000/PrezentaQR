import { configureStore } from "@reduxjs/toolkit";
import profDisciplineReducer from "./profDisciplineSlice";
import userReducer from "./userSlice";

export const store = configureStore({
  reducer: {
    user: userReducer,
    profDisciplines: profDisciplineReducer,
  },
});
