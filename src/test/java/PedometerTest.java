import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class PedometerTest {

    @Test
    public void negativeVal() {
        HashMap<Integer, Integer> steps = new HashMap<>();
        Pedometer pedometer = new Pedometer(steps);
        pedometer.add(1, 2_000);
        pedometer.add(1, 1_500);
        pedometer.add(2, -1_400);
        pedometer.add(2, -1_000);
        pedometer.add(2, 2_400);
        pedometer.add(2, 2_000);
        pedometer.add(2, 600);
        pedometer.add(2, 200);
        pedometer.add(2, 900);
        pedometer.add(2, 500);
        pedometer.add(2, 300);
        pedometer.add(3, 900);
        pedometer.add(3, 1400);
        pedometer.add(4, 2_000);

        int expected = 3_901;
        int actual = pedometer.add(5, 3000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void todayBestDay() {
        HashMap<Integer, Integer> steps = new HashMap<>();
        Pedometer pedometer = new Pedometer(steps);
        pedometer.add(1, 2_000);
        pedometer.add(1, 1_200);
        pedometer.add(2, -1_400);
        pedometer.add(2, -1_000);
        pedometer.add(2, 2_400);
        pedometer.add(2, 2_000);

        int expected = 1;
        int actual = pedometer.add(2, 300);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lastDay() {
        HashMap<Integer, Integer> steps = new HashMap<>();
        Pedometer pedometer = new Pedometer(steps);
        pedometer.add(1, 2_000);
        pedometer.add(1, 1_500);
        pedometer.add(2, -1_400);
        pedometer.add(2, -1_000);
        pedometer.add(2, 2_400);
        pedometer.add(2, 2_000);
        pedometer.add(2, 600);
        pedometer.add(2, 200);
        pedometer.add(2, 900);
        pedometer.add(2, 500);
        pedometer.add(2, 300);
        pedometer.add(3, 900);
        pedometer.add(3, 1400);
        pedometer.add(4, 2_000);

        int expected = -1;
        int actual = pedometer.add(2, 300);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativeDay() {
        HashMap<Integer, Integer> steps = new HashMap<>();
        Pedometer pedometer = new Pedometer(steps);
        pedometer.add(1, 2_000);
        pedometer.add(1, 1_500);
        pedometer.add(2, -1_400);
        pedometer.add(2, -1_000);
        pedometer.add(2, 2_400);
        pedometer.add(2, 2_000);
        pedometer.add(2, 600);
        pedometer.add(2, 200);
        pedometer.add(2, 900);
        pedometer.add(2, 500);
        pedometer.add(2, 300);
        pedometer.add(3, 900);
        pedometer.add(3, 1400);
        pedometer.add(4, 2_000);

        int expected = 3_901;
        int actual = pedometer.add(-5, 3000);

        Assertions.assertEquals(expected, actual);
    }
}
