package br.com.mystudies.ds.security;

public class User {

	public enum Group {
		ADMINISTRATORS,PROGRAMMERS;
	}


	private Group group;


	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
