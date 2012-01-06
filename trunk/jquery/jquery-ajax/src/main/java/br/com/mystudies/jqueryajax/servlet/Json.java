package br.com.mystudies.jqueryajax.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/json")
public class Json extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<Person> persons;
	
	private Gson gson;
	
    public Json() {
        super();
        persons = new ArrayList<>();
        gson = new Gson();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		addPerson(request);
		writeJSON(response);
	}



	private void addPerson(HttpServletRequest request) {
		persons.add(
				new Person(
					request.getParameter("name"), 
					request.getParameter("age")
				)
			);
	}	
	
	
	private void writeJSON(HttpServletResponse response) throws IOException {
		response.getWriter().print(gson.toJson(persons));
	}
	
	
	
	public class Person{
		
		private String name;
		private String age;
		
		
		public Person(String name, String age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		
	}
}
