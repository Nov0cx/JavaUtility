package de.niklas.utility.math;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class Vector implements Cloneable {

    @Getter
    @Setter
    private double x, y, z;

    public Vector(Vector other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
    }

    public Vector multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    public Vector multiply(double x, double y, double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public Vector multiply(Vector m) {
        x *= m.x;
        y *= m.y;
        z *= m.z;
        return this;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector getMidPoint(Vector other) {
        return new Vector(((x + other.x)/2), ((y + other.y)/2), ((z + other.z)/2));
    }

    public Vector normalize() {
        double length = getLength();
        return this.multiply(1/length);
    }

    public double distance(Vector other) {
        double dx = Math.abs(x - other.x);
        double dy = Math.abs(y - other.y);
        double dz = Math.abs(z - other.z);

        return dx + dy + dz;
    }

    @Override
    public Vector clone() {
        return new Vector(x, y, z);
    }
}
