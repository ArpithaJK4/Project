package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="StudentCourse")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String C_ename;
	@OneToOne(mappedBy="course")
private Student student;
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_ename() {
		return C_ename;
	}

	public void setC_ename(String c_ename) {
		C_ename = c_ename;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", C_ename=" + C_ename + ", student=" + student + "]";
	}
	
	
}