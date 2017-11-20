/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.Site;
import com.iticket.model.Ticket;
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
public class TicketSessionBean {
    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(Ticket ticket) {
        em.persist(ticket);
    }
    
            //Update an existing Department
    public void update(Ticket ticket) throws Exception {
        em.merge(ticket);
    }

    //find by id
    public Ticket findById(String ticketId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Users.findByIdUser", Ticket.class);
        query.setParameter("IdUser", ticketId);
        //dep = (Departments)query.getSingleResult();
        return (Ticket) query.getSingleResult();
    }

    //Get list
    public List<Ticket> findAll() {

        TypedQuery<Ticket> query = em.createNamedQuery("findAll", Ticket.class);
        return query.getResultList();
    }

    //find record
    public Ticket get(String key) {
        return em.find(Ticket.class, key);
    }

    //delete record
    public void delete(Ticket ticket) {
        em.remove(get(ticket.getIdTicket().toString()));
    }
    
}
