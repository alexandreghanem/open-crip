package fr.aston.opencrip.service.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.aston.opencrip.service.IAuthentificationService;
import fr.aston.opencrip.service.ex.AuthentificationException;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.web.bean.AuthentificationBean;

/**
 * Récuperation des connections en rest. URL :
 * http://localhost:8080/open-crip/rest/authentification
 */

@RestController
@RequestMapping(value = "/login")
public class AuthentificationServiceController {

    protected Log LOG = LogFactory.getLog(this.getClass());

    @Autowired
    private IAuthentificationService authentificationService;

    /**
     * Constructeur de l'objet.
     */
    public AuthentificationServiceController() {
        super();
    }

    /**
     * Connecter tous les clients.
     *
     * @param login
     *            le login
     * @param password
     *            le password
     * @return l'utilisateur authentifie
     */
    @RequestMapping(value = "/client", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> authentificationClient(
        @RequestBody String input) throws AuthentificationException {

        ResponseEntity<String> result = null;
        JSONObject json = new JSONObject();

        // this.LOG.info(input);
        JSONObject p = new JSONObject(input);
        AuthentificationBean authentificationBean = new AuthentificationBean();
        authentificationBean.setLogin(p.getString("login"));
        authentificationBean.setPassword(p.getString("password"));
        // this.LOG.info(authentificationBean);
        try {
            this.authentificationService.authentifier(authentificationBean);
            json.put("authentificationClient", "Client connecté");
            result = new ResponseEntity<>(json.toString(), HttpStatus.OK);
        } catch (TechnicalErrorException e) {
            result = new ResponseEntity<>(new JSONException(e.getMessage())
                .toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}