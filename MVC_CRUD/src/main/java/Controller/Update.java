package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDao.studentdao;
import dto.Course;
import dto.Student;

@WebServlet("/edit")
public class Update extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		student std=new student();
//		std.setId(Integer.parseInt(req.getParameter("id")));
//		std.setMobile(Integer.parseInt(req.getParameter("mobile")));
//		std.setName(req.getParameter("name"));
//        std.setGender(req.getParameter("age"));
//        studentdao dao=new studentdao();
//        dao.edit(std);
//        List<student> list=dao.fetch();
//        req.getSession().setAttribute("list",list);
//        resp.sendRedirect("view.jsp");

	Student student=new Student();
	student.setId(Integer.parseInt(req.getParameter("id")));
	student.setSname(req.getParameter("name"));
	Course course=new Course();
	course.setC_ename(req.getParameter("subject"));
	course.setStudent(student);
	student.setCourse(course);
	
	
	studentdao dao=new studentdao();
	 dao.edit(student);
	    List<Student> list=dao.fetch();
      req.getSession().setAttribute("list",list);



  	resp.getWriter().print("<h1 style='color:green'> Data updated Successfully</h1>");



  	req.getRequestDispatcher("Crud.html").include(req, resp);
  	
	}

}
//}
