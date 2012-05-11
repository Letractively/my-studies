package br.com.mystudies.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.domain.entity.Story;
import br.com.mystudies.domain.enun.Priority;
import br.com.mystudies.domain.enun.Status;


@WebServlet("/sprint")
public class SprintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SprintServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//temp(request,response);
		request.getRequestDispatcher("pages/sprint/sprint.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = 
				request.getParameter("action");
		

		if(action != null){
			
			switch (action) {				
				case "NEWSPRINT":
					// SprintService.containsSprintInRun()
					sendToSprintFormFragment(request,response);
					break;
				case "CREATESPRINT":
					temp(request, response);
					// SprintService.containsSprintInRun()
					sendToSprintStoriesFragment(request, response);
					break;
				default:
					sendToSprintPage(request,response);
					break;
			}	
		}
	}


	
	private void sendToSprintFormFragment(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("containsSprintInRun", false);
		request.getRequestDispatcher("pages/sprint/sprint-form-fragment.jsp").forward(request, response);				
	}
	
	
	private void sendToSprintStoriesFragment(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("pages/sprint/sprint-stories-fragment.jsp").forward(request, response);				
	}

	
	private void sendToSprintPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("includeStoriesFragment", true);
		request.getRequestDispatcher("pages/sprint/sprint.jsp").forward(request, response);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	private void temp(HttpServletRequest request, HttpServletResponse response) {
		request.getParameter("startDate");
		request.getParameter("finalDate");
		
		request.setAttribute("sprint", getSprint(request));
	}


	private Object getSprint(HttpServletRequest request) {
		
		Sprint sprint = new Sprint();
		
		sprint.setStories(new HashSet<Story>());
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		sprint.getStories().add(new Story("tesmte", Priority.HEIGHT, Status.IN_SPRINT, new Date()));
		
		return sprint;
	}

}
