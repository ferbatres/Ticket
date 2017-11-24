/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.StatusSessionBean;
import com.iticket.model.Status;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Irvin.Sanchez
 */
@ManagedBean(name = "statusMBean")
@ViewScoped

public class StatusMBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EJB
    private StatusSessionBean statusSessionBean;
    private Status status= new Status();
    private List<Status> statusList;
    
    
    public StatusMBean() {
        
    }
    
     @PostConstruct
    public void init() {
        statusList = statusSessionBean.findAll();
    }//
    
    
    //Lista de Regiones
    public List<Status> getList() {
        return statusSessionBean.findAll();
    }

    //Nuevo Registro
    public String showNew() {
        return "form_status";
    }

    //Detalle de Registro
    public Status getDetail() {
        return this.status;
    }

    //Regresar
    public String list() {
        return "list_status";
    }
    
     public String showUpdate(Status status) {
        this.status = status;
        return "form_status";
    }

    //Guardar Nuevo Registro
    public String save() {
        try {
            if (this.status.getIdStatus() != null) {
                statusSessionBean.update(this.status);
            } else {
                statusSessionBean.persist(this.status);
            }
             return "list_status";

        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }

    //Eliminar Registros
    public String delete(Status status) {
        try {
            statusSessionBean.delete(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list_status.xhtml";
    }

   public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        try {
            statusSessionBean.update(statusList.get(event.getRowIndex()));
            if (newValue != null && !newValue.equals(oldValue)) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    

}
