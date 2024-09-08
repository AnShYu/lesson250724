package ru.andshir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrucksLoader {

    public List<Truck> loadTruckWtihMinWeightDifference(List<Truck> trucks, List<Box> boxes) throws TooManyTrucksException, NoTrucksException {

        if (trucks.size() > boxes.size()) {
            throw new TooManyTrucksException();
        } else if (trucks.size() == 0) {
            throw new NoTrucksException();
        } else {

            Collections.sort(boxes, (box1, box2) -> Integer.compare(box2.getWeight(), box1.getWeight()));

            int boxesIndex = 0;
            while(boxesIndex != boxes.size()) {
                trucks.get(trucks.size() - 1).addBox(boxes.get(boxesIndex++));
                if (trucks.get(trucks.size() - 1).getTotalLoadedWeight() > trucks.get(trucks.size() - 2).getTotalLoadedWeight()) {
                    Collections.sort(trucks, (truck1, truck2) -> Integer.compare(truck2.getTotalLoadedWeight(), truck1.getTotalLoadedWeight()));
                }
            }
            return trucks;
        }
    }

}

class Truck {

    private List<Box> loadedBoxes = new ArrayList<>();
    private int totalLoadedWeight = 0;

    public void addBox(Box box) {
        loadedBoxes.add(box);
        totalLoadedWeight = totalLoadedWeight + box.getWeight();
    }

    public int getTotalLoadedWeight() {
        return totalLoadedWeight;
    }

}

class Box {

    private int weight;

    public Box(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}

class TooManyTrucksException extends RuntimeException {

}

class NoTrucksException extends RuntimeException {

}
