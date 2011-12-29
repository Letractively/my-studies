package br.com.mystudies.jqueryajax.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/post")
public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Post() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter()
			.print("Welcome..: " 
					+ request.getParameter("name")
					+ " the time now is..: "
					+ new SimpleDateFormat("HH:mm:ss").format(new Date())
				);
	}

}
