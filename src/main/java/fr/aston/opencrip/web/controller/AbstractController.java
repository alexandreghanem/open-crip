package fr.aston.opencrip.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Controller de base.
 */
@Controller
public abstract class AbstractController {

    protected Log LOG = LogFactory.getLog(this.getClass());

    /**
     * Constructeur de l'objet.
     */
    protected AbstractController() {
        super();
    }

    /**
     * Recupere le context Spring.
     *
     * @return le context Spring.
     */
    protected final WebApplicationContext getSpringContext(
        HttpServletRequest request) {
        return WebApplicationContextUtils.getRequiredWebApplicationContext(
            request.getServletContext());
    }
}
