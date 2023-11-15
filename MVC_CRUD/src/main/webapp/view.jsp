
<%@page import="dto.Course"%>
<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
    <table border="1px">
        <tr>
            <td>id</td>
          <td>sname</td>
            <td>C_ename</td>
        </tr>

        <%
            List<Student> records = (List<Student>) request.getAttribute("records");

            for (Student course1 : records) {
        %>
        <tr>
            <td><%=course1.getId()%></td>
            <td><%=course1.getSname()%></td>
              <td><%=course1.getCourse().getC_ename()%></td>
           <td><a href="delete?id=<%=course1.getId()%>"><button>delete</button></a></td>
            <td><a href="Update.jsp?id=<%=course1.getId()%>"><button>update</button></a></td>
        </tr>
        <%
            }
        %>
    </table>
  
</body>
</html>