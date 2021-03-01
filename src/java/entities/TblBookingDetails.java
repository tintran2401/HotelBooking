/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiTi
 */
@Entity
@Table(name = "tbl_BookingDetails", catalog = "HotelBooking", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBookingDetails.findAll", query = "SELECT t FROM TblBookingDetails t"),
    @NamedQuery(name = "TblBookingDetails.findById", query = "SELECT t FROM TblBookingDetails t WHERE t.id = :id"),
    @NamedQuery(name = "TblBookingDetails.findByCheckInDate", query = "SELECT t FROM TblBookingDetails t WHERE t.checkInDate = :checkInDate"),
    @NamedQuery(name = "TblBookingDetails.findByCheckOutDate", query = "SELECT t FROM TblBookingDetails t WHERE t.checkOutDate = :checkOutDate"),
    @NamedQuery(name = "TblBookingDetails.findByPeriod", query = "SELECT t FROM TblBookingDetails t WHERE t.checkInDate <= :endDate AND t.checkOutDate >= :startDate"),
    @NamedQuery(name = "TblBookingDetails.findRoomInPeriod", query = "SELECT t FROM TblBookingDetails t WHERE t.checkInDate <= :endDate AND t.checkOutDate >= :startDate AND t.roomId = :roomId"),
    @NamedQuery(name = "TblBookingDetails.findByAmount", query = "SELECT t FROM TblBookingDetails t WHERE t.amount = :amount"),
    @NamedQuery(name = "TblBookingDetails.findByUnitPrice", query = "SELECT t FROM TblBookingDetails t WHERE t.unitPrice = :unitPrice")})
public class TblBookingDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CheckInDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInDate;
    @Column(name = "CheckOutDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutDate;
    @Column(name = "Amount")
    private Integer amount;
    @Column(name = "UnitPrice")
    private Integer unitPrice;
    @JoinColumn(name = "BookingId", referencedColumnName = "Id")
    @ManyToOne
    private TblBooking bookingId;
    @JoinColumn(name = "RoomId", referencedColumnName = "Id")
    @ManyToOne
    private TblRoom roomId;

    public TblBookingDetails() {
    }

    public TblBookingDetails(Date checkInDate, Date checkOutDate, Integer amount, Integer unitPrice, TblRoom roomId) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.roomId = roomId;
    }
    
    public TblBookingDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public TblBooking getBookingId() {
        return bookingId;
    }

    public void setBookingId(TblBooking bookingId) {
        this.bookingId = bookingId;
    }

    public TblRoom getRoomId() {
        return roomId;
    }

    public void setRoomId(TblRoom roomId) {
        this.roomId = roomId;
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
        if (!(object instanceof TblBookingDetails)) {
            return false;
        }
        TblBookingDetails other = (TblBookingDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblBookingDetails[ id=" + id + " ]";
    }
    
}
