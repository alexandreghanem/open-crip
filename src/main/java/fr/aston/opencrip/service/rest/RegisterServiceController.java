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

import fr.aston.opencrip.service.IClientService;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.web.bean.RegisterBean;

/**
 * Récuperation des inscriptions en rest. URL :
 * http://localhost:8080/open-crip/rest/register
 */

@RestController
@RequestMapping(value = "/register")
public class RegisterServiceController {

	protected Log LOG = LogFactory.getLog(this.getClass());

	@Autowired
	private IClientService clientService;

	/**
	 * Constructeur de l'objet.
	 */
	public RegisterServiceController() {
		super();
	}

	/**
	 * Inscrire tous les clients.
	 *
	 * @param login
	 *            le login
	 * @param password
	 *            le password
	 * @return l'utilisateur authentifie
	 */
	@RequestMapping(value = "/client", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> registerClient(@RequestBody String input) {

		ResponseEntity<String> result = null;
		JSONObject json = new JSONObject();

		// this.LOG.info(input);
		JSONObject p = new JSONObject(input);
		RegisterBean registerBean = new RegisterBean();
		registerBean.setLastname(p.getString("lastname"));
		registerBean.setFirstname(p.getString("firstname"));
		// this.LOG.info(registerBean);
		try {
			this.clientService.register(registerBean);
			json.put("registerClient", "Client ajouté");
			result = new ResponseEntity<>(json.toString(), HttpStatus.OK);
		} catch (TechnicalErrorException e) {
			result = new ResponseEntity<>(new JSONException(e.getMessage()).toString(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}

}
