/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel.Batres
 */
@Entity
@Table(name = "Site")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s"),
    @NamedQuery(name = "Site.findByIdSite", query = "SELECT s FROM Site s WHERE s.idSite = :idSite"),
    @NamedQuery(name = "Site.findByName", query = "SELECT s FROM Site s WHERE s.name = :name"),
    @NamedQuery(name = "Site.findByDirection", query = "SELECT s FROM Site s WHERE s.direction = :direction")})
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdSite")
    private Integer idSite;
    @Size(max = 200)
    @Column(name = "Name")
    private String name;
    @Size(max = 500)
    @Column(name = "Direction")
    private String direction;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "RowVersion")
    private byte[] rowVersion;
    @OneToMany(mappedBy = "idSite")
    private List<Account> accountList;

    public Site() {
    }

    public Site(Integer idSite) {
        this.idSite = idSite;
    }

    public Site(Integer idSite, byte[] rowVersion) {
        this.idSite = idSite;
        this.rowVersion = rowVersion;
    }

    public Integer getIdSite() {
        return idSite;
    }

    public void setIdSite(Integer idSite) {
        this.idSite = idSite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public byte[] getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(byte[] rowVersion) {
        this.rowVersion = rowVersion;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSite != null ? idSite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.idSite == null && other.idSite != null) || (this.idSite != null && !this.idSite.equals(other.idSite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iticket.model.Site[ idSite=" + idSite + " ]";
    }
    
}
