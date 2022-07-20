package com.bmj.dto;


import java.util.List;

public class SearchDTO {


   private List<String> course;
   private Double hours;

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }


}
