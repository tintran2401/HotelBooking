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
@Table(name = "tbl_RoomType", catalog = "HotelBooking", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRoomType.findAll", query = "SELECT t FROM TblRoomType t"),
    @NamedQuery(name = "TblRoomType.findById", query = "SELECT t FROM TblRoomType t WHERE t.id = :id"),
    @NamedQuery(name = "TblRoomType.findByName", query = "SELECT t FROM TblRoomType t WHERE t.name = :name"),
    @NamedQuery(name = "TblRoomType.findByPrice", query = "SELECT t FROM TblRoomType t WHERE t.price = :price")})
public class TblRoomType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Price")
    private Integer price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<TblRoom> tblRoomCollection;

    public TblRoomType() {
    }

    public TblRoomType(Integer id) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        if (!(object instanceof TblRoomType)) {
            return false;
        }
        TblRoomType other = (TblRoomType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblRoomType[ id=" + id + " ]";
    }
    
}
