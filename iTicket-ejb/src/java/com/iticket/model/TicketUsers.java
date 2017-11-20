/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel.Batres
 */
@Entity
@Table(name = "Ticket_Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketUsers.findAll", query = "SELECT t FROM TicketUsers t"),
    @NamedQuery(name = "TicketUsers.findByIdTicketUser", query = "SELECT t FROM TicketUsers t WHERE t.idTicketUser = :idTicketUser")})
public class TicketUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTicketUser")
    private Integer idTicketUser;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser")
    @ManyToOne
    private Users idUser;
    @JoinColumn(name = "IdTicket", referencedColumnName = "IdTicket")
    @ManyToOne
    private Ticket idTicket;

    public TicketUsers() {
    }

    public TicketUsers(Integer idTicketUser) {
        this.idTicketUser = idTicketUser;
    }

    public Integer getIdTicketUser() {
        return idTicketUser;
    }

    public void setIdTicketUser(Integer idTicketUser) {
        this.idTicketUser = idTicketUser;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Ticket getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Ticket idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicketUser != null ? idTicketUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketUsers)) {
            return false;
        }
        TicketUsers other = (TicketUsers) object;
        if ((this.idTicketUser == null && other.idTicketUser != null) || (this.idTicketUser != null && !this.idTicketUser.equals(other.idTicketUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iticket.model.TicketUsers[ idTicketUser=" + idTicketUser + " ]";
    }
    
}
