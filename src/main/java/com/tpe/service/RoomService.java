package com.tpe.service;


import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import com.tpe.repository.RoomRepository;

import java.util.Scanner;

//serviceler servicelerle veya kendi repoları ile iletişime geçer
public class RoomService {

    private Scanner scanner=new Scanner(System.in);

    private final HotelService hotelService;

    private final RoomRepository roomRepository;

    //param const
    public RoomService(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }

    public void saveRoom() {

        Room room=new Room();

        System.out.println("Enter room ID : ");
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter room number : ");
        room.setNumber(scanner.nextLine());

        System.out.println("Enter room capacity : ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter hotel ID : ");
        Long hotelId=scanner.nextLong();
        scanner.nextLine();

        //girilen id hangi otele ait
        Hotel foundHotel =hotelService.findHotelById(hotelId);

        if (foundHotel!=null){

        room.setHotel(foundHotel);

     //   foundHotel.getRooms().add(room);

        roomRepository.save(room);
        System.out.println("Room is saved successfully. Room id : " + room.getId());

        } else {
            System.out.println("Room could not saved!");
        }
    }

    //todo: findRoomById getAllRooms
    public Room findRoomById(Long roomId) {

        return null;
    }

    public void getAllRooms() {
    }
}