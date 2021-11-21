import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

import { MAIN_URL } from "../utils/url";

export const getProfDisciplines = createAsyncThunk(
  "profDiscipline/getDisciplines",
  async ({ email, userType }) => {
    let ENDPOINT = "get-prof-disciplines";
    if (userType === "student") ENDPOINT = "get-student-disciplines";

    const response = await axios.post(MAIN_URL + ENDPOINT, {
      email,
    });
    return response.data;
  }
);

export const getProfDisciplineCourses = createAsyncThunk(
  "profDiscipline/getDisciplineCourses",
  async ({ disciplineId }) => {
    let ENDPOINT = "get-courses";
    const headers = {
      "Content-Type": "application/json",
    };

    const data = {
      disciplineId,
    };

    const response = await axios.post(MAIN_URL + ENDPOINT, data, { headers });

    return response.data;
  }
);

export const profDisciplineSlice = createSlice({
  name: "profDiscipline",
  initialState: {
    disciplines: null,
    courses: null,
    loading: false,
  },
  reducers: {
    deleteDisciplines: (state, _) => {
      state.disciplines = null;
    },
    deleteCourses: (state, _) => {
      state.courses = null;
    },
  },
  extraReducers: {
    [getProfDisciplines.fulfilled]: (state, action) => {
      state.disciplines = action.payload;
      state.loading = false;
    },
    [getProfDisciplineCourses.pending]: (state, action) => {
      state.loading = true;
    },
    [getProfDisciplineCourses.fulfilled]: (state, action) => {
      state.courses = action.payload;
      state.loading = false;
    },
  },
});

export const { deleteDisciplines, deleteCourses } = profDisciplineSlice.actions;
export default profDisciplineSlice.reducer;
