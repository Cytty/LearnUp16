import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class PedometerCompTest {

    @Test
    public void compareToResponseOneAndNegative() {
        HashMap<Integer, Integer> steps1 = new HashMap<>();
        Pedometer pedometer1 = new Pedometer(steps1);
        pedometer1.add(1, 2_000);
        pedometer1.add(2, -1_400);
        pedometer1.add(3, 1_400);
        pedometer1.add(4, 2_000);

        HashMap<Integer, Integer> steps2 = new HashMap<>();
        Pedometer pedometer2 = new Pedometer(steps2);
        pedometer2.add(1, 1_500);
        pedometer2.add(2, 500);
        pedometer2.add(3, 900);
        pedometer2.add(4, 2_000);


        int actual = pedometer1.compareTo(pedometer2);

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void compareToResponseMinus1() {
        HashMap<Integer, Integer> steps1 = new HashMap<>();
        Pedometer pedometer1 = new Pedometer(steps1);
        pedometer1.add(1, 2_000);
        pedometer1.add(2, -1_400);
        pedometer1.add(3, -1_400);
        pedometer1.add(4, 2_000);

        HashMap<Integer, Integer> steps2 = new HashMap<>();
        Pedometer pedometer2 = new Pedometer(steps2);
        pedometer2.add(1, 1_500);
        pedometer2.add(2, 500);
        pedometer2.add(3, 900);
        pedometer2.add(4, 2_000);

        int actual = pedometer1.compareTo(pedometer2);

        Assertions.assertEquals(-1, actual);
    }

    @Test
    public void compareToResponseZero() {
        HashMap<Integer, Integer> steps1 = new HashMap<>();
        Pedometer pedometer1 = new Pedometer(steps1);
        pedometer1.add(1, 2_100);
        pedometer1.add(2, 900);
        pedometer1.add(3, 700);
        pedometer1.add(4, 1_200);

        HashMap<Integer, Integer> steps2 = new HashMap<>();
        Pedometer pedometer2 = new Pedometer(steps2);
        pedometer2.add(1, 1_500);
        pedometer2.add(2, 500);
        pedometer2.add(3, 900);
        pedometer2.add(4, 2_000);

        int actual = pedometer1.compareTo(pedometer2);

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void comparatorResponseOneAndNegative() {
        HashMap<Integer, Integer> steps1 = new HashMap<>();
        Pedometer pedometer1 = new Pedometer(steps1);
        pedometer1.add(1, 2_000);
        pedometer1.add(2, -1_400);
        pedometer1.add(3, 1_400);
        pedometer1.add(4, 2_000);

        HashMap<Integer, Integer> steps2 = new HashMap<>();
        Pedometer pedometer2 = new Pedometer(steps2);
        pedometer2.add(1, 1_500);
        pedometer2.add(2, 500);
        pedometer2.add(3, 900);
        pedometer2.add(4, 2_000);


        PedometerDayComparator comparator = new PedometerDayComparator(900);

        int actual = comparator.compare(pedometer1, pedometer2);

        Assertions.assertEquals(1, actual);
    }

    @Test
    public void comparatorResponseMinus1() {
        HashMap<Integer, Integer> steps1 = new HashMap<>();
        Pedometer pedometer1 = new Pedometer(steps1);
        pedometer1.add(1, 2_000);
        pedometer1.add(2, -1_400);
        pedometer1.add(3, -1_400);
        pedometer1.add(4, 2_000);

        HashMap<Integer, Integer> steps2 = new HashMap<>();
        Pedometer pedometer2 = new Pedometer(steps2);
        pedometer2.add(1, 1_500);
        pedometer2.add(2, 500);
        pedometer2.add(3, 901);
        pedometer2.add(4, 2_000);

        PedometerDayComparator comparator = new PedometerDayComparator(900);

        int actual = comparator.compare(pedometer1, pedometer2);

        Assertions.assertEquals(-1, actual);
    }

    @Test
    public void comparatorResponseZero() {
        HashMap<Integer, Integer> steps1 = new HashMap<>();
        Pedometer pedometer1 = new Pedometer(steps1);
        pedometer1.add(1, 2_100);
        pedometer1.add(2, 901);
        pedometer1.add(3, 700);
        pedometer1.add(4, 1_200);

        HashMap<Integer, Integer> steps2 = new HashMap<>();
        Pedometer pedometer2 = new Pedometer(steps2);
        pedometer2.add(1, 1_500);
        pedometer2.add(2, 1_900);
        pedometer2.add(3, 900);
        pedometer2.add(4, 2_000);

        PedometerDayComparator comparator = new PedometerDayComparator(900);

        int actual = comparator.compare(pedometer1, pedometer2);

        Assertions.assertEquals(0, actual);
    }

}
