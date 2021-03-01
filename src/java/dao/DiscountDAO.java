/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblDiscount;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import utils.DBUtils;

/**
 *
 * @author TiTi
 */
public class DiscountDAO {
    public TblDiscount getDiscountByCode(String code) {    
        EntityManager em = DBUtils.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            
            List<TblDiscount> discounts = em.createNamedQuery("TblDiscount.findByCode")
                    .setParameter("code", code)
                    .getResultList();
            
            transaction.commit();
            
            if (!discounts.isEmpty()) {
                return discounts.get(0);
            }
        } catch (Exception e) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return null;
    }
}
