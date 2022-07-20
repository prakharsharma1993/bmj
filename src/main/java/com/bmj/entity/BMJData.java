package com.bmj.entity;


import javax.persistence.*;

@Entity
@Table(name = "tb_bmj")
public class BMJData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String courseName;

    private Double courseHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(Double courseHours) {
        this.courseHours = courseHours;
    }
}
