/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tbl_Hotel", catalog = "HotelBooking", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHotel.findAll", query = "SELECT t FROM TblHotel t"),
    @NamedQuery(name = "TblHotel.findAllWith", query = "SELECT t FROM TblHotel t WHERE t.name LIKE :name AND t.location LIKE :location"),
    @NamedQuery(name = "TblHotel.findById", query = "SELECT t FROM TblHotel t WHERE t.id = :id"),
    @NamedQuery(name = "TblHotel.findByName", query = "SELECT t FROM TblHotel t WHERE t.name = :name"),
    @NamedQuery(name = "TblHotel.findByLocation", query = "SELECT t FROM TblHotel t WHERE t.location = :location")})
public class TblHotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Location", length = 50)
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelId")
    private Collection<TblRoom> tblRoomCollection;

    public TblHotel() {
    }

    public TblHotel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<TblRoom> getTblRoomCollection() {
        return tblRoomCollection;
    }

    public void setTblRoomCollection(Collection<TblRoom> tblRoomCollection) {
        this.tblRoomCollection = tblRoomCollection;
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
        if (!(object instanceof TblHotel)) {
            return false;
        }
        TblHotel other = (TblHotel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblHotel[ id=" + id + " ]";
    }
    
}
