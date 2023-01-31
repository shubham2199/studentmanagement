package com.jsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/viewstudent")
public class ViewStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Gan");
		EntityManager em=emf.createEntityManager();
		Student s=em.find(Student.class, id);
		HttpSession hs=req.getSession();
		hs.setAttribute("view", s);
		RequestDispatcher rd=req.getRequestDispatcher("displaystudent.jsp");
		rd.forward(req, resp);
		
	}
}
