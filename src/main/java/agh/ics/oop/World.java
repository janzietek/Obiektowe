package agh.ics.oop;

import java.util.Arrays;

public class World {

    public static void run (String[] args) {

//        System.out.println("Forward");
//        for(int i = 0; i < args.length - 1; i++) {
//            System.out.print(args[i] + ", ");
//        }
//        System.out.println(args[args.length - 1]);

        for(String arg : args){
            switch(arg){
                case "f":
                    System.out.println("Forward");
                    break;
                case "b":
                    System.out.println("Backward");
                    break;
                case "l":
                    System.out.println("Left");
                    break;
                case "r":
                    System.out.println("Right");
                    break;
                default:
                    break;
            }
        }
    }

    public static void run2 (Direction[] args) {
        for (Direction arg : args) {
            switch(arg){
                case FORWARD:
                    System.out.println("Forward");
                    break;
                case BACKWARD:
                    System.out.println("Backward");
                    break;
                case LEFT:
                    System.out.println("Left");
                    break;
                case RIGHT:
                    System.out.println("Right");
                    break;
            }
        }
    }

    public static Direction[] stringToEnum (String[] args) {
        Direction[] dire = new Direction[args.length];
        int i = 0, j = 0;

        while (j < args.length) {
            switch (args[i]) {
                case "f":
                    dire[i] = Direction.FORWARD;
                    break;
                case "b":
                    dire[i] = Direction.BACKWARD;
                    break;
                case "l":
                    dire[i] = Direction.LEFT;
                    break;
                case "r":
                    dire[i] = Direction.RIGHT;
                    break;
                default:
                    i--;
                    continue;
            }
            i++;
            j++;
        }
        return Arrays.copyOfRange(dire, 0, i);
    }



    public static void main(String[] args) {
        System.out.println("Start");

//        String[] commands = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
//        MoveDirection[] directions = new OptionsParser().parse(commands);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        System.out.println(map.toString());
//        engine.run();
//        System.out.println(map.toString());


        String[] commands = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(commands);
        IWorldMap map = new GrassField(1);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map.toString());
        engine.run();
        System.out.println(map.toString());


        System.out.println("Stop");
    }
}