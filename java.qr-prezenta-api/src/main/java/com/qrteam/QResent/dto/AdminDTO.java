package com.qrteam.QResent.dto;

import com.qrteam.QResent.models.Curs;

import java.util.List;

public class AdminDTO {
    List<Curs> allcourses;

    public AdminDTO() {

    }

    public AdminDTO(List<Curs> allcourses) {
        this.allcourses = allcourses;
    }

    public List<Curs> getAllcourses() {
        return allcourses;
    }

    public void setAllcourses(List<Curs> allcourses) {
        this.allcourses = allcourses;
    }

    public void addCurs(Curs curs) {
        this.allcourses.add(curs);
    }

    public void removeCurs(Integer id) {
        for (Curs curs : allcourses) {
            if (curs.getCursId() == id) {
                this.allcourses.remove(curs);
            }
        }
    }
}
