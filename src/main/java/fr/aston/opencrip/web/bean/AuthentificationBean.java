package fr.aston.opencrip.web.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class AuthentificationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String pwd;

	/**
	 * Constructeur de l'objet.
	 */
	public AuthentificationBean() {
		super();
	}

	/**
	 * Constructeur de l'objet.
	 *
	 * @param request
	 *            la request
	 */
	public AuthentificationBean(HttpServletRequest request) {
		super();
		if (request != null) {
			this.setLogin(request.getParameter("identifiant"));
			this.setPassword(request.getParameter("mot_de_passe"));
		}
	}

	/**
	 * @return the id
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setLogin(String aLogin) {
		if ((aLogin == null) || (aLogin.trim().length() == 0)) {
			this.login = null;
		} else {
			this.login = aLogin;
		}
	}

	/**
	 * @return the pwd
	 */
	public String getPassword() {
		return this.pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPassword(String aPwd) {
		if ((aPwd == null) || (aPwd.trim().length() == 0)) {
			this.pwd = null;
		} else {
			this.pwd = aPwd;
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{class=");
		sb.append(this.getClass().getName());
		sb.append(",id=");
		sb.append(this.getLogin());
		sb.append(",pwd=");
		sb.append(this.getPassword());
		sb.append('}');
		return sb.toString();
	}
}