<%@page import="com.jsp.Student"%>
<%@page import="java.io.PrintWriter"%>

<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
<link rel="stylesheet" href="ForrmResponsive.css" />
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jayesh");
	EntityManager em = emf.createEntityManager();
	Student s=em.find(Student.class, id);
	%>
<div class="container">
      <h1 class="form-title">Update Student</h1>
      <form action="updatestudent" method="post">
        <div class="main-user-info">
        <div class="user-input-box">
            <label for="id">Id</label>
            <input type="text"
                    id="id"
                    name="id"
                    value="<%=s.getId()%>"/>
          </div>
          <div class="user-input-box">
            <label for="name">Name</label>
            <input type="text"
                    id="name"
                    name="name"
                    value="<%=s.getName()%>"/>
          </div>
          <div class="user-input-box">
            <label for="stream">Stream</label>
            <input type="text"
                    id="stream"
                    name="stream"
                    value="<%=s.getStream()%>"/>
          </div>
          <div class="user-input-box">
            <label for="fees">Fees</label>
            <input type="text"
                    id="fees"
                    name="fees"
                    value="<%=s.getFees()%>"/>
          </div>
        </div>
        <div class="form-submit-btn">
          <input type="submit" value="Submit">
        </div>
      </form>
    </div>	
</body>
</html>