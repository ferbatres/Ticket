/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.TicketDetail;
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
public class TicketDetailSessionBean {
    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(TicketDetail ticketdetail) {
        em.persist(ticketdetail);
    }
    //Update an existing Department

    public void update(TicketDetail ticketdetail) throws Exception {
        em.merge(ticketdetail);
    }

    //find by id
    public TicketDetail findById(String ticketdetailId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Users.findByIdUser", TicketDetail.class);
        query.setParameter("IdUser", ticketdetailId);
        //dep = (Departments)query.getSingleResult();
        return (TicketDetail) query.getSingleResult();
    }

    //Get list
    public List<TicketDetail> findAll() {
        
        TypedQuery<TicketDetail> query = em.createNamedQuery("findAll", TicketDetail.class);
        return query.getResultList();
    }

    //find record
    public TicketDetail get(String key) {
        return em.find(TicketDetail.class, key);
    }

    //delete record
    public void delete(TicketDetail ticketdetail) {
        em.remove(get(ticketdetail.getIdTicketDetail().toString()));
    }
}
