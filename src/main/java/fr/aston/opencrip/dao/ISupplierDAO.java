package fr.aston.opencrip.dao;

import java.util.Set;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.ISupplierEntity;

/**
 * Dao fournisseur. <br>
 */
public interface ISupplierDAO extends IDAO<ISupplierEntity> {

    /**
     * Selectionne les fournisseurs en fonction des criteres.
     *
     * @param sSearchInput
     *            text de la recherche
     * @return la liste des produits repondant aux criteres
     * @throws ExceptionDao
     *             si un probleme survient
     *
     */
    public abstract Set<ISupplierEntity> selectCriteria(
        String aSearchInput, Integer aLimit, String pOrderBy)
            throws ExceptionDao;

}