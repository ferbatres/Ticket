/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iticket.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel.Batres
 */
@Entity
@Table(name = "TicketDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketDetail.findAll", query = "SELECT t FROM TicketDetail t"),
    @NamedQuery(name = "TicketDetail.findByIdTicketDetail", query = "SELECT t FROM TicketDetail t WHERE t.idTicketDetail = :idTicketDetail"),
    @NamedQuery(name = "TicketDetail.findByComments", query = "SELECT t FROM TicketDetail t WHERE t.comments = :comments"),
    @NamedQuery(name = "TicketDetail.findByCreatedDate", query = "SELECT t FROM TicketDetail t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "TicketDetail.findByIdStatus", query = "SELECT t FROM TicketDetail t WHERE t.idStatus = :idStatus")})
public class TicketDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdTicketDetail")
    private Long idTicketDetail;
    @Size(max = 2147483647)
    @Column(name = "Comments")
    private String comments;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "IdStatus")
    private Integer idStatus;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "RowVersion")
    private byte[] rowVersion;
    @JoinColumn(name = "IdUser", referencedColumnName = "IdUser")
    @ManyToOne
    private Users idUser;
    @JoinColumn(name = "IdTicket", referencedColumnName = "IdTicket")
    @ManyToOne
    private Ticket idTicket;

    public TicketDetail() {
    }

    public TicketDetail(Long idTicketDetail) {
        this.idTicketDetail = idTicketDetail;
    }

    public TicketDetail(Long idTicketDetail, byte[] rowVersion) {
        this.idTicketDetail = idTicketDetail;
        this.rowVersion = rowVersion;
    }

    public Long getIdTicketDetail() {
        return idTicketDetail;
    }

    public void setIdTicketDetail(Long idTicketDetail) {
        this.idTicketDetail = idTicketDetail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public byte[] getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(byte[] rowVersion) {
        this.rowVersion = rowVersion;
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
        hash += (idTicketDetail != null ? idTicketDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketDetail)) {
            return false;
        }
        TicketDetail other = (TicketDetail) object;
        if ((this.idTicketDetail == null && other.idTicketDetail != null) || (this.idTicketDetail != null && !this.idTicketDetail.equals(other.idTicketDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iticket.model.TicketDetail[ idTicketDetail=" + idTicketDetail + " ]";
    }
    
}
