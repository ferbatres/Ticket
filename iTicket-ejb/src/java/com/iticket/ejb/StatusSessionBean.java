/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.Status;
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
public class StatusSessionBean {

    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(Status status) {
        em.persist(status);
    }

    //Update an existing Department
    public void update(Status status) throws Exception {
        em.merge(status);
    }

    //find by id
    public Status findById(String statusId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Status.findByIdStatus", Status.class);
        query.setParameter("IdUser", statusId);
        //dep = (Departments)query.getSingleResult();
        return (Status) query.getSingleResult();
    }

    //Get list
    public List<Status> findAll() {

        try {
            TypedQuery<Status> query = em.createNamedQuery("Status.findAll", Status.class);
            return query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //find record
    public Status get(Integer key) {
        return em.find(Status.class, key);
    }

    //delete record
    public void delete(Status status) {
        em.remove(get(status.getIdStatus()));
    }

}
