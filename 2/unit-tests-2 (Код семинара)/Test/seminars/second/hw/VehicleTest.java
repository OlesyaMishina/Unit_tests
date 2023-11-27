package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle moto;

   @BeforeEach
    void setUp(){
       moto = new Motorcycle("Kawasaki", "z1000", 2018);
       car = new Car("Dodge", "Ram", 2010);
   }


//  Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
//  (используя оператор instanceof).
    @Test
    public void testCarIsInstanceOfVehicle() {
       assertThat(car instanceof Vehicle);
    }

//  Проверить, что объект Car создается с 4-мя колесами.
    @Test
    void carWheels() {
    assertThat(car.getNumWheels()).isEqualTo(4);
    }

//  Проверить, что объект Motorcycle создается с 2-мя колесами.
    @Test
    void motoWheels() {
    assertThat(moto.getNumWheels()).isEqualTo(2);
    }

//    Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive())
    @Test
    void testDriveCar() {
       car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
   }

//   Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
//   (используя метод testDrive()).

    @Test
    void testDriveMotorcycle() {
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

//    Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция
//    движения транспорта) машина останавливается (speed = 0).
    @Test
    void parkCar() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

//    Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция
//    движения транспорта) мотоцикл останавливается (speed = 0).
    @Test
    void parkMotorcycle() {
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}