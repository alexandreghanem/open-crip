package fr.aston.opencrip.web.bean;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AuthentificationBeanValidator implements Validator {

	/**
	 * Constructeur de l'objet.
	 */
	public AuthentificationBeanValidator() {
		super();
	}

	@Override
	public boolean supports(Class<?> pArg0) {
		return AuthentificationBean.class.equals(pArg0);
	}

	@Override
	public void validate(Object anAuthentificationBean, Errors pErrors) {
		AuthentificationBean lb = (AuthentificationBean) anAuthentificationBean;
		if (lb.getLogin() == null) {
			pErrors.rejectValue("id", "error.user.id.empty");
		}
		if (lb.getPassword() == null) {
			pErrors.rejectValue("pwd", "error.user.pwd.empty");
		}
	}
}
