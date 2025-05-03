package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    /*
        TODO: добавить моки по необходимости
    */
    @BeforeEach
    void setUp() {
        //TODO: По необходимости
    }

    @Test
    @DisplayName("Проверка метода isRoomAvailable")
    void givenRoomAndCheckInDate_whenCheckAvailable_thenReturnTrue() {
        //TODO: Тест в формате given when then
    }

    @Test
    @DisplayName("Проверка метода isRoomAvailable")
    void givenRoomAndCheckInDate_whenCheckAvailable_thenReturnFalse() {
        //TODO: Тест в формате given when then
    }

    @Test
    @DisplayName("Проверка функциональности bookRoom")
    void givenRoomAndCheckDates_whenBook_thenReturnTrue() {
        //TODO: Тест в формате given when then
    }

    @Test
    @DisplayName("Проверка функциональности bookRoom")
    void givenRoomAndCheckDates_whenBook_thenReturnFalse() {
        //TODO: Тест в формате given when then
    }

    @Test
    @DisplayName("Проверка функциональности calculatePrice")
    void givenRoomAndCheckDates_whenCalculateSum_thenReturnSum() {
        //TODO: Тест в формате given when then
    }
}