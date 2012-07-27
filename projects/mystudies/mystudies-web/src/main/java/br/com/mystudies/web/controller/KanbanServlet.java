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

import br.com.mystudies.domain.entity.Story;
import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.domain.enun.StoryStatus;

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


    	// parametro para saber se o evento foi
    	// id da story
    	// para qual fase do kanbam a story foi passada
    	// salvar novo estado da historia.



        setFakeSprint(request);



        request.getRequestDispatcher("pages/kanban/kanban.jsp").forward(request, response);
    }

















































	private void setFakeSprint(HttpServletRequest request) {
		Map<Theme, List<Story>> map = new HashMap<>();



        List<Story> l1 = new ArrayList<>();
        l1.add(new Story("story1 done ", null, StoryStatus.DONE, null));
        l1.add(new Story("story2 done ", null, StoryStatus.DONE, null));
        l1.add(new Story("story3 done ", null, StoryStatus.DONE, null));
        l1.add(new Story("story4 done ", null, StoryStatus.DONE, null));



        map.put(new Theme("Theme 1", null, null), l1);

        List<Story> l2 = new ArrayList<>();
        l2.add(new Story("story1 doing", null, StoryStatus.DOING, null));
        l2.add(new Story("story2 doing", null, StoryStatus.DOING, null));
        l2.add(new Story("story3 doing", null, StoryStatus.DOING, null));


        map.put(new Theme("Theme 2", null, null), l2);



        List<Story> l3 = new ArrayList<>();
        l3.add(new Story("story todo ", null, StoryStatus.TODO, null));
        l3.add(new Story("story2 done", null, StoryStatus.DONE, null));



        map.put(new Theme("Theme 3", null, null), l3);


        List<Story> l4 = new ArrayList<>();
        l4.add(new Story("story1 todo ", null, StoryStatus.TODO, null));
        l4.add(new Story("story2 todo", null, StoryStatus.TODO, null));
        l4.add(new Story("story3 done", null, StoryStatus.DONE, null));
        l4.add(new Story("story4 todo", null, StoryStatus.TODO, null));
        l4.add(new Story("story5 todo", null, StoryStatus.TODO, null));


        map.put(new Theme("Theme 4", null, null), l4);

        request.setAttribute("map", map);
	}



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/kanban/kanban.jsp").forward(request, response);

    }


}
