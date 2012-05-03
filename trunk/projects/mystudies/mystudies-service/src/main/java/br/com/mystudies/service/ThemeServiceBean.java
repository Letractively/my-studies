package br.com.mystudies.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.service.persistence.ThemeDao;


@Stateless
@Remote(ThemeService.class)
public class ThemeServiceBean implements ThemeService{

	@EJB
	private ThemeDao themeDao;

	@Override
	public Theme getTheme(Long themeId) {
		// FIXME: validate parameter
		return themeDao.find(themeId);
	}

}
