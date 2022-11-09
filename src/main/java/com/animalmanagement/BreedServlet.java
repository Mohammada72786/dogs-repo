package com.animalmanagement;

import java.io.IOException;
import java.util.List;

import com.animalmanagement.model.Breed;
import com.animalmanagement.service.BreedService;
import com.animalmanagement.service.impl.BreedServiceImpl;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.exception.AnimalManagementException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class BreedServlet
 * 
 */
@WebServlet(urlPatterns={"/displaybreedsbyname"})
public class BreedServlet extends HttpServlet {
	BreedService breedService;
	
	public void init() {
		breedService = new BreedServiceImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BreedServlet() {
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
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
//		case "/insertDog":
//			insertBreed(request, response);
//			break;
		case"/displaybreedsbyname":
			getBreedsByName(request,response);
			break;
//		case"/getDogByDogCode":
//			getBreedById(request, response);
//			break;
//		case"/updateDog":
//			updateBreedById(request, response);
//			break; 
//		case"/deletedogbydogcode":
//			deleteBreedById(request, response);
//			break;
		default:
			PetLogger.error("Something went wrong");
		}
	}
	private void getBreedsByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Breed> breeds = breedService.getBreedsByName(request.getParameter("name"));
			HttpSession session = request.getSession();
    		session.setAttribute("breeds",breeds);
    		response.sendRedirect("displaybreeds.jsp");		
		} catch(AnimalManagementException exception) {
			
		}
	}

}
