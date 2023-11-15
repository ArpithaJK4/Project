package StudentDao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Course;
import dto.Student;


public class studentdao 
{
   EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
   EntityManager manager=emf.createEntityManager();
   EntityTransaction transaction=manager.getTransaction();
public void save(Student std) 
{
	transaction.begin();
	manager.persist(std);
	transaction.commit();
	
}
public Student fetchByname(String name) 
{
	
	List<Student> list=manager.createQuery("select x from  Student x  where sname=?1").setParameter(1, name)
.getResultList();
	if(list.isEmpty())
	return null;
	
	else {
		return list.get(0);
	}
	// TODO Auto-generated method stub
//	return manager.createQuery("select x from student x").getResultList();
	
}

public List<Student> fetch() {
	
	return manager.createQuery("select x from Student x ").getResultList();
}

public void delete(int id) {
	transaction.begin();
	manager.remove(manager.find(Student.class , id));
	transaction.commit();
	
}
public void edit(Student std) 
{
transaction.begin();
manager.merge(std);
transaction.commit();
	
}

public List<Course> fetch1() {
	
	return manager.createQuery("select x from Course x ").getResultList();
}


}
  
   
