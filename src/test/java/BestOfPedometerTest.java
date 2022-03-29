import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BestOfPedometerTest {

    @Test
    public void number1() {
        HashMap<Integer, Integer> steps = new HashMap<>();
        Pedometer p1 = new Pedometer(steps);
        p1.add(1, 2_000);
        p1.add(1, 1_500);
        p1.add(2, -1_400);
        p1.add(2, -1_000);
        p1.add(2, 2_400);
        p1.add(2, 2_000);
        p1.add(2, 600);
        p1.add(2, 200);
        p1.add(2, 900);
        p1.add(2, 500);
        p1.add(2, 300);
        p1.add(3, 900);
        p1.add(3, 1_400);
        p1.add(4, 2_000);

        Pedometer p2 = new Pedometer(steps);
        p2.add(1, 2_000);
        p2.add(1, 2_500);
        p2.add(2, 1_400);
        p2.add(2, 1_000);
        p2.add(2, 1_400);
        p2.add(2, 1_000);
        p2.add(2, 300);
        p2.add(2, 1_200);
        p2.add(2, 800);
        p2.add(2, 500);
        p2.add(2, 800);
        p2.add(3, 400);
        p2.add(3, 400);
        p2.add(4, 3_000);

        int expected = -1;
        int actual = p1.compareTo(p2);


    }
}
