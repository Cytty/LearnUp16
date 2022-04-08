import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void Zero() {
        HashMap<Integer, Integer> steps = new HashMap<>();
        Pedometer pedometer = new Pedometer(steps);
        pedometer.add(1, 2_100);
        pedometer.add(2, 10_001);
        pedometer.add(3, 700);
        pedometer.add(5, 10_200);
        pedometer.add(6, 7_159);
        pedometer.add(7, 9_999);
        pedometer.add(8, 6_257);
        pedometer.add(9, 16_851);
        pedometer.add(10, 11_967);
        pedometer.add(11, 10_000);
        pedometer.add(12, 1_573);
        pedometer.add(13, 2_854);
        pedometer.add(14, 12_861);
        pedometer.add(15, 100);

        int minStep = 10_000;

        Map<Integer, Integer> stepsExpected = new HashMap<>();
        stepsExpected.put(2, 10_001);
        stepsExpected.put(5, 10_200);
        stepsExpected.put(9, 16_851);
        stepsExpected.put(10, 11_967);
        stepsExpected.put(14, 12_861);

        Map<Integer, Integer> stepsActual = pedometer.printAllDaysByCriteria(step -> step > minStep);

        Assertions.assertEquals(stepsExpected, stepsActual);
    }

}
