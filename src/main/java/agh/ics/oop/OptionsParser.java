package agh.ics.oop;

import javax.management.openmbean.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;

public class OptionsParser {

    public static MoveDirection[] parse (String[] commands) {
        int len = commands.length;
        MoveDirection directions[] = new MoveDirection[len];
        int i = 0, j = 0;
        for (; i < len; i++) {
            if (commands[i].equals("f") || commands[i].equals("forward"))
                directions[j] = MoveDirection.FORWARD;
            else if (commands[i].equals("b") || commands[i].equals("backward"))
                directions[j] = MoveDirection.BACKWARD;
            else if (commands[i].equals("l") || commands[i].equals("left"))
                directions[j] = MoveDirection.LEFT;
            else if (commands[i].equals("r") || commands[i].equals("right"))
                directions[j] = MoveDirection.RIGHT;
            else
                j--;
            j++;
        }
        return Arrays.copyOfRange(directions, 0, j);
    }
}
