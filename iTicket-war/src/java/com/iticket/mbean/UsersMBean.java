/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.UsersSessionBean;
import com.iticket.model.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel.Batres
 */
@ManagedBean
@RequestScoped
public class UsersMBean {

    @EJB
    private UsersSessionBean usersSessionBean;

    private Users users;

    public UsersMBean() {
    }

    //Lista de Regiones
    public List<Users> getList() {
        return usersSessionBean.findAll();
    }

    //Nuevo Registro
    public String showNew() {
        this.users = new Users();
        return "form";
    }

    //Detalle de Registro
    public Users getDetail() {
        return users;
    }

    //Regresar
    public String list() {
        return "list";
    }

    //Guardar Nuevo Registro
    public String save(Users users) {
        try {
            if (this.users.getIdUser() != null) {
                usersSessionBean.update(this.users);
            } else {
                usersSessionBean.persist(this.users);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.users = null;
        return "list";
    }

    //Eliminar Registros
    public String delete(Users users) {
        try {
            usersSessionBean.delete(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
