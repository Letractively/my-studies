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

import br.com.mystudies.domain.entity.Story;
import br.com.mystudies.domain.enun.Priority;
import br.com.mystudies.domain.enun.Status;

/**
 * @author Robson
 */
@WebServlet("/story")
public class StoryServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


    public StoryServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fakeListStories(request,response);
		request.getRequestDispatcher("story.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fakeListStories(request,response);
	}


	private void fakeListStories(HttpServletRequest request,HttpServletResponse response) {
		List<Story> stories = new ArrayList<>();

		stories.add(new Story("Read chapter 2 of book", Priority.HEIGHT, Status.SPRINT_BACKLOG, new Date() ));
		stories.add(new Story("coding announets chapter 1", Priority.HEIGHT, Status.SPRINT_BACKLOG, new Date() ));
		stories.add(new Story("read article in ..", Priority.HEIGHT, Status.SPRINT_BACKLOG, new Date() ));

		request.setAttribute("stories", stories);
	}
}
