<%@page import="com.jsp.Teacher"%>
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
<title>Update Teacher</title>
<link rel="stylesheet" href="ForrmResponsive.css" />
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jayesh");
	EntityManager em = emf.createEntityManager();
	Teacher t = em.find(Teacher.class, id);
	%>
<div class="container">
      <h1 class="form-title">Update Teacher</h1>
      <form action="updateteacher" method="post">
        <div class="main-user-info">
        <div class="user-input-box">
            <label for="id">Id</label>
            <input type="text"
                    id="id"
                    name="id"
                    value="<%=t.getId()%>"/>
          </div>
          <div class="user-input-box">
            <label for="name">Name</label>
            <input type="text"
                    id="name"
                    name="name"
                    value="<%=t.getName()%>"/>
          </div>
          <div class="user-input-box">
            <label for="subject">Subject</label>
            <input type="text"
                    id="subject"
                    name="subject"
                    value="<%=t.getSubject()%>"/>
          </div>
          <div class="user-input-box">
            <label for="salary">Salary</label>
            <input type="text"
                    id="salary"
                    name="salary"
                    value="<%=t.getSalary()%>"/>
          </div>
        </div>
        <div class="form-submit-btn">
          <input type="submit" value="Submit">
        </div>
      </form>
    </div>	
</body>
</html>