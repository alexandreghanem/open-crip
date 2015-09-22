package fr.aston.opencrip.service.rest;

import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.service.IUserService;
import fr.aston.opencrip.service.ex.TechnicalErrorException;

/**
 * Gestion de l'authentification en rest. URL :
 * http://localhost:8080/netbank/rest/authentication/dj/dj
 */

@RestController
@RequestMapping(value = "/users")
public class ExampleServiceController {

    @Autowired
    private IUserService userService;

    /**
     * Constructeur de l'objet.
     */
    public ExampleServiceController() {
        super();
    }

    /**
     * Récupérer tous les utilisateurs.
     *
     * @param login
     *            le login
     * @param password
     *            le password
     * @return l'utilisateur authentifie
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getUsers() {
        Set<IUserEntity> users = null;
        ResponseEntity<String> result = null;

        try {
            users = this.userService.getUsers();
            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();
            Iterator<IUserEntity> iterator = users.iterator();
            while (iterator.hasNext()) {
                IUserEntity user = iterator.next();
                if (user == null) {
                    continue;
                }
                JSONObject obj = new JSONObject();
                obj.put("login", user.getLogin());
                obj.put("nom", user.getNom());
                obj.put("prenom", user.getPrenom());
                obj.put("id", user.getId());
                array.put(obj);
            }
            json.put("users", array);

            result = new ResponseEntity<>(json.toString(), HttpStatus.OK);
        } catch (TechnicalErrorException e) {
            result = new ResponseEntity<>(new JSONException(e.getMessage())
                .toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

}
