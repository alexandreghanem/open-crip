package fr.aston.opencrip.web.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class SearchBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String searchInput;

    public SearchBean() {
        super();
    }

    /**
     * Constructeur de l'objet.
     *
     * @param request
     *            la request
     */
    public SearchBean(HttpServletRequest request) {
        super();
        if (request != null) {
            this.setSearchInput(request.getParameter("searchInput"));
        }
    }

    /**
     * @return the searchInput
     */
    public String getSearchInput() {
        return this.searchInput;
    }

    /**
     * @param aSearchInput
     *            the searchInput to set
     */
    public void setSearchInput(String aSearchInput) {
        if ((aSearchInput == null) || (aSearchInput.trim().length() == 0)) {
            this.searchInput = null;
        } else {
            this.searchInput = aSearchInput;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{class=");
        sb.append(this.getClass().getName());
        sb.append(",searchInput=");
        sb.append(this.getSearchInput());
        sb.append('}');
        return sb.toString();
    }
}
