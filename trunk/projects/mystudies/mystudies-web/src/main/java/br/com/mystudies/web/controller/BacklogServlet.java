package br.com.mystudies.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.domain.entity.BackLog;
import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.domain.enun.Priority;

/**
 * @author Robson
 */
@WebServlet("/backlog")
public class BacklogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public BacklogServlet() {
        super();
    }




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fakeListThemes(request,response);
		request.getRequestDispatcher("backlog.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fakeListThemes(request,response);
	}



	private void fakeListThemes(HttpServletRequest request,HttpServletResponse response) {
		List<Theme> themes = new ArrayList<>();

		themes.add(new Theme("OSGI", Priority.HEIGHT, new Date()));
		themes.add(new Theme("JAVA 7 - project coin", Priority.HEIGHT, new Date()));
		themes.add(new Theme("CSS3",Priority.HEIGHT, new Date()));
		themes.add(new Theme("HTML5",Priority.HEIGHT, new Date()));
		themes.add(new Theme("JEE 7 - JMS 2.0",Priority.HEIGHT, new Date()));
		themes.add(new Theme("HADOP",Priority.HEIGHT, new Date()));
		themes.add(new Theme("JEE 7 - Cache",Priority.HEIGHT, new Date()));
		themes.add(new Theme("JSF 2.0",Priority.HEIGHT, new Date()));
		themes.add(new Theme("JQuery - AJAX",Priority.HEIGHT, new Date()));
		themes.add(new Theme("CDI",Priority.HEIGHT, new Date()));
		themes.add(new Theme("CDI",Priority.HEIGHT, new Date()));
		themes.add(new Theme("CDI",Priority.HEIGHT, new Date()));
		themes.add(new Theme("CDI",Priority.HEIGHT, new Date()));

		request.setAttribute("themes", themes);
	}




}
