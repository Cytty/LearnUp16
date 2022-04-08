import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Pedometer implements Comparable<Pedometer> {
    private Map<Integer, Integer> steps;

    public Pedometer(Map<Integer, Integer> steps) {
        this.steps = steps;
    }

    public Map<Integer, Integer> getSteps() {
        return steps;
    }

    public int add(int day, int step) {
        int sumStep;
        int maxStep;
        int max = 0;                                           //ДОБАВЛЯЕМ ШАГИ
        if (step <= 0 || steps.size() > Math.abs(day)) {       //если значение шагов отрицательное или день - прошедший
            sumStep = steps.getOrDefault(day, 0);    //оставить сумму шагов дня без изменений
        } else {
            sumStep = steps.getOrDefault(Math.abs(day), 0) + step; //иначе  добавь шаги к имеющемся в этом дне
        }

        steps.put(day, sumStep);                                //ИЩЕМ ЛУЧШИЙ ДЕНЬ
        if (steps.size() > Math.abs(day)) {                     //если добавляемый день уже прошел
            maxStep = -1;                                       // вернуть "-1"
        } else {
            for (int title : steps.keySet()) {                    //каждое значение в мапе
                if (steps.get(title) > max) {                     //сравниваем с максимумом, и если значение дня больше,
                    max = steps.get(title);                       //то теперь это значение является максимумом
                }
            }                                                    //РАСЧИТЫВАЕМ СКОЛЬКО ШАГОВ ОСТАЛОСЬ ДО ПОБИТИЯ РЕКОРДА
            maxStep = max - steps.get(day) + 1;                  //вычитаем из максимума пройденные шаги и прибавляем 1
        }
        return maxStep;
    }

    public int sumSteps() {                               //СЧИТАЕТ СУММУ ВСЕХ ШАГОВ В ШАГОМЕРЕ
        int sum = 0;
        for (int title : steps.keySet()) {               //проходим по всем значениям ключей в мапе
            sum += steps.get(title);                     //суммируем уже суммированное со следующим значением ключа
        }
        return sum;
    }

    public int sumDay(int minStep) {                     //СЧИТАЕТ КОЛ-ВО ДНЕЙ, ГДЕ ШАГОВ БОЛЬШЕ МИНИМУМА
        int countDay = 0;
        for (int title : getSteps().keySet()) {         //проходим по всем значениям ключей в мапе
            if (getSteps().get(title) > minStep) {      //фильтруем и считаем дни
                countDay++;
            }
        }
        return countDay;
    }

    @Override
    public int compareTo(Pedometer pedometer) {                  //сравниваемся с приёмышем
        if (sumSteps() > pedometer.sumSteps()) {
            return 1;
        } else {
            if (sumSteps() < pedometer.sumSteps()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public Map<Integer, Integer> printAllDaysByCriteria(Predicate<Integer> criteria) {
        HashMap<Integer, Integer> stepsTrue = new HashMap<>();
        for (int title : steps.keySet()) {
            if (criteria.test(steps.get(title))) {
                stepsTrue.put(title, steps.get(title));
                System.out.println("день " + title + " шагов " + steps.get(title));  //выводит на экран содержимое шагомера//тестирует критерий предикейта (из теста)
            }
        }
        return stepsTrue;

    }
}