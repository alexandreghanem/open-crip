package fr.aston.opencrip.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller de home
 */
@Controller
@RequestMapping(value = "/accueil")
public class ViewController extends AbstractController {

    /**
     * Constructeur de l'objet.
     */
    public ViewController() {
        super();
    }

    /**
     * S'affiche quand on appel l'URL en get.
     *
     * @return la ou aller
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView indexAction() {
        if (this.LOG.isDebugEnabled()) {
            this.LOG.debug("Rendre la page accueil");
        }
        return new ModelAndView("home");
    }
}
