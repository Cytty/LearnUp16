public class IllegalDayOldException extends RuntimeException {

    public IllegalDayOldException(int day, int step) {
        super("Вы пытаетесь записать уже прошедший день или отрицательное значение дня: " + day);
    }
}
