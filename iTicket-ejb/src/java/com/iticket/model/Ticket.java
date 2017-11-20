/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel.Batres
 */
@Entity
@Table(name = "Ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByIdTicket", query = "SELECT t FROM Ticket t WHERE t.idTicket = :idTicket"),
    @NamedQuery(name = "Ticket.findByTitle", query = "SELECT t FROM Ticket t WHERE t.title = :title"),
    @NamedQuery(name = "Ticket.findByCreatedDate", query = "SELECT t FROM Ticket t WHERE t.createdDate = :createdDate")})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTicket")
    private Long idTicket;
    @Size(max = 200)
    @Column(name = "Title")
    private String title;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "RowVersion")
    private byte[] rowVersion;
    @OneToMany(mappedBy = "idTicket")
    private List<TicketUsers> ticketUsersList;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser")
    @ManyToOne
    private Users idUser;
    @JoinColumn(name = "IdType", referencedColumnName = "IdType")
    @ManyToOne
    private Type idType;
    @JoinColumn(name = "IdStatus", referencedColumnName = "IdStatus")
    @ManyToOne
    private Status idStatus;
    @OneToMany(mappedBy = "idTicket")
    private List<TicketDetail> ticketDetailList;

    public Ticket() {
    }

    public Ticket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Long idTicket, byte[] rowVersion) {
        this.idTicket = idTicket;
        this.rowVersion = rowVersion;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Type getIdType() {
        return idType;
    }

    public void setIdType(Type idType) {
        this.idType = idType;
    }

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
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
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iticket.model.Ticket[ idTicket=" + idTicket + " ]";
    }
    
}
