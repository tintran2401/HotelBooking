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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TiTi
 */
@Entity
@Table(name = "tbl_Discount", catalog = "HotelBooking", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDiscount.findAll", query = "SELECT t FROM TblDiscount t"),
    @NamedQuery(name = "TblDiscount.findById", query = "SELECT t FROM TblDiscount t WHERE t.id = :id"),
    @NamedQuery(name = "TblDiscount.findByCode", query = "SELECT t FROM TblDiscount t WHERE t.code = :code"),
    @NamedQuery(name = "TblDiscount.findByDiscountPercent", query = "SELECT t FROM TblDiscount t WHERE t.discountPercent = :discountPercent"),
    @NamedQuery(name = "TblDiscount.findByExpiredDate", query = "SELECT t FROM TblDiscount t WHERE t.expiredDate = :expiredDate")})
public class TblDiscount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "Code", length = 50)
    private String code;
    @Column(name = "DiscountPercent")
    private Integer discountPercent;
    @Column(name = "ExpiredDate")
    @Temporal(TemporalType.DATE)
    private Date expiredDate;

    public TblDiscount() {
    }

    public TblDiscount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
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
        if (!(object instanceof TblDiscount)) {
            return false;
        }
        TblDiscount other = (TblDiscount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblDiscount[ id=" + id + " ]";
    }
    
}
