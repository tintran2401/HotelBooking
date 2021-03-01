/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblRoom;
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
public class RoomDAO {
    public TblRoom getRoomById(int roomId) {    
        EntityManager em = DBUtils.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            
            List<TblRoom> rooms = em.createNamedQuery("TblRoom.findById")
                    .setParameter("id", roomId)
                    .getResultList();
            
            transaction.commit();
            
            if (!rooms.isEmpty()) {
                return rooms.get(0);
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
