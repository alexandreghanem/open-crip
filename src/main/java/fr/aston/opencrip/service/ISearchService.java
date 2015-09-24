package fr.aston.opencrip.service;

import java.util.Set;

import fr.aston.opencrip.entity.IProductEntity;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.web.bean.SearchBean;

/**
 * Gestion de produits.
 */
public interface ISearchService extends IService {

    /**
     * Récupère tous les produits.
     *
     * @return liste d'utilisateurs, leve une exception sinon
     * @throws TechnicalErrorException
     *             si un probleme survient
     */
    public abstract Set<IProductEntity> getProducts()
        throws TechnicalErrorException;

    /**
     * Récupère tous les produits.
     *
     * @param aSearchBean
     *            the searchbean
     * @return liste d'utilisateurs, leve une exception sinon
     * @throws TechnicalErrorException
     *             si un probleme survient
     */
    public abstract Set<IProductEntity> search(SearchBean aSearchBean)
        throws TechnicalErrorException;

}