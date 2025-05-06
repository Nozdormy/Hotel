package repository;

import model.Room;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class RoomRepositoryImpl implements RoomRepository {

    /*
        //TODO: реализовать хранение состояния комнат и бронирований
    */

    @Override
    public Optional<Room> findById(int roomId) {
        //TODO: реализовать логику поиска комнаты по идентификатору
        return Optional.empty();
    }

    @Override
    public Collection<Room> findAll() {
        //TODO: реализовать логику поиска всех комнат
        return List.of();
    }

    @Override
    public Collection<LocalDate> findDatesByRoomId(int roomId) {
        //TODO: реализовать логику поиска бронирований по roomId
        return List.of();
    }

    @Override
    public void saveNewReservation(int roomId, Collection<LocalDate> dates) {
        //TODO: реализовать логику создания новых бронирований
    }
}
