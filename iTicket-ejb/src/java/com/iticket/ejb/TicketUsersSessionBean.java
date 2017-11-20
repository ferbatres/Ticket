/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.TicketUsers;
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
public class TicketUsersSessionBean {
    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(TicketUsers ticketusers) {
        em.persist(ticketusers);
    }
                    //Update an existing Department
    public void update(TicketUsers ticketusers) throws Exception {
        em.merge(ticketusers);
    }

    //find by id
    public TicketUsers findById(String ticketusersId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Users.findByIdUser", TicketUsers.class);
        query.setParameter("IdUser", ticketusersId);
        //dep = (Departments)query.getSingleResult();
        return (TicketUsers) query.getSingleResult();
    }

    //Get list
    public List<TicketUsers> findAll() {

        TypedQuery<TicketUsers> query = em.createNamedQuery("findAll", TicketUsers.class);
        return query.getResultList();
    }

    //find record
    public TicketUsers get(String key) {
        return em.find(TicketUsers.class, key);
    }

    //delete record
    public void delete(TicketUsers ticketusers) {
        em.remove(get(ticketusers.getIdTicketUser().toString()));
    }
}
