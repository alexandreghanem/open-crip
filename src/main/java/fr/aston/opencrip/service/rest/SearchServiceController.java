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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.aston.opencrip.entity.IProductEntity;
import fr.aston.opencrip.service.ISearchService;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.web.bean.SearchBean;

/**
 * Récuperation des produits en rest. URL :
 * http://localhost:8080/open-crip/rest/search/all
 * http://localhost:8080/open-crip/rest/search/input
 */

@RestController
@RequestMapping(value = "/search")
public class SearchServiceController {

    @Autowired
    private ISearchService searchService;

    /**
     * Constructeur de l'objet.
     */
    public SearchServiceController() {
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
    @RequestMapping(value = "/all", method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> getProducts() {
        ResponseEntity<String> result = null;

        try {
            Set<IProductEntity> products = this.searchService.getProducts();
            JSONArray json = new JSONArray();
            Iterator<IProductEntity> iterator = products.iterator();
            while (iterator.hasNext()) {
                IProductEntity product = iterator.next();
                if (product == null) {
                    continue;
                }
                json.put(product.toJSONObject());
            }

            result = new ResponseEntity<>(json.toString(), HttpStatus.OK);
        } catch (TechnicalErrorException e) {
            result = new ResponseEntity<>(new JSONException(e.getMessage())
                .toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    @RequestMapping(value = "/input", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> search(
        @RequestBody String input) {
        ResponseEntity<String> result = null;

        JSONObject p = new JSONObject(input);
        SearchBean searchBean = new SearchBean();
        searchBean.setSearchInput(p.getString("searchInput"));

        try {
            Set<IProductEntity> products = this.searchService.search(
                searchBean);
            JSONArray json = new JSONArray();
            Iterator<IProductEntity> iterator = products.iterator();
            while (iterator.hasNext()) {
                IProductEntity product = iterator.next();
                if (product == null) {
                    continue;
                }
                json.put(product.toJSONObject());
            }
            result = new ResponseEntity<>(json.toString(), HttpStatus.OK);
        } catch (TechnicalErrorException e) {
            result = new ResponseEntity<>(new JSONException(e.getMessage())
                .toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }
}
