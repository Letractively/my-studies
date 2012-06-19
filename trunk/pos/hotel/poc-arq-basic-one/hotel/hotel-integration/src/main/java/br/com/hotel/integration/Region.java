package br.com.hotel.integration;

public class Region {


	private String contry;


	public Region(String contry) {
		this.setContry(contry);
	}


	public String getContry() {
		return contry;
	}


	public void setContry(String contry) {
		this.contry = contry;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contry == null) ? 0 : contry.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		if (contry == null) {
			if (other.contry != null)
				return false;
		} else if (!contry.equals(other.contry))
			return false;
		return true;
	}


}
