package br.com.mystudies.web.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.domain.entity.BackLog;
import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.service.BackLogService;

/**
 * @author Robson
 */
@WebServlet("/backlog")
public class BacklogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@EJB
	private BackLogService backLogService;


    public BacklogServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action =
				(String) request.getParameter("action");

		if( action != null){

			switch (action) {

			case "ADDTHEME":
				backLogService.addTheme(getBackLog(), getTheme(request));
				break;

			default:
				break;
			}

		}





		sendToBackLogPage(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendToBackLogPage(request, response);
	}




	private Theme getTheme(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}



	private BackLog getBackLog() {
		// TODO Auto-generated method stub
		return null;
	}




	private void sendToBackLogPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("backlog.jsp").forward(request, response);
	}

}
