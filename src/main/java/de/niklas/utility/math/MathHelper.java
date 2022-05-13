package de.niklas.utility.math;

import de.niklas.utility.misc.Pair;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public double getGCD(double a, double b) {
        if (b == 0) return a;

        return getGCD(b, a % b);
    }

    public double getGCDIterative(double a, double b) {
        while (b != 0) {
            double h = a % b;
            a = b;
            b = h;
        }

        return a;
    }

    public List<Number> getOutliers(Collection<Number> list) {
        double avg = getAvg(list);
        return removeOutliers(list, avg / 2, avg);
    }

    public List<Number> removeOutliers(Collection<Number> list, double flag) {
        return removeOutliers(list, flag, getAvg(list));
    }

    public List<Number> removeOutliers(Collection<Number> list, double flag, double avg) {
        List<Number> outliers = new ArrayList<>();

        for (Number n : list) {
            double d = getDelta(avg, n.doubleValue());
            if (d > flag) outliers.add(n);
        }

        return outliers;
    }
}
