package com.qrteam.QResent.dto;

public class QrDataDTO {
    public Integer courseId;
    public Long securityCode;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Long getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Long securityCode) {
        this.securityCode = securityCode;
    }

    public QrDataDTO(Integer courseId, Long securityCode) {
        this.courseId = courseId;
        this.securityCode = securityCode;
    }
}
