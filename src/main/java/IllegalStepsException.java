public class IllegalStepsException extends RuntimeException {

    public IllegalStepsException(int step) {
        super("Вы пытаетесь записать отрицательное значение шагов: " + step);
    }
}
