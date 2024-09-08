package ru.andshir;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrucksLoaderTest {

    @Test
    public void NoTrucksExceptionTest() {
        List<Truck> trucks = new ArrayList<>();

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(1));
        boxes.add(new Box(100));


        TrucksLoader trucksLoader = new TrucksLoader();
        assertThrows(NoTrucksException.class, () -> trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes));
    }

    @Test
    public void TooManyTrucksExceptionTest() {
        List<Truck> trucks = new ArrayList<>();
        int numberOfTrucks = 2;
        for (int i = 0; i < numberOfTrucks; i++) {
            Truck truck = new Truck();
            trucks.add(truck);
        }

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10));

        TrucksLoader trucksLoader = new TrucksLoader();
        assertThrows(TooManyTrucksException.class, () -> trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes));
    }

    @Test
    public void twoTrucksLoadingTest1() {
        List<Truck> trucks = new ArrayList<>();
        int numberOfTrucks = 2;
        for (int i = 0; i < numberOfTrucks; i++) {
            Truck truck = new Truck();
            trucks.add(truck);
        }

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10));
        boxes.add(new Box(1));
        boxes.add(new Box(100));
        boxes.add(new Box(1));


        TrucksLoader trucksLoader = new TrucksLoader();
        List<Truck> result = trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes);

        assertEquals(100, result.get(0).getTotalLoadedWeight());
        assertEquals(12, result.get(1).getTotalLoadedWeight());
    }

    @Test
    public void twoTrucksLoadingTest2() {
        List<Truck> trucks = new ArrayList<>();
        int numberOfTrucks = 2;
        for (int i = 0; i < numberOfTrucks; i++) {
            Truck truck = new Truck();
            trucks.add(truck);
        }

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10));
        boxes.add(new Box(5));
        boxes.add(new Box(2));
        boxes.add(new Box(1));

        TrucksLoader trucksLoader = new TrucksLoader();
        List<Truck> result = trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes);

        assertEquals(10, result.get(0).getTotalLoadedWeight());
        assertEquals(8, result.get(1).getTotalLoadedWeight());
    }

    @Test
    public void threeTrucksLoadingTest1() {
        List<Truck> trucks = new ArrayList<>();
        int numberOfTrucks = 3;
        for (int i = 0; i < numberOfTrucks; i++) {
            Truck truck = new Truck();
            trucks.add(truck);
        }

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(20));
        boxes.add(new Box(15));
        boxes.add(new Box(5));
        boxes.add(new Box(1));
        boxes.add(new Box(1));

        TrucksLoader trucksLoader = new TrucksLoader();
        List<Truck> result = trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes);

        assertEquals(20, result.get(0).getTotalLoadedWeight());
        assertEquals(15, result.get(1).getTotalLoadedWeight());
        assertEquals(7, result.get(2).getTotalLoadedWeight());
    }

    @Test
    public void threeTrucksLoadingTest2() {
        List<Truck> trucks = new ArrayList<>();
        int numberOfTrucks = 3;
        for (int i = 0; i < numberOfTrucks; i++) {
            Truck truck = new Truck();
            trucks.add(truck);
        }

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(5));
        boxes.add(new Box(4));
        boxes.add(new Box(3));
        boxes.add(new Box(7));
        boxes.add(new Box(1));

        TrucksLoader trucksLoader = new TrucksLoader();
        List<Truck> result = trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes);

        assertEquals(7, result.get(0).getTotalLoadedWeight());
        assertEquals(7, result.get(1).getTotalLoadedWeight());
        assertEquals(6, result.get(2).getTotalLoadedWeight());
    }

    @Test
    public void threeTrucksLoadingTest3() {
        List<Truck> trucks = new ArrayList<>();
        int numberOfTrucks = 3;
        for (int i = 0; i < numberOfTrucks; i++) {
            Truck truck = new Truck();
            trucks.add(truck);
        }

        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(1));
        boxes.add(new Box(1));
        boxes.add(new Box(1));
        boxes.add(new Box(1));
        boxes.add(new Box(1));

        TrucksLoader trucksLoader = new TrucksLoader();
        List<Truck> result = trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes);

        assertEquals(2, result.get(0).getTotalLoadedWeight());
        assertEquals(2, result.get(1).getTotalLoadedWeight());
        assertEquals(1, result.get(2).getTotalLoadedWeight());
    }

    @Test
    public void hundredTrucksLoadingTest() {
        List<Truck> trucks = new ArrayList<>();
        int numberOfTrucks = 100;
        for (int i = 0; i < numberOfTrucks; i++) {
            Truck truck = new Truck();
            trucks.add(truck);
        }

        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < 105; i++) {
            boxes.add(new Box(1));
        }

        TrucksLoader trucksLoader = new TrucksLoader();
        List<Truck> result = trucksLoader.loadTruckWtihMinWeightDifference(trucks, boxes);

        for (int i = 0; i < 5; i++) {
            assertEquals(2, result.get(i).getTotalLoadedWeight());
        }
        for (int i = 5; i < 100; i++) {
            assertEquals(1, result.get(i).getTotalLoadedWeight());
        }
    }
}