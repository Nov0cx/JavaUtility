package de.niklas.utility.boundingboxes;

import de.niklas.utility.math.Vector;
import de.niklas.utility.misc.Cloneable;
import de.niklas.utility.misc.Pair;
import lombok.NonNull;

public class CircleBox2D implements BoundingBox, Cloneable<CircleBox2D> {

    private final CubeBox cubeBox;

    public CircleBox2D(@NonNull Vector center, double radius) {
        cubeBox = new CubeBox(center.getX() - radius, center.getY() - radius, 0, center.getX() + radius, center.getY() + radius, 0);
    }

    public CircleBox2D(@NonNull CubeBox box) {
        cubeBox = box;
    }

    @Override
    public boolean collides(BoundingBox other) {
        return cubeBox.collides(other);
    }

    @Override
    public boolean collides(Vector other) {
        return cubeBox.collides(other);
    }

    @Override
    public double distance(BoundingBox other) {
        return cubeBox.distance(other);
    }

    @Override
    public double distance(Vector other) {
        return cubeBox.distance(other);
    }

    @Override
    public Vector getMidPoint() {
        return cubeBox.getMidPoint();
    }

    @Override
    public BoundingBox move(double x, double y, double z) {
        return new CircleBox2D((CubeBox)cubeBox.move(x, y, z));
    }

    @Override
    public BoundingBox grow(double x, double y, double z) {
        return new CircleBox2D((CubeBox)cubeBox.grow(x, y, z));
    }

    @Override
    public BoundingBox shrink(double x, double y, double z) {
        return new CircleBox2D((CubeBox)cubeBox.shrink(x, y, z));
    }

    @Override
    public Vector getMin() {
        return cubeBox.getMin();
    }

    @Override
    public Vector getMax() {
        return cubeBox.getMax();
    }

    @Override
    public CircleBox2D clone() {
        return new CircleBox2D(cubeBox);
    }
}
