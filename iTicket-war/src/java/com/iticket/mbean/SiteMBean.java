/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.mbean;

import com.iticket.ejb.SiteSessionBean;
import com.iticket.model.Site;
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
public class SiteMBean {

    @EJB
    private SiteSessionBean siteSessionBean;

    private Site site;
    
    public SiteMBean() {
    }
    
    //Lista de Regiones
    public List<Site> getList() {
        return siteSessionBean.findAll();
    }

    //Nuevo Registro
    public String showNew() {
        this.site = new Site();
        return "form";
    }

    //Detalle de Registro
    public Site getDetail() {
        return site;
    }

    //Regresar
    public String list() {
        return "list";
    }

    //Guardar Nuevo Registro
    public String save(Site site) {
        try {
            if (this.site.getIdSite() != null) {
                siteSessionBean.update(this.site);
            } else {
                siteSessionBean.persist(this.site);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.site = null;
        return "list";
    }

    //Eliminar Registros
    public String delete(Site site) {
        try {
            siteSessionBean.delete(site);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    public Site getUsers() {
        return site;
    }

    public void setUsers(Site site) {
        this.site = site;
    }
    
}
