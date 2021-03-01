/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TiTi
 */
@Entity
@Table(name = "tbl_Account", catalog = "HotelBooking", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAccount.findAll", query = "SELECT t FROM TblAccount t"),
    @NamedQuery(name = "TblAccount.findByEmail", query = "SELECT t FROM TblAccount t WHERE t.email = :email"),
    @NamedQuery(name = "TblAccount.findByFullName", query = "SELECT t FROM TblAccount t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "TblAccount.findByPassword", query = "SELECT t FROM TblAccount t WHERE t.password = :password"),
    @NamedQuery(name = "TblAccount.findByPhone", query = "SELECT t FROM TblAccount t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblAccount.findByDateCreated", query = "SELECT t FROM TblAccount t WHERE t.dateCreated = :dateCreated"),
    @NamedQuery(name = "TblAccount.findByAddress", query = "SELECT t FROM TblAccount t WHERE t.address = :address")})
public class TblAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Basic(optional = false)
    @Column(name = "FullName", nullable = false, length = 50)
    private String fullName;
    @Basic(optional = false)
    @Column(name = "Password", nullable = false, length = 50)
    private String password;
    @Basic(optional = false)
    @Column(name = "Phone", nullable = false)
    private int phone;
    @Basic(optional = false)
    @Column(name = "DateCreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "Address", nullable = false, length = 50)
    private String address;
    @JoinColumn(name = "RoleId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private TblRole roleId;
    @JoinColumn(name = "StatusId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private TblStatus statusId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEmail")
    private Collection<TblBooking> tblBookingCollection;

    public TblAccount() {
    }

    public TblAccount(String email) {
        this.email = email;
    }

    public TblAccount(String email, String fullName, String password, int phone, Date dateCreated, String address) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.dateCreated = dateCreated;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TblRole getRoleId() {
        return roleId;
    }

    public void setRoleId(TblRole roleId) {
        this.roleId = roleId;
    }

    public TblStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(TblStatus statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public Collection<TblBooking> getTblBookingCollection() {
        return tblBookingCollection;
    }

    public void setTblBookingCollection(Collection<TblBooking> tblBookingCollection) {
        this.tblBookingCollection = tblBookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAccount)) {
            return false;
        }
        TblAccount other = (TblAccount) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblAccount[ email=" + email + " ]";
    }
    
}
