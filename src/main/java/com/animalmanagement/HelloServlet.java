package com.animalmanagement;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.animalmanagement.AnimalManagement;
import com.animalmanagement.controller.AnimalController;
import com.animalmanagement.controller.DogController;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimalManagement animalManagement = new AnimalManagement();
		
		//List<Animals> animals = cont.getanimals();
		//out.println(animals);
		String name = request.getParameter("name");
		PrintWriter pw = response.getWriter();
		String s = request.getParameter("colour");
		pw.println("<style font-color:#ff00ff><h5> Your name is =<br></style>" + s);
		//s = request.getParameter("t2");
		//pw.println("<h5> Your Fathers Name is =<br>" + s);
		//s = request.getParameter("t3");
		//pw.println("<h5> Your address is =<br>" + s);
		//s = request.getParameter("t4");
		//pw.println("<h5>Your living state is =<br>" + s);
		//s = request.getParameter("t5");
		//pw.println("<h1> Your are living in<br>" + s);
				}

}
