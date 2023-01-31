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
@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String stream=req.getParameter("stream");
		String fees=req.getParameter("fees");
		int id1=Integer.parseInt(id);
		double fees1=Double.parseDouble(fees);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gan");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s=new Student();
		s.setId(id1);
		s.setName(name);
		s.setStream(stream);
		s.setFees(fees1);
		et.begin();
		em.merge(s);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("student.html");
		rd.forward(req, resp);
		
	}
}
