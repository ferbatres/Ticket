/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.Site;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Irvin.Sanchez
 */
@Stateless
@LocalBean
public class SiteSessionBean {
    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(Site site) {
        em.persist(site);
    }
    
            //Update an existing Department
    public void update(Site site) throws Exception {
        em.merge(site);
    }

    //find by id
    public Site findById(String siteId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Site.findByIdSite", Site.class);
        query.setParameter("idSite", siteId);
        //dep = (Departments)query.getSingleResult();
        return (Site) query.getSingleResult();
    }

    //Get list
    public List<Site> findAll() {

        TypedQuery<Site> query = em.createNamedQuery("Site.findAll", Site.class);
        return query.getResultList();
    }

    //find record
    public Site get(String key) {
        return em.find(Site.class, key);
    }

    //delete record
    public void delete(Site site) {
        em.remove(get(site.getIdSite().toString()));
    }
    
}
