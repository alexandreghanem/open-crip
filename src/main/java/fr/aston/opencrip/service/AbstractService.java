package fr.aston.opencrip.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * Classe parente de tous les services.
 */
@Service
abstract class AbstractService implements IService {

    protected Log LOG = LogFactory.getLog(this.getClass());

    /**
     * Constructeur de l'objet.
     */
    AbstractService() {
        super();
    }
}
