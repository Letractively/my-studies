package br.com.mystudies.ds.security;

import br.com.mystudies.ds.service.Service;

public interface ServiceFactory {

	Service getService(User user);
}
