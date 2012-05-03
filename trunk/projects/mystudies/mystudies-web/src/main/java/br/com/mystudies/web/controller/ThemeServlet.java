package br.com.mystudies.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.domain.enun.Priority;
import br.com.mystudies.service.ThemeService;

/**
 * @author Robson
 */
@WebServlet("/theme")
public class ThemeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@EJB
	private ThemeService themeService;


    public ThemeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendToThemePage(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendToThemePage(request, response);
	}


	private void sendToThemePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("theme", getTheme(Long.valueOf((String) request.getParameter("themeId"))));
		request.getRequestDispatcher("pages/theme/theme.jsp").forward(request, response);
	}


	private Object getTheme(Long themeId) {
		return themeService.getTheme(themeId);
	}

}
