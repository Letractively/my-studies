package br.com.mystudies.ds.client;

import br.com.mystudies.ds.security.ServiceFactory;
import br.com.mystudies.ds.security.ServiceSimpleFactory;
import br.com.mystudies.ds.security.User;
import br.com.mystudies.ds.security.User.Group;
import br.com.mystudies.ds.service.Service;

public class App{
    public static void main( String[] args ){

    	ServiceFactory sf = new ServiceSimpleFactory();

    	//--------------------------------------------

    	User user = new User();
    	user.setGroup(Group.ADMINISTRATORS);

    	Service service = sf.getService(user);

    	System.out.println(service.execute());


    	//----------------------------------------

    	user.setGroup(Group.PROGRAMMERS);

    	service = sf.getService(user);

    	System.out.println(service.execute());


    	// --------------------------------------------

    }
}
