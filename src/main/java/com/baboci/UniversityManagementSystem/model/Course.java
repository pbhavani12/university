package com.baboci.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tbl_course")
@Getter
@Setter
public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_dep")
    private String department;

    @Column(name = "professor_name")
    private String professorName;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name="prof_id")
    @JsonBackReference
    private Professor professorID;

    @OneToMany(mappedBy="courseID",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Enrollment> enrollmentList;

    public Course(){

    }

    public Course(String courseName, String department, String professorName, List<Enrollment> enrollmentList) {
        this.courseName = courseName;
        this.department = department;
        this.professorName = professorName;
        this.professorID = new Professor();
        this.enrollmentList = enrollmentList;
    }

    public Course(String courseName, String department,String professorName) {
        this.courseName = courseName;
        this.department = department;
        this.professorName = professorName;
    }

    @Override
    public String toString(){
        return "Course [id=" + id + ", Course name=" + courseName +
                ", department=" + department + "]";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public Professor getProfessorID() {
		return professorID;
	}

	public void setProfessorID(Professor professorID) {
		this.professorID = professorID;
	}

	public List<Enrollment> getEnrollmentList() {
		return enrollmentList;
	}

	public void setEnrollmentList(List<Enrollment> enrollmentList) {
		this.enrollmentList = enrollmentList;
	}
}
