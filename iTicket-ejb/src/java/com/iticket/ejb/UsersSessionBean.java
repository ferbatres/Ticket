/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.Users;
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
public class UsersSessionBean {

    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(Users users) {
        em.persist(users);
    }

    //Update an existing Department
    public void update(Users users) throws Exception {
        em.merge(users);
    }

    //find by id
    public Users findById(String usersId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Users.findByIdUser", Users.class);
        query.setParameter("IdUser", usersId);
        //dep = (Departments)query.getSingleResult();
        return (Users) query.getSingleResult();
    }

    //Get list
    public List<Users> findAll() {

        TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
        return query.getResultList();
    }

    //find record
    public Users get(String key) {
        return em.find(Users.class, key);
    }

    //delete record
    public void delete(Users users) {
        em.remove(get(users.getIdUser().toString()));
    }

}
