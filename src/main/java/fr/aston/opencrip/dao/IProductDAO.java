package fr.aston.opencrip.dao;

import java.util.Set;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IProductEntity;

/**
 * Dao produit. <br>
 */
public interface IProductDAO extends IDAO<IProductEntity> {

    /**
     * Selectionne les produits en fonction des criteres.
     *
     * @param sSearchInput
     *            text de la recherche
     * @return la liste des produits repondant aux criteres
     * @throws ExceptionDao
     *             si un probleme survient
     *
     */
    public abstract Set<IProductEntity> selectCriteria(
        String aSearchInput, Integer aLimit, String pOrderBy)
            throws ExceptionDao;
}