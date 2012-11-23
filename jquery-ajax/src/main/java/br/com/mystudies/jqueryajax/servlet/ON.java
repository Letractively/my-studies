package br.com.mystudies.jqueryajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/on")
public class ON extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<String> names;

    public ON() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addName(request);

		PrintWriter writer = response.getWriter();

		for (String name : names) {
			writer.print("<div>");
			writer.print(name);
			writer.print("</div>");
		}

	}


	@SuppressWarnings("unchecked")
	private void addName(HttpServletRequest request) {

		names = (List<String>) request.getSession().getAttribute("names");

		if(names == null){
			createNames(request);
		}

		names.add(request.getParameter("name"));
	}



	private void createNames(HttpServletRequest request) {
		names = new ArrayList<>();
		request.getSession().setAttribute("names", names);
	}
}
