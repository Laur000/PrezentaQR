import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

import { MAIN_URL } from "../utils/url";

export const getProfDisciplines = createAsyncThunk(
  "profDiscipline/getDisciplines",
  async ({ email }) => {
    let ENDPOINT = "get-prof-disciplines";

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

    const response = await axios.post(MAIN_URL + ENDPOINT, {
      disciplineId,
    });

    console.log(response);
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
    deleteDisciplines: (state, action) => {
      state.disciplines = null;
    },
    deleteCourses: (state, _) => {
      state.courses = null;
    },
  },
  extraReducers: {
    [getProfDisciplines.pending]: (state, action) => {
      state.loading = true;
    },
    [getProfDisciplines.fulfilled]: (state, action) => {
      state.disciplines = action.payload;
      state.loading = false;
    },
    [getProfDisciplineCourses.fulfilled]: (state, action) => {
      state.courses = action.payload;
      state.loading = false;
    },
  },
});

export const { deleteDisciplines, deleteCourses} =
  profDisciplineSlice.actions;
export default profDisciplineSlice.reducer;
