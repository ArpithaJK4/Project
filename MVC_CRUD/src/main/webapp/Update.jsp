<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input, select {
            margin-bottom: 15px;
            padding: 8px;
            width: 200px;
        }
        button {
            padding: 10px;
            cursor: pointer;
        }
        </style>
</head>
<body>


<%
int id=Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
String course=request.getParameter("subject");%>


   <h1>Enter Student Details</h1>
<form action="edit" method="get">

    <label for="id">ID:</label>
    <input type="number" id="id" name="id" value="<%=id%>">

    <label for="name">Student:</label>
    <input type="text" id="Name" name="name" value="<%=name%>">

    <label for="subject">Course:</label>
    <input type="text" id="subject" name="subject" value="<%=course%>">


      <button>Submit</button>
     
</form>


</body>
</html>