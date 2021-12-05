package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse (String[] commands) throws IllegalArgumentException {
        int len = commands.length;
        MoveDirection[] directions = new MoveDirection[len];
        for (int i = 0; i < len; i++) {
            if (commands[i].equals("f") || commands[i].equals("forward"))
                directions[i] = MoveDirection.FORWARD;
            else if (commands[i].equals("b") || commands[i].equals("backward"))
                directions[i] = MoveDirection.BACKWARD;
            else if (commands[i].equals("l") || commands[i].equals("left"))
                directions[i] = MoveDirection.LEFT;
            else if (commands[i].equals("r") || commands[i].equals("right"))
                directions[i] = MoveDirection.RIGHT;
            else
                throw new IllegalArgumentException(commands[i] + " is not legal move specification");

        }
        return directions;
    }
}
