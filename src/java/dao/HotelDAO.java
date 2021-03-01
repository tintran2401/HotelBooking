/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblHotel;
import java.util.ArrayList;
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
public class HotelDAO {
    public List<TblHotel> getAllHotels() {    
        EntityManager em = DBUtils.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            
            List<TblHotel> hotels = em.createNamedQuery("TblHotel.findAll")
                    .getResultList();
            
            transaction.commit();
            return hotels;
        } catch (Exception e) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return new ArrayList<>();
    }
    
    public List<TblHotel> getAllHotels(String name, String location) {    
        EntityManager em = DBUtils.getEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            
            List<TblHotel> hotels = em.createNamedQuery("TblHotel.findAllWith")
                    .setParameter("name", "%" + name + "%")
                    .setParameter("location", "%" + location + "%")
                    .getResultList();
            
            transaction.commit();
            return hotels;
        } catch (Exception e) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return new ArrayList<>();
    }
    
    
}
