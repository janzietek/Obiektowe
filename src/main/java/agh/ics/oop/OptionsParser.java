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
            if (commands[i] == "f" || commands[i] == "forward")
                directions[j] = MoveDirection.FORWARD;
            else if (commands[i] == "b" || commands[i] == "backward")
                directions[j] = MoveDirection.BACKWARD;
            else if (commands[i] == "l" || commands[i] == "left")
                directions[j] = MoveDirection.LEFT;
            else if (commands[i] == "r" || commands[i] == "right")
                directions[j] = MoveDirection.RIGHT;
            else
                j--;
            j++;
        }
        return Arrays.copyOfRange(directions, 0, j);
    }
}
