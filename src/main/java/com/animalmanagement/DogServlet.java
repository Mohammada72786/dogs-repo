package com.animalmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.service.DogService;
import com.animalmanagement.service.FoodService;
import com.animalmanagement.service.impl.DogServiceImpl;
import com.animalmanagement.service.impl.FoodServiceImpl;
import com.animalmanagement.util.PetLogger;
import com.animalmanagement.util.Validator;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DogServlet
 */

@WebServlet(urlPatterns = { "/insertDog", "/deletedogbydogcode", "/displayDogs", "/updatedog", "/getDogByDogCode",
		"/displaydogsbyids", "/assignfoodstodog" })
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DogService dogService;
	FoodService foodService;

	public void init() {
		dogService = new DogServiceImpl();
		foodService = new FoodServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/insertDog":
			insertDog(request, response);
			break;
		case "/displayDogs":
			displayDogsByName(request, response);
			break;
		case "/getDogByDogCode":
			getDogByDogCode(request, response);
			break;
		case "/updatedog":
			updateDog(request, response);
			break;
		case "/deletedogbydogcode":
			deleteDogByDogCode(request, response);
			break;
		case "/displaydogsbyids":
			getDogsByIds(request, response);
			break;
		case "/assignfoodstodog":
			assignFoodsToDog(request, response);
			break;
		default:
			PetLogger.error("Something went wrong");
		}
	}

	private void insertDog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			String name = request.getParameter("name");
			String colour = request.getParameter("colour");
			Gender gender = Gender.valueOf(request.getParameter("gender"));
			float weight = Float.parseFloat(request.getParameter("weight"));
			float speed = Float.parseFloat(request.getParameter("speed"));
			Date dateOfBirth = Validator.getDate(request.getParameter("dateofbirth"));
			pw.println(name + System.getProperty("line.separator") + weight);
			pw.println(weight);
			pw.println(speed);
			pw.println(dateOfBirth);
			pw.println(colour);
			pw.println(gender);
			Dog dog = dogService.insertDog(name, weight, colour, gender, dateOfBirth, speed);
			HttpSession session = request.getSession();
			session.setAttribute("dog", dog);
			response.sendRedirect("adddog.jsp");
		} catch (Exception exception) {
			pw.println(exception.toString());
		}
	}

	private void displayDogsByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Dog> dogs = dogService.getDogsByName(request.getParameter("name"));
			HttpSession session = request.getSession();
			session.setAttribute("dogs", dogs);
			response.sendRedirect("displaydogs.jsp");
		} catch (AnimalManagementException exception) {

		}
	}

	private void getDogByDogCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Dog dog = dogService.getDogByDogCode(request.getParameter("dogCode"));
			HttpSession session = request.getSession();
			session.setAttribute("dog", dog);
			if (request.getParameter("source").equals("deletedog")) {
				response.sendRedirect("deletedog.jsp");
			} else {
				response.sendRedirect("updatedog.jsp");
			}
		} catch (AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
	}

	private void updateDog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Dog dog = dogService.getDogByDogCode(request.getParameter("dogCode"));
			System.out.println(dog);
			dog.setName(request.getParameter("name"));
			dog.setWeight(Float.parseFloat(request.getParameter("weight")));
			dog.setColour(request.getParameter("colour"));
			dog.setGender(Gender.valueOf(request.getParameter("gender")));
			dog.setDob(Validator.getDate(request.getParameter("dateOfBirth")));
			dog.setSpeed(Float.parseFloat(request.getParameter("speed")));
			dog.setDogCode(request.getParameter("dogCode"));
			dog.setId(Integer.parseInt(request.getParameter("id")));
			System.out.println(dog);
			Dog updatedDog = dogService.updateDogByDogCode(dog);
			System.out.println(updatedDog);
			HttpSession session = request.getSession();
			session.setAttribute("updatedog", updatedDog);
			response.sendRedirect("updatedog.jsp");
		} catch (AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		} catch (ParseException exception) {
			PetLogger.error(exception.getMessage() + "Invalid date");
		}
	}

	public void deleteDogByDogCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			boolean flag = dogService.deleteDogByDogCode(request.getParameter("dogCode"));
			HttpSession session = request.getSession();
			session.setAttribute("flag", flag);
			response.sendRedirect("deletedog.jsp");
		} catch (AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
	}

	public void getDogsByIds(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dogIds = request.getParameter("dogids");
		try {
			List<Dog> dogs = dogService.getDogsByIds(dogIds);
			HttpSession session = request.getSession();
			session.setAttribute("dogs", dogs);
			response.sendRedirect("displaydogs.jsp");
		} catch (AnimalManagementException exception) {
			PetLogger.error(exception.getMessage());
		}
	}

	private void assignFoodsToDog(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Dog dog = dogService.getDogByDogCode(request.getParameter("dogcode"));
			List<Food> foods = foodService.getFoodsByIds(request.getParameter("foodids"));
			Dog updatedDog = dogService.assignFoodToDog(dog, foods);
			// dogService.updateDogByDogCode(dog);
			HttpSession session = request.getSession();
			session.setAttribute("dog", updatedDog);
			response.sendRedirect("adddog.jsp");
		} catch (AnimalManagementException exception) {
			PetLogger.fatal("error while assigning foods to dog" + exception.getMessage());
		}
	}
}
