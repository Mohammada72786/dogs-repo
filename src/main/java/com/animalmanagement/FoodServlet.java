package com.animalmanagement;

import java.io.IOException;
import java.util.List;

import com.animalmanagement.model.Food;
import com.animalmanagement.service.FoodService;
import com.animalmanagement.service.impl.FoodServiceImpl;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.exception.AnimalManagementException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet(urlPatterns =  {"/displayfoodsbyids"})
public class FoodServlet extends HttpServlet {
	private FoodService foodService;
	public void init() {
		foodService = new FoodServiceImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getServletPath();
	    switch(action) {
	    case "/displayfoodsbyids":
	    	getFoodsByIds(request, response);
	    	break;
	    default:
	    	PetLogger.info("Wrong input");
	    	break;	
	    }
	}
	protected void getFoodsByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Food> foods = foodService.getFoodsByIds(request.getParameter("foodids"));
			HttpSession session = request.getSession();
			session.setAttribute("foods", foods);
			if(request.getParameter("source").equals("foodtoassign")) {
				response.sendRedirect("adddog.jsp");
			} else {
				//response.sendRedirect("adddog.jsp");
			}
		} catch(AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
	}

}
