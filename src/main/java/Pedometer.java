import java.util.Map;

public class Pedometer {
    private Map<Integer, Integer> steps;

    public Pedometer(Map<Integer, Integer> steps) {
        this.steps = steps;
    }

    public int add(int day, int step) {
        int sumStep;
        int maxStep;
        int max = 0;                                           //ДОБАВЛЯЕМ ШАГИ
        if (step <= 0 || steps.size() > Math.abs(day)) {      //если значение шагов отрицательное или день - прошедший
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
}
