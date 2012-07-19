package br.com.mystudies.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.domain.entity.Story;
import br.com.mystudies.domain.entity.Theme;

/**
 * @author Robson
 */
@WebServlet("/kanban")
public class KanbanServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


    public KanbanServlet() {
        super();
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*		Sprint sprint = new Sprint();

		sprint.getStories();*/

		Map<Theme, List<Story>> map = new HashMap<>();


		List<Story> l1 = new ArrayList<>();
		l1.add(new Story("story1 story1 story1s tory1 ", null, null, null));
		l1.add(new Story("story2 story1 story1", null, null, null));
		l1.add(new Story("story3 story1story1 ", null, null, null));
		l1.add(new Story("story4 story1story1 ", null, null, null));


		map.put(new Theme("Theme 1", null, null), l1);

		List<Story> l2 = new ArrayList<>();
		l2.add(new Story("story1 sssssssssssss ", null, null, null));




		map.put(new Theme("Theme 2", null, null), l2);



		List<Story> l3 = new ArrayList<>();
		l3.add(new Story("story1 sssssssssssssssss ", null, null, null));
		l3.add(new Story("story2 sssssssssssssssss", null, null, null));



		map.put(new Theme("Theme 3", null, null), l3);


		List<Story> l4 = new ArrayList<>();
		l4.add(new Story("story1 ssssssssssssss ", null, null, null));
		l4.add(new Story("story2 sssssssssssssss", null, null, null));
		l4.add(new Story("story3ssssssssssssssss", null, null, null));
		l4.add(new Story("story4 ssssssssssssssss", null, null, null));
		l4.add(new Story("story4sssssssssssssssssss", null, null, null));
		l4.add(new Story("story4", null, null, null));


		map.put(new Theme("Theme 4", null, null), l4);

		request.setAttribute("map", map);



		request.getRequestDispatcher("pages/kanban/kanban.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/kanban/kanban.jsp").forward(request, response);

	}


}
