package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{
    IWorldMap map;
    MoveDirection[] moves;
    public List<Animal> animals = new LinkedList<>();

    public SimulationEngine (MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions) {
        this.map = map;
        this.moves = moves;
        for (int i = 0; i < initialPositions.length; i++) {
            Animal animal = new Animal(map, initialPositions[i]);
            if(map.place(animal))
                animals.add(animal);
        }
    }

    @Override
    public void run() {
        int n = animals.size();
        for (int i = 0; i < moves.length; i++) {
            animals.get(i % n).move(moves[i]);
        }
    }
}
