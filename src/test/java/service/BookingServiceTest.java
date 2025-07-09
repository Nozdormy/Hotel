package service;

import model.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.RoomRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    RoomRepositoryImpl roomRepository;

    @InjectMocks
    BookingService bookingService;

    Room room;
    LocalDate checkIn;
    LocalDate checkOut;

    @BeforeEach
    void setUp() {
        room = new Room(1, "studio", 1000);
        checkIn = LocalDate.of(2025, 11, 11);
        checkOut = LocalDate.of(2025, 11, 15);
    }

    @Test
    @DisplayName("Проверка метода isRoomAvailable")
    void givenRoomAndCheckInDate_whenCheckAvailable_thenReturnTrue() {

        when(roomRepository.findDatesByRoomId(room.id())).thenReturn(List.of());

        boolean result = bookingService.isRoomAvailable(room, checkIn, checkOut);

        assertTrue(result);
    }

    @Test
    @DisplayName("Проверка метода isRoomAvailable")
    void givenRoomAndCheckInDate_whenCheckAvailable_thenReturnFalse() {

        when(roomRepository.findDatesByRoomId(room.id())).thenReturn(List.of(checkIn));

        boolean result = bookingService.isRoomAvailable(room, checkIn, checkOut);

        assertFalse(result);
    }

    @Test
    @DisplayName("Проверка функциональности bookRoom")
    void givenRoomAndCheckDates_whenBook_thenReturnTrue() {

        when(roomRepository.findDatesByRoomId(room.id())).thenReturn(List.of());

        boolean result = bookingService.bookRoom(room, checkIn, checkOut);

        assertTrue(result);

        verify(roomRepository).saveNewReservation(eq(room.id()), anyList());
    }

    @Test
    @DisplayName("Проверка функциональности bookRoom")
    void givenRoomAndCheckDates_whenBook_thenReturnFalse() {

        when(roomRepository.findDatesByRoomId(room.id())).thenReturn(List.of(checkIn));

        boolean result = bookingService.bookRoom(room, checkIn, checkOut);

        assertFalse(result);

        verify(roomRepository, never()).saveNewReservation(anyInt(), anyList());
    }

    @Test
    @DisplayName("Проверка функциональности calculatePrice")
    void givenRoomAndCheckDates_whenCalculateSum_thenReturnSum() {

        double result = bookingService.calculatePrice(room, checkIn, checkOut);

        assertEquals(4000, result);
    }
}