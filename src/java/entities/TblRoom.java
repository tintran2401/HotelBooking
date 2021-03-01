/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TiTi
 */
@Entity
@Table(name = "tbl_Room", catalog = "HotelBooking", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRoom.findAll", query = "SELECT t FROM TblRoom t"),
    @NamedQuery(name = "TblRoom.findById", query = "SELECT t FROM TblRoom t WHERE t.id = :id"),
    @NamedQuery(name = "TblRoom.findByAmount", query = "SELECT t FROM TblRoom t WHERE t.amount = :amount")})
public class TblRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Amount", nullable = false)
    private int amount;
    @JoinColumn(name = "HotelId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private TblHotel hotelId;
    @JoinColumn(name = "TypeId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private TblRoomType typeId;
    @OneToMany(mappedBy = "roomId")
    private Collection<TblBookingDetails> tblBookingDetailsCollection;

    public TblRoom() {
    }

    public TblRoom(Integer id) {
        this.id = id;
    }

    public TblRoom(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TblHotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(TblHotel hotelId) {
        this.hotelId = hotelId;
    }

    public TblRoomType getTypeId() {
        return typeId;
    }

    public void setTypeId(TblRoomType typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof TblRoom)) {
            return false;
        }
        TblRoom other = (TblRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblRoom[ id=" + id + " ]";
    }
    
}
