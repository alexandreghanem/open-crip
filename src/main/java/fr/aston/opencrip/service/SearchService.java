package fr.aston.opencrip.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.opencrip.dao.IAddressDAO;
import fr.aston.opencrip.dao.IProductDAO;
import fr.aston.opencrip.dao.ISupplierDAO;
import fr.aston.opencrip.dao.IUserDAO;
import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IAddressEntity;
import fr.aston.opencrip.entity.IProductEntity;
import fr.aston.opencrip.entity.ISupplierEntity;
import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.entity.ProductEntity;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.web.bean.SearchBean;

/**
 * Gestion de produits.
 */
@Service
public class SearchService extends AbstractService implements ISearchService {

    @Autowired
    private IProductDAO productDAO;
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private ISupplierDAO supplierDAO;
    @Autowired
    private IAddressDAO addressDAO;

    /**
     * Constructeur de l'objet.
     */
    public SearchService() {
        super();
    }

    /**
     * Recupere la propriete <i>productDAO</i>.
     *
     * @return the productDAO la valeur de la propriete.
     */
    public IProductDAO getProductDAO() {
        return this.productDAO;
    }

    /**
     * Fixe la propriete <i>productDAO</i>.
     *
     * @param pProductDAO
     *            la nouvelle valeur pour la propriete productDAO.
     */
    public void setProductDAO(IProductDAO pProductDAO) {
        this.productDAO = pProductDAO;
    }

    /**
     * Recupere la propriete <i>userDAO</i>.
     *
     * @return the userDAO la valeur de la propriete.
     */
    public IUserDAO getUserDAO() {
        return this.userDAO;
    }

    /**
     * Fixe la propriete <i>userDAO</i>.
     *
     * @param pUtilisateurDAO
     *            la nouvelle valeur pour la propriete userDAO.
     */
    public void setUserDAO(IUserDAO pUserDao) {
        this.userDAO = pUserDao;
    }

    /**
     * Recupere la propriete <i>supplierDAO</i>.
     *
     * @return the supplierDAO la valeur de la propriete.
     */
    public ISupplierDAO getSupplierDAO() {
        return this.supplierDAO;
    }

    /**
     * Fixe la propriete <i>supplierDAO</i>.
     *
     * @param pSupplierDAO
     *            la nouvelle valeur pour la propriete supplierDAO.
     */
    public void setSupplierDAO(ISupplierDAO pSupplierDAO) {
        this.supplierDAO = pSupplierDAO;
    }

    /**
     * Recupere la propriete <i>addressDAO</i>.
     *
     * @return the addressDAO la valeur de la propriete.
     */
    public IAddressDAO getAddressDAO() {
        return this.addressDAO;
    }

    /**
     * Fixe la propriete <i>addressDAO</i>.
     *
     * @param pAddressDAO
     *            la nouvelle valeur pour la propriete addressDAO.
     */
    public void setAddressDAO(IAddressDAO pAddressDAO) {
        this.addressDAO = pAddressDAO;
    }

    @Override
    public Set<IProductEntity> getProducts() throws TechnicalErrorException {
        Set<IProductEntity> products = new HashSet<>();
        try {
            for (int i = 1; i < 10; i++) {
                IProductEntity product = new ProductEntity();
                product.setId(i);
                product.setPrice(Double.valueOf(10.00));
                product.setReference("reference" + i);
                product.setSupplierId((int) (1 + (Math.random() * 9)));
                if (product == null) {
                    throw new ExceptionDao();
                }
                products.add(product);
            }
            // products = this.getProductDAO().selectAll(null, "id ASC");
        } catch (ExceptionDao e) {
            throw new TechnicalErrorException(e);
        }
        return products;
    }

    @Override
    public Set<IProductEntity> search(SearchBean aSearchBean)
        throws TechnicalErrorException {
        // On cherche dans la table produit
        Set<IProductEntity> products;
        try {
            products = this.getProductDAO().selectCriteria(aSearchBean
                .getSearchInput(), null, null);
        } catch (ExceptionDao e) {
            throw new TechnicalErrorException(e);
        }

        // On cherche dans la table fournisseur
        if (10 > products.size()) {
            Set<ISupplierEntity> suppliers;
            try {
                suppliers = this.getSupplierDAO().selectCriteria(aSearchBean
                    .getSearchInput(), 10 - products.size(), null);
            } catch (ExceptionDao e) {
                throw new TechnicalErrorException(e);
            }

            Iterator<ISupplierEntity> iterator = suppliers.iterator();
            while (iterator.hasNext()) {
                ISupplierEntity supplier = iterator.next();
                if (supplier == null) {
                    continue;
                }

                try {
                    products.addAll(this.getProductDAO().selectAll(
                        "id_fournisseur=" + supplier.getId(), null));
                } catch (ExceptionDao e) {
                    throw new TechnicalErrorException(e);
                }

                if (10 > products.size()) {
                    break;
                }
            }
        }

        // On cherche dans la table adresse
        if (10 > products.size()) {
            Set<IAddressEntity> addresses;
            try {
                addresses = this.getAddressDAO().selectCriteria(aSearchBean
                    .getSearchInput(), 10 - products.size(), null);
            } catch (ExceptionDao e) {
                throw new TechnicalErrorException(e);
            }

            Iterator<IAddressEntity> iterator = addresses.iterator();
            while (iterator.hasNext()) {
                IAddressEntity address = iterator.next();
                if (address == null) {
                    continue;
                }

                Set<IUserEntity> users;
                try {
                    users = this.getUserDAO().selectAll("id_address=" + address
                        .getId(), null);
                } catch (ExceptionDao e) {
                    throw new TechnicalErrorException(e);
                }

                Iterator<IUserEntity> iter = users.iterator();
                while (iterator.hasNext()) {
                    IUserEntity user = iter.next();
                    if (user == null) {
                        continue;
                    }

                    ISupplierEntity supplier;
                    try {
                        supplier = this.getSupplierDAO().select(user
                            .getSupplierId());
                    } catch (ExceptionDao e) {
                        throw new TechnicalErrorException(e);
                    }

                    if (supplier == null) {
                        continue;
                    }

                    try {
                        products.addAll(this.getProductDAO().selectAll(
                            "id_fournisseur=" + supplier.getId(), null));
                    } catch (ExceptionDao e) {
                        throw new TechnicalErrorException(e);
                    }

                    if (10 > products.size()) {
                        break;
                    }
                }

                if (10 > products.size()) {
                    break;
                }
            }
        }

        return products;
    }
}
