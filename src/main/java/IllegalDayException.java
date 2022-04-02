public class IllegalDayException extends RuntimeException {

    public IllegalDayException(int day) {
        super("День должен существовать, а этого дня нет: " + day);
    }
}
