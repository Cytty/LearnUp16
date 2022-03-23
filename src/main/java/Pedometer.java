import java.util.Map;

public class Pedometer {
    private Map<Integer, Integer> steps;

    public Pedometer(Map<Integer, Integer> steps) {
        this.steps = steps;
    }

    public int add(int day, int step) {
        int sumStep;
        if (step <= 0) {
            sumStep = steps.getOrDefault(day, 0);
        } else {
            sumStep = steps.getOrDefault(day, 0) + step;
        }
        steps.put(day, sumStep);

        int max = 0;
        int maxSteps = 0;
        for (int title : steps.keySet()) {
            if (steps.get(title) > max) {
                max = steps.get(title);
            }
        }
        for (int title : steps.keySet()) {
            if (!steps.containsKey(day + 1)) {
                maxSteps = max - steps.get(title) + 1;
            } else {
                continue;
            }
        }
        return maxSteps;
    }
}
