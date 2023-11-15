package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDao.studentdao;
import dto.Student;


@WebServlet("/delete")
public class Delete extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int id2 =Integer.parseInt(req.getParameter("id"));

	studentdao dao4=new studentdao();
	 dao4.delete(id2);

		List<Student>list=dao4.fetch();

		req.getSession().setAttribute("list", list);

	resp.getWriter().print("<h1 style='color:green'> Data Deleted Successfully</h1>");




	req.getRequestDispatcher("Crud.html").include(req, resp);
	
}
}
