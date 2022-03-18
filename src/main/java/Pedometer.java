import java.util.HashMap;
import java.util.Map;

public class Pedometer {
    private Map<Integer, Integer> steps;

    public Pedometer(Map<Integer, Integer> steps) {
        this.steps = steps;
    }

    public void add(Integer day, Integer step) {                           // добавляет шаги в менеджер
       int sumStep;
        if (step <= 0){
            sumStep = steps.getOrDefault(day, 0);
           } else {
            sumStep = steps.getOrDefault(day, 0) + step;
        }
            steps.put(day, sumStep);
    }

    public int betterDay(HashMap<Integer, Integer> steps) {                // считает количество необходимых шагов для рекорда
        int max = 0;
        for (int day : steps.keySet()) {
            if (steps.get(day) > max) {
                max = steps.get(day);
            }
        }
        int maxSteps = max + 1;
        return maxSteps;
    }
}
