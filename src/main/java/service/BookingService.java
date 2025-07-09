package service;

import model.Room;
import repository.RoomRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class BookingService {

    private final RoomRepository roomRepository;

    public BookingService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        if (checkIn == null || checkOut == null || checkOut.isBefore(checkIn)) {
            throw new IllegalArgumentException("Некоретная дата.");
        }

        List<LocalDate> reservedDates = roomRepository.findDatesByRoomId(room.id());

        List<LocalDate> requestedDates = Stream
                .iterate(checkIn, date -> date.isBefore(checkOut), date -> date.plusDays(1))
                .toList();

        boolean hasConflict = requestedDates.stream().anyMatch(reservedDates::contains);

        return !hasConflict;
    }

    public boolean bookRoom(Room room, LocalDate checkIn, LocalDate checkOut) {
        if (!isRoomAvailable(room, checkIn, checkOut)) {
            return false;
        }

        List<LocalDate> requestedDates = Stream.
                iterate(checkIn, date -> date.isBefore(checkOut), date -> date.plusDays(1))
                .toList();
        roomRepository.saveNewReservation(room.id(), requestedDates);

        return true;
    }

    public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

        return nights * room.pricePerNight();
    }
}
