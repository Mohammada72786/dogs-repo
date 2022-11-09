package com.animalmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.animalmanagement.model.Breed;
import com.animalmanagement.model.PetStore;
import com.animalmanagement.service.PetStoreService;
import com.animalmanagement.service.impl.PetStoreServiceImpl;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.exception.AnimalManagementException;

/**
 * Servlet implementation class PetStoreServlet
 */
@WebServlet(urlPatterns={"/displaypetstoresbyname"})
public class PetStoreServlet extends HttpServlet {
	PetStoreService petStoreService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		petStoreService = new PetStoreServiceImpl();
	}
    public PetStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter printWriter = response.getWriter();
		printWriter.println("here i am in get method");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
		//case "/insertPetStore":
		//	insertPetStore(request, response);
		//	break;
		case"/displaypetstoresbyname":
			getPetStoresByName(request,response);
			break;
		case"/getPetStoreById":
			//getPetStoreById(request, response);
			break;
		case"/updatePetStore":
			//updatePetStoreById(request, response);
			break; 
		case"/deletePetStoreById":
			//deletePetStoreById(request, response);
			break;
		default:
			PetLogger.error("Something went wrong");
		}
	}
	private void getPetStoresByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<PetStore> petStores = petStoreService.getPetStoresByName(request.getParameter("name"));
			HttpSession session = request.getSession();
    		session.setAttribute("petStores" , petStores);
    		response.sendRedirect("displaypetstores.jsp");		
		} catch(AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
	}
}
