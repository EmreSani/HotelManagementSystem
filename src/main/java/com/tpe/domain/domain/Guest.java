package com.tpe.domain.domain;

import com.tpe.domain.Address;
import com.tpe.domain.Reservation;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_guest")
public class Guest {

    //todo : auto generated
    @Id//pk
    private Long id;

    @Column(nullable = false)
    private String name;
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "guest",orphanRemoval = true)//tablo ile ilişkiyi kurar:gerek yok
    private List<com.tpe.domain.Reservation> reservations=new ArrayList<>();

//    private String street;
//    private String city;
//    private String country;
//    private int zipcode;

    @Embedded
    private com.tpe.domain.Address address;

    @PrePersist
    public void prePersist(){
        this.createDate=LocalDateTime.now();
    }

    //getter-setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }

    public List<com.tpe.domain.Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public com.tpe.domain.Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", address=" + address +
                '}';
    }
}