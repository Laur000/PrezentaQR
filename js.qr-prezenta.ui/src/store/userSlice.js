import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

import { MAIN_URL } from "../utils/url";

export const authenticateUser = createAsyncThunk(
  "user/authenticateUser",
  async ({ userType, formData }) => {
    let ENDPOINT = "get-student-data";

    if (userType === "student") {
      ENDPOINT = "get-student-data";
    } else if (userType === "teacher") {
      ENDPOINT = "get-profesor-data";
    } else if (userType === "admin") {
      ENDPOINT = "get-admin-data";
    }

    const response = await axios.post(MAIN_URL + ENDPOINT, {
      ...formData,
    });
    return response.data;
  }
);

export const userSlice = createSlice({
  name: "user",
  initialState: { userData: undefined, userType: "student" },
  reducers: {
    updateUserType: (state, action) => {
      state.userType = action.payload;
    },
  },
  extraReducers: {
    [authenticateUser.fulfilled]: (state, action) => {
      state.userData = action.payload === "" ? null : action.payload;
    },
  },
});

export const { updateUserType } = userSlice.actions;
export default userSlice.reducer;
