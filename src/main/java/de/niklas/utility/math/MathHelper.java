package de.niklas.utility.math;

import de.niklas.utility.misc.Pair;
import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class MathHelper {

    public double getAvg(Collection<Number> list) {
        double sum = 0;

        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum / list.size();
    }

    public double getDelta(double a, double b) {
        return Math.abs(a - b);
    }

    public double getNearestNumberToAvg(Collection<Number> list) {
        double avg = getAvg(list);
        Pair<Double, Number> nearest = new Pair<>(0., Integer.MAX_VALUE);

        for (Number number : list) {
            double dist = getDelta(number.doubleValue(), avg);
            if (dist < nearest.getA()) {
                nearest.setAB(dist, number);
            }
        }

        return nearest.getB().doubleValue();
    }


}
