package com.jsp;

import java.io.IOException;

import javax.persistence.Entity;
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
@WebServlet("/createaccount")
public class CreateAccount extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String phoneNo=req.getParameter("phoneNo");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		int id1=Integer.parseInt(id);
		long phoneNo1=Long.parseLong(phoneNo);
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("Gan");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Principal p = new Principal() ;
		p.setId(id1);
		p.setName(name);
		p.setEmail(email);
		p.setPhoneNo(phoneNo1);
		p.setPassword(password);
		et.begin();
		em.persist(p);
		et.commit();
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}
}
