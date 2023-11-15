package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDao.studentdao;

import dto.Course;
import dto.Student;

@WebServlet("/StudentServlet")
public class Crud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String action = req.getParameter("action");

		if ("create".equals(action)) {
			studentdao dao1 = new studentdao();
			Student student = dao1.fetchByname(name);
			if (student == null) {
				student = new Student();
				student.setSname(name);
				Course course = new Course();
				course.setC_ename(subject);
				course.setStudent(student);
				student.setCourse(course);

				studentdao dao = new studentdao();
				dao.save(student);
				res.getWriter().print("<h1 style='color:green'> Data inserted Successfully</h1>");
				req.getRequestDispatcher("Crud.html").include(req, res);

			} else {
				res.getWriter().print("<h1 style='color:red'>Student Alredy Exists</h1>");
				req.getRequestDispatcher("Crud.html").include(req, res);
			}
		}

		else if ("read".equals(action)) {
			studentdao dao2 = new studentdao();

			req.setAttribute("records", dao2.fetch());

			req.getRequestDispatcher("view.jsp").include(req, res);

		} else if ("delete".equals(action)) {

			int id2 = Integer.parseInt(req.getParameter("id"));

			studentdao dao4 = new studentdao();
			dao4.delete(id2);

			List<Student> list = dao4.fetch();

			req.getSession().setAttribute("list", list);

			res.getWriter().print("<h1 style='color:green'> Data Deleted Successfully</h1>");

			req.getRequestDispatcher("view.jsp").include(req, res);
		} else if ("update".equals(action)) {

			Student student = new Student();
			student.setId(Integer.parseInt(req.getParameter("id")));
			student.setSname(req.getParameter("name"));
			Course course = new Course();
			course.setC_ename(req.getParameter("subject"));
			course.setStudent(student);
			student.setCourse(course);

			studentdao dao = new studentdao();
			dao.edit(student);
			List<Student> list = dao.fetch();
			req.getSession().setAttribute("list", list);

			res.getWriter().print("<h1 style='color:green'> Data updated Successfully</h1>");

			req.getRequestDispatcher("Crud.html").include(req, res);

		}

		else {

			res.getWriter().print("<h1 style='color:red'> Invalid Operation </h1>");
		}
	}
}
