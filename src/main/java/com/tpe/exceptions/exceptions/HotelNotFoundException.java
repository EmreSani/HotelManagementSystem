package com.tpe.exceptions.exceptions;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}
//ödev: RoomNotFoundException,
// ReservationNotFoundException, GuestNotFoundException