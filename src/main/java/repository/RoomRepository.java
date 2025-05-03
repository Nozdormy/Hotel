package repository;

import model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {

    Optional<Room> findById(int id);

    List<Room> findAll();
}
