/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblBookingDetails;
import entities.TblRoom;
import java.util.ArrayList;
import java.util.Date;
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
public class BookingDetailsDAO {
    public List<TblBookingDetails> getBookingDetailsInPeriod(Date start, Date end) {
        EntityManager em = DBUtils.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            
            List<TblBookingDetails> details = em.createNamedQuery("TblBookingDetails.findByPeriod")
                    .setParameter("startDate", start)
                    .setParameter("endDate", end)
                    .getResultList();
            
            transaction.commit();
            return details;
        } catch (Exception e) {
            Logger.getLogger(BookingDetailsDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return new ArrayList<>();
    }
    
    public List<TblBookingDetails> getRoomBookingDetailsInPeriod(TblRoom roomId, Date start, Date end) {
        EntityManager em = DBUtils.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            
            List<TblBookingDetails> details = em.createNamedQuery("TblBookingDetails.findRoomInPeriod")
                    .setParameter("startDate", start)
                    .setParameter("endDate", end)
                    .setParameter("roomId", roomId)
                    .getResultList();
            
            transaction.commit();
            return details;
        } catch (Exception e) {
            Logger.getLogger(BookingDetailsDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return new ArrayList<>();
    }
}
