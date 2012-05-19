package br.com.mystudies.jqueryajax.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class Ajax extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public Ajax() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

		response.getWriter()
			.print("Welcome..: "
				+ request.getParameter("name")
				+ " the time now is..: "
				+ new SimpleDateFormat("HH:mm:ss").format(new Date())
			);
	}
}
