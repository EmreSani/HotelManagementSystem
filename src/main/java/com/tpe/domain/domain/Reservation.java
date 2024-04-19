package com.tpe.domain.domain;

import com.tpe.domain.Guest;
import com.tpe.domain.Room;
import com.tpe.service.RoomService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_reservation")
public class Reservation {

    //todo : auto generated
    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDate checkInDate;
    @Column(nullable = false)
    private LocalDate checkOutDate;
    @ManyToOne//fk ile ilişki kurar
    @JoinColumn(nullable = false)
    private com.tpe.domain.Guest guest;

    @ManyToOne
    @JoinColumn(nullable = false)
    private com.tpe.domain.Room room;

    //getter-setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public com.tpe.domain.Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public com.tpe.domain.Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    //toString

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", room=" + room +
                '}';
    }
}
