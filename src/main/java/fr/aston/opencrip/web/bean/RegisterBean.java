package fr.aston.opencrip.web.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RegisterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String lastname;
	private String firstname;
	// private String number;
	// private String address;
	// private String zipcode;
	// private String city;
	// private String login;
	// private String password;
	// private String email;
	// private String telephone;

	/**
	 * Constructeur de l'objet.
	 */
	public RegisterBean() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param request
	 *            la request
	 */
	public RegisterBean(HttpServletRequest request) {
		super();
		if (request != null) {
			this.setLastname(request.getParameter("prenom"));
			this.setFirstname(request.getParameter("nom"));
			// this.setNumber(request.getParameter("numero"));
			// this.setAddress(request.getParameter("rue"));
			// this.setZipcode(request.getParameter("codePostal"));
			// this.setCity(request.getParameter("ville"));
			// this.setPassword(request.getParameter("password"));
			// this.setEmail(request.getParameter("mail"));
		}
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String aLastname) {
		if ((aLastname == null) || (aLastname.trim().length() == 0)) {
			this.lastname = null;
		} else {
			this.lastname = aLastname;
		}
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String aFirstname) {
		if ((aFirstname == null) || (aFirstname.trim().length() == 0)) {
			this.firstname = null;
		} else {
			this.firstname = aFirstname;
		}
	}

	// /**
	// * @return the login
	// */
	// public String getLogin() {
	// return this.login;
	// }
	//
	// /**
	// * @param login
	// * the login to set
	// */
	// public void setLogin(String login) {
	// this.login = login;
	// }
	//
	// /**
	// * @return the password
	// */
	// public String getPassword() {
	// return this.password;
	// }
	//
	// /**
	// * @param password
	// * the password to set
	// */
	// public void setPassword(String password) {
	// this.password = password;
	// }
	//
	// /**
	// * @return the email
	// */
	// public String getEmail() {
	// return this.email;
	// }
	//
	// /**
	// * @param email
	// * the email to set
	// */
	// public void setEmail(String email) {
	// this.email = email;
	// }
	//
	// /**
	// * @return the telephone
	// */
	// public String getTelephone() {
	// return this.telephone;
	// }
	//
	// /**
	// * @param telephone
	// * the telephone to set
	// */
	// public void setTelephone(String telephone) {
	// this.telephone = telephone;
	// }
	//
	// /**
	// * @return the number
	// */
	// public String getNumber() {
	// return this.number;
	// }
	//
	// /**
	// * @param number
	// * the number to set
	// */
	// public void setNumber(String number) {
	// this.number = number;
	// }
	//
	// /**
	// * @return the address
	// */
	// public String getAddress() {
	// return this.address;
	// }
	//
	// /**
	// * @param address
	// * the address to set
	// */
	// public void setAddress(String address) {
	// this.address = address;
	// }
	//
	// /**
	// * @return the zipcode
	// */
	// public String getZipcode() {
	// return this.zipcode;
	// }
	//
	// /**
	// * @param zipcode
	// * the zipcode to set
	// */
	// public void setZipcode(String zipcode) {
	// this.zipcode = zipcode;
	// }
	//
	// /**
	// * @return the city
	// */
	// public String getCity() {
	// return this.city;
	// }
	//
	// /**
	// * @param city
	// * the city to set
	// */
	// public void setCity(String city) {
	// this.city = city;
	// }

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{class=");
		sb.append(this.getClass().getName());
		sb.append(",firstname=");
		sb.append(this.getFirstname());
		sb.append(",lastname=");
		sb.append(this.getLastname());
		sb.append('}');
		return sb.toString();
	}

}
