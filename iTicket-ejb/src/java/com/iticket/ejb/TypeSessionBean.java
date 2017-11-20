/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.ejb;

import com.iticket.model.Type;
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
public class TypeSessionBean {
    @PersistenceContext(unitName = "iTicket-ejbPU")
    private EntityManager em;

    public void persist(Type type) {
        em.persist(type);
    }
    //Update an existing Department
    public void update(Type type) throws Exception {
        em.merge(type);
    }

    //find by id
    public Type findById(String typeId) {
        //Departments dep = new Departments();
        Query query = em.createNamedQuery("Users.findByIdUser", Type.class);
        query.setParameter("IdUser", typeId);
        //dep = (Departments)query.getSingleResult();
        return (Type) query.getSingleResult();
    }

    //Get list
    public List<Type> findAll() {

        TypedQuery<Type> query = em.createNamedQuery("findAll", Type.class);
        return query.getResultList();
    }

    //find record
    public Type get(String key) {
        return em.find(Type.class, key);
    }

    //delete record
    public void delete(Type type) {
        em.remove(get(type.getIdType().toString()));
    }
    
}
