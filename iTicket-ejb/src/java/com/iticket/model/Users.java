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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUser", query = "SELECT u FROM Users u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByAlias", query = "SELECT u FROM Users u WHERE u.alias = :alias")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdUser")
    private Integer idUser;
    @Size(max = 200)
    @Column(name = "Name")
    private String name;
    @Size(max = 250)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 25)
    @Column(name = "Alias")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "RowVersion")
    private byte[] rowVersion;
    @OneToMany(mappedBy = "idUser")
    private List<TicketUsers> ticketUsersList;
    @JoinColumn(name = "IdAccount", referencedColumnName = "IdAccount")
    @ManyToOne
    private Account idAccount;
    @OneToMany(mappedBy = "idUser")
    private List<Ticket> ticketList;
    @OneToMany(mappedBy = "idUser")
    private List<TicketDetail> ticketDetailList;

    public Users() {
    }

    public Users(Integer idUser) {
        this.idUser = idUser;
    }

    public Users(Integer idUser, byte[] rowVersion) {
        this.idUser = idUser;
        this.rowVersion = rowVersion;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public byte[] getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(byte[] rowVersion) {
        this.rowVersion = rowVersion;
    }

    @XmlTransient
    public List<TicketUsers> getTicketUsersList() {
        return ticketUsersList;
    }

    public void setTicketUsersList(List<TicketUsers> ticketUsersList) {
        this.ticketUsersList = ticketUsersList;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @XmlTransient
    public List<TicketDetail> getTicketDetailList() {
        return ticketDetailList;
    }

    public void setTicketDetailList(List<TicketDetail> ticketDetailList) {
        this.ticketDetailList = ticketDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iticket.model.Users[ idUser=" + idUser + " ]";
    }
    
}
