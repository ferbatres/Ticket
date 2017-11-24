/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.UsersSessionBean;
import com.iticket.model.Users;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Daniel.Batres
 */
@ManagedBean(name = "usersMBean")
@ViewScoped
public class UsersMBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private UsersSessionBean usersSessionBean;
    private Users users = new Users();
    private List<Users> userList;

    public UsersMBean() {

    }

    @PostConstruct
    public void init() {
        userList = usersSessionBean.findAll();
    }//

    //Lista de Regiones
    public List<Users> getList() {
        return usersSessionBean.findAll();
    }

    //Nuevo Registro
    public String showNew() {
        return "form_user";
    }

    //Detalle de Registro
    public Users getDetail() {
        return this.users;
    }

    //Regresar
    public String showList() {
        return "list_user";
    }

    public String showUpdate(Users users) {
        this.users = users;
        return "form_user";
    }

    //Guardar Nuevo Registro
    public String save() {
        try {

            if (this.users.getIdUser() != null) {
                usersSessionBean.update(this.users);
            } else {
                usersSessionBean.persist(this.users);
            }
            return "list_user";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Eliminar Registros
    public String delete(Users users) {
        try {
            usersSessionBean.delete(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list_user.xhtml";
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        try {
            usersSessionBean.update(userList.get(event.getRowIndex()));
            if (newValue != null && !newValue.equals(oldValue)) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

}
