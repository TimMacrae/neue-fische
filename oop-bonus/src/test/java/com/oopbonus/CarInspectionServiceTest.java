package com.oopbonus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarInspectionServiceTest {
    CarInspectionService carInspectionService = new CarInspectionService();

    @Test
    public void hasFourTires_shouldBeTrue_whenCarHave4Tires() {
        Car car = new Car(4, 4, true, true);
        assertTrue(carInspectionService.hasFourTires(car));
    }

    @Test
    public void hasFourTires_shouldBeFalse_whenDontHave4Tires() {
        Car car = new Car(2, 4, false, true);
        assertFalse(carInspectionService.hasFourTires(car));
    }

    @Test
    public void hasSeatbelt_shouldBeFalse_whenNoSeatBelt() {
        Car car = new Car(4, 4, false, true);
        assertFalse(carInspectionService.hasSeatbelt(car));
    }

    @Test
    public void hasSeatbelt_shouldBeTrue_whenHaveSeatBelt() {
        Car car = new Car(4, 4, true, true);
        assertTrue(carInspectionService.hasSeatbelt(car));
    }

    @Test
    public void hasAirBag_shouldBeFalse_whenNoAirBag() {
        Car car = new Car(4, 4, false, false);
        assertFalse(carInspectionService.hasAirBag(car));
    }

    @Test
    public void hasAirBag_shouldBeTrue_whenHaveAirBag() {
        Car car = new Car(4, 4, true, true);
        assertTrue(carInspectionService.hasAirBag(car));
    }

    @Test
    public void hasThreeOrFiveDoors_shouldBeFalse_whenTwoDoors() {
        Car car = new Car(3, 2, true, true);
        assertFalse(carInspectionService.hasThreeOrFiveDoors(car));
    }

    @Test
    public void hasThreeOrFiveDoors_shouldBeTrue_whenThreeDoors() {
        Car car = new Car(3, 3, true, true);
        assertTrue(carInspectionService.hasThreeOrFiveDoors(car));
    }

    @Test
    public void hasThreeOrFiveDoors_shouldBeTrue_whenFiveDoors() {
        Car car = new Car(3, 5, true, true);
        assertTrue(carInspectionService.hasThreeOrFiveDoors(car));
    }

    @Test
    public void checkCar_shouldBeTrue_whenAllCheckCompleted() {
        Car car = new Car(4, 5, true, true);
        assertTrue(carInspectionService.checkCar(car));
    }

    @Test
    public void checkCar_shouldBeFalse_whenCheckSeatBeltFails() {
        Car car = new Car(4, 5, false, true);
        assertFalse(carInspectionService.checkCar(car));
    }

    @Test
    public void checkCar_shouldBeFalse_whenCheckAirbagFails() {
        Car car = new Car(4, 5, true, false);
        assertFalse(carInspectionService.checkCar(car));
    }

    @Test
    public void checkCar_shouldBeFalse_whenCheckFiveDoorFails() {
        Car car = new Car(4, 4, true, false);
        assertFalse(carInspectionService.checkCar(car));
    }

    @Test
    public void checkCar_shouldBeFalse_whenCheckFourTiesFails() {
        Car car = new Car(2, 5, true, true);
        assertFalse(carInspectionService.checkCar(car));
    }
}