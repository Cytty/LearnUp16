import java.util.Comparator;

public class PedometerDayComparator implements Comparator<Pedometer> {
    private int stepsMin;


    public PedometerDayComparator(int stepsMin) {
        this.stepsMin = stepsMin;
    }

    @Override
    public int compare(Pedometer pedometer1, Pedometer pedometer2) {
        if (pedometer1.sumDay(stepsMin) > pedometer2.sumDay(stepsMin)) {
            return 1;
        } else {
            if (pedometer1.sumDay(stepsMin) > pedometer2.sumDay(stepsMin)) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

