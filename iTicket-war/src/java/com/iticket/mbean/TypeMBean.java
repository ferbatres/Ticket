/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.TypeSessionBean;
import com.iticket.model.Type;
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
public class TypeMBean {
    @EJB
    private TypeSessionBean typeSessionBean;
    private Type type;

    public TypeMBean() {
    }

    //Lista de Regiones
    public List<Type> getList() {
        return typeSessionBean.findAll();
    }

    //Nuevo Registro
    public String showNew() {
        this.type = new Type();
        return "form";
    }

    //Detalle de Registro
    public Type getDetail() {
        return type;
    }

    //Regresar
    public String list() {
        return "list";
    }

    //Guardar Nuevo Registro
    public String save(Type type) {
        try {
            if (this.type.getIdType() != null) {
                typeSessionBean.update(this.type);
            } else {
                typeSessionBean.persist(this.type);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.type = null;
        return "list";
    }

    //Eliminar Registros
    public String delete(Type type) {
        try {
            typeSessionBean.delete(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
