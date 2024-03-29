package com.baboci.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_professor")
@Getter
@Setter
public class Professor implements Serializable{

    @Column(name = "professor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "professor_name")
    private String name;
    @Column(name = "professor_gender")
    private String gender;
    @Column(name = "professor_dep")
    private String department;

    @OneToMany(mappedBy="professorID",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JsonManagedReference
    private List<Course> courseList;

    //bi-directional many-to-one association to User
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
            mappedBy = "professor")
    private User user;

    public Professor(){

    }

    public Professor(String name, String gender, String department, List<Course> courseList) {
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.courseList = courseList;
    }

    @Override
    public String toString(){
        return "Professor [id=" + id + ", name=" + name + ", gender=" + gender +
                ", department=" + department + "]";
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
