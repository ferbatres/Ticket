/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.Account;
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
public class AccountSessionBean {

    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(Account account) {
        try {
            em.persist(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Update an existing Department
    public void update(Account account) throws Exception {
        try {
            em.merge(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //find by id

    public Account findById(String accountId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Account.findByIdAccount", Account.class);
        query.setParameter("idAccount", accountId);
        //dep = (Departments)query.getSingleResult();
        return (Account) query.getSingleResult();
    }

    //Get list
    public List<Account> findAll() {

        TypedQuery<Account> query = em.createNamedQuery("Account.findAll", Account.class);
        return query.getResultList();
    }

    //find record
    public Account get(Integer key) {
        return em.find(Account.class, key);
    }

    //delete record
    public void delete(Account account) {
        em.remove(get(account.getIdAccount()));
    }

}
