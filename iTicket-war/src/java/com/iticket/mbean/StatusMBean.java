/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.StatusSessionBean;
import com.iticket.model.Status;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Irvin.Sanchez
 */
@ManagedBean
@RequestScoped
public class StatusMBean {
    @EJB
    private StatusSessionBean statusSessionBean;
    private Status status;
    
    
    public StatusMBean() {
    }
    
    //Lista de Regiones
    public List<Status> getList() {
        return statusSessionBean.findAll();
    }

    //Nuevo Registro
    public String showNew() {
        this.status = new Status();
        return "form";
    }

    //Detalle de Registro
    public Status getDetail() {
        return status;
    }

    //Regresar
    public String list() {
        return "list";
    }

    //Guardar Nuevo Registro
    public String save(Status status) {
        try {
            if (this.status.getIdStatus() != null) {
                statusSessionBean.update(this.status);
            } else {
                statusSessionBean.persist(this.status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.status = null;
        return "list";
    }

    //Eliminar Registros
    public String delete(Status users) {
        try {
            statusSessionBean.delete(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
