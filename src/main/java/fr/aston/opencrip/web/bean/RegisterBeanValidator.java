package fr.aston.opencrip.web.bean;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterBeanValidator implements Validator {

    /**
     * Constructeur de l'objet.
     */
    public RegisterBeanValidator() {
        super();
    }

    @Override
    public boolean supports(Class<?> pArg0) {
        return RegisterBean.class.equals(pArg0);
    }

    @Override
    public void validate(Object aRegisterBean, Errors pErrors) {
        RegisterBean lb = (RegisterBean) aRegisterBean;
        if (lb.getFirstname() == null) {
            pErrors.rejectValue("firstname", "error.user.lastname.empty");
        }
        if (lb.getLastname() == null) {
            pErrors.rejectValue("lastname", "error.user.firstname.empty");
        }
    }
}
