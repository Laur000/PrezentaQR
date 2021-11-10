package com.qrteam.QResent.dto;

public class SaveCourseDTO {

    private CursDTO cursDTO;
    private Integer disciplineId;

    public CursDTO getCursDTO() {
        return cursDTO;
    }

    public void setCursDTO(CursDTO cursDTO) {
        this.cursDTO = cursDTO;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }
}
