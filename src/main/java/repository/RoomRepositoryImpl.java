package repository;

import model.Room;

import java.util.List;
import java.util.Optional;

public class RoomRepositoryImpl implements RoomRepository {

    /*
        //TODO: реализовать хранение состояния комнат и бронирований
    */

    @Override
    public Optional<Room> findById(int id) {
        //TODO: реализовать логику поиска комнаты по идентификатору
        return Optional.empty();
    }

    @Override
    public List<Room> findAll() {
        //TODO: реализовать логику поиска всех комнат
        return List.of();
    }
}
