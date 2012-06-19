package br.com.hotel.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hotel.domain.Hotel;
import br.com.hotel.integration.HotelIntegrationFilter;
import br.com.hotel.integration.HotelIntegrationService;

/**
 * Servlet implementation class Temp
 */
@WebServlet("/hotel")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	@EJB
	private HotelIntegrationService hotelIntegrationService;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		List<Hotel> hotels =
				hotelIntegrationService.getHotels(
						new HotelIntegrationFilter(
								Integer.valueOf(request.getParameter("stars")),
								request.getParameter("region")
								)
						);


		request.setAttribute("hotels", hotels);
		request.getRequestDispatcher("hotels.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hotelIntegrationService.getHotels( new HotelIntegrationFilter(3, "Brasil"));
	}

}
