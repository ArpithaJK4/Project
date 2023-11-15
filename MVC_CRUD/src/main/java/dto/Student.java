package dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student 
{
@Id
@GeneratedValue
 private int id;
 private String sname;
 
 @OneToOne(cascade=CascadeType.PERSIST)
 @JoinColumn(name="id")
 private Course course;
 
 
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}

}