package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotMainTest {

    private ParkingLot parkingLot = new ParkingLot();

    @Test
    public void should_return_car_when_fetch_car_given_ticket() {
        //given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkingCar(parkingLot,car);
        //when
        Car fetchCar = parkingBoy.fetchCar(parkingLot,ticket);
        //then
        Assertions.assertSame(car, car);
    }

    @Test
    public void should_return_tickets_when_paring_car_given_multiple_car() {
        //given
        Car car = new Car("car","no1");
        Car benz = new Car("benz","no2");
        Car honda = new Car("honda","no3");
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkingCar(parkingLot, car);
        Ticket ticket1 = parkingBoy.parkingCar(parkingLot, benz);
        Ticket ticket2 = parkingBoy.parkingCar(parkingLot, honda);
        //when
        Car fetchCar = parkingBoy.fetchCar(parkingLot, ticket);
        Car fetchCar1 = parkingBoy.fetchCar(parkingLot, ticket1);
        Car fetchCar2 = parkingBoy.fetchCar(parkingLot, ticket2);
        //then
        Assertions.assertSame(car, fetchCar);
        Assertions.assertSame(benz, fetchCar1);
        Assertions.assertSame(honda, fetchCar2);
    }

    @Test
    public void should_return_no_car_when_fetch_car_given_wrong_ticket() {
        //given
        Car benz = new Car("benz","no2");
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket fakeTicket = new Ticket();
        //when
        Car fetchCar = parkingBoy.fetchCar(parkingLot, fakeTicket);
        //then
        Assertions.assertSame(null, fetchCar);
    }
}
