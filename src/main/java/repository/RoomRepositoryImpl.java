package repository;

import model.Room;

import java.time.LocalDate;
import java.util.*;

public class RoomRepositoryImpl implements RoomRepository {
    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, List<LocalDate>> reservations = new HashMap<>();

    public RoomRepositoryImpl() {
        rooms.put(1, new Room(1, "studio", 1233.12));
        rooms.put(2, new Room(2, "studio", 1042.01));
        rooms.put(3, new Room(3, "apartment", 2233.12));
        rooms.put(4, new Room(4, "apartment", 3000));

        reservations.put(1, new ArrayList<>(List.of(
                LocalDate.of(2025, 9, 10),
                LocalDate.of(2025, 9, 20)
        )));
        reservations.put(2, new ArrayList<>(List.of(
                LocalDate.of(2025, 9, 11),
                LocalDate.of(2025, 10, 1)
        )));
        reservations.put(3, new ArrayList<>());
        reservations.put(4, new ArrayList<>());
    }


    @Override
    public Optional<Room> findById(int roomId) {
        return Optional.ofNullable(rooms.get(roomId));
    }

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(rooms.values());
    }

    @Override
    public List<LocalDate> findDatesByRoomId(int roomId) {
        List<LocalDate> dates = reservations.get(roomId);

        return dates == null ? List.of() : new ArrayList<>(dates);
    }

    @Override
    public void saveNewReservation(int roomId, List<LocalDate> dates) {
        if (!rooms.containsKey(roomId)) {
            throw new IllegalArgumentException("Комната с id " + roomId + " не найдена.");
        }

        if (dates == null || dates.isEmpty()) {
            throw new IllegalArgumentException("Список дат не может быть пустым.");
        }

        List<LocalDate> existingDates = reservations.computeIfAbsent(roomId, o -> new ArrayList<>());
        boolean hasConflict = dates.stream().anyMatch(existingDates::contains);

        if (hasConflict) {
            throw new IllegalArgumentException("Одна или несколько дат уже забронированы для комнаты с id " + roomId);
        }

        existingDates.addAll(dates);
    }
}
