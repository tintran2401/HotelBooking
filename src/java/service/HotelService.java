/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BookingDetailsDAO;
import dao.HotelDAO;
import entities.TblBookingDetails;
import entities.TblHotel;
import entities.TblRoom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author TiTi
 */
public class HotelService {

    public List<TblHotel> getHotelsWithAvailableRoom(String name, String location,
            Date checkinDate, Date checkoutDate, int amount) {
        HotelDAO hotelDAO = new HotelDAO();
        List<TblHotel> hotels = hotelDAO.getAllHotels(name, location);

        BookingDetailsDAO detailsDAO = new BookingDetailsDAO();
        List<TblBookingDetails> details = detailsDAO.getBookingDetailsInPeriod(checkinDate, checkoutDate);
        
        List<TblRoom> roomsToRemove = new ArrayList<>();
        List<TblHotel> hotelsToRemove = new ArrayList<>();
        
        // find rooms hotel with insufficient rooms amount
        hotels.forEach((hotel) -> {
            for (TblRoom room : hotel.getTblRoomCollection()) {
                if (room.getAmount() < amount) {
                    roomsToRemove.add(room);
                }
            }
        });
                
        // find unavailable rooms from hotels
        for (TblBookingDetails detail : details) {
            boolean isBreak = false;
            for (TblHotel hotel : hotels) {
                if (isBreak) break;
                for (TblRoom room : hotel.getTblRoomCollection()) {
                    if (room.equals(detail.getRoomId())) {
                        int roomAmount = room.getAmount();
                        room.setAmount(roomAmount - detail.getAmount());
                        
                        if (room.getAmount() < amount) {
                            roomsToRemove.add(room);
                        }
                        isBreak = true;
                        break;
                    }
                }
            }
        }
        
        
        // remove
        hotels.forEach((hotel) -> {
            hotel.getTblRoomCollection().removeAll(roomsToRemove);
            if (hotel.getTblRoomCollection().isEmpty()) {
                hotelsToRemove.add(hotel);
            }
        });
        hotels.removeAll(hotelsToRemove); 
        
        return hotels;
    }
}
