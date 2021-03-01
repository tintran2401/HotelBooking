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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tbl_Booking", catalog = "HotelBooking", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBooking.findAll", query = "SELECT t FROM TblBooking t"),
    @NamedQuery(name = "TblBooking.findById", query = "SELECT t FROM TblBooking t WHERE t.id = :id"),
    @NamedQuery(name = "TblBooking.findByDateCreated", query = "SELECT t FROM TblBooking t WHERE t.dateCreated = :dateCreated"),
    @NamedQuery(name = "TblBooking.findByDiscountPercent", query = "SELECT t FROM TblBooking t WHERE t.discountPercent = :discountPercent")})
public class TblBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DateCreated", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "DiscountPercent")
    private Integer discountPercent;
    @JoinColumn(name = "UserEmail", referencedColumnName = "Email", nullable = false)
    @ManyToOne(optional = false)
    private TblAccount userEmail;
    @JoinColumn(name = "StatusId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private TblStatus statusId;
    @OneToMany(mappedBy = "bookingId", cascade = CascadeType.PERSIST)
    private Collection<TblBookingDetails> tblBookingDetailsCollection;

    public TblBooking() {
    }

    public TblBooking(Integer id) {
        this.id = id;
    }

    public TblBooking(Integer id, Date dateCreated) {
        this.id = id;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public TblAccount getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(TblAccount userEmail) {
        this.userEmail = userEmail;
    }

    public TblStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(TblStatus statusId) {
        this.statusId = statusId;
    }

    @XmlTransient
    public Collection<TblBookingDetails> getTblBookingDetailsCollection() {
        return tblBookingDetailsCollection;
    }

    public void setTblBookingDetailsCollection(Collection<TblBookingDetails> tblBookingDetailsCollection) {
        this.tblBookingDetailsCollection = tblBookingDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBooking)) {
            return false;
        }
        TblBooking other = (TblBooking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblBooking[ id=" + id + " ]";
    }
    
}
