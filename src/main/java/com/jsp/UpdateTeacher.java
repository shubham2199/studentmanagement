package com.jsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updateteacher")
public class UpdateTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String salary=req.getParameter("salary");
		int id1=Integer.parseInt(id);
		double salary1=Double.parseDouble(salary);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gan");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Teacher t=new Teacher();
		t.setId(id1);
		t.setName(name);
		t.setSubject(subject);
		t.setSalary(salary1);
		et.begin();
		em.merge(t);
		et.commit();
		RequestDispatcher rd=req.getRequestDispatcher("teacher.html");
		rd.forward(req, resp);
		
	}
}
