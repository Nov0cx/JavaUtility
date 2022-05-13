package de.niklas.utility.boundingboxes;

import de.niklas.utility.math.Vector;

public interface BoundingBox {
    boolean collides(BoundingBox other);
    boolean collides(Vector other);

    double distance(BoundingBox other);
    double distance(Vector other);

    Vector getMidPoint();

    BoundingBox move(double x, double y, double z);
    BoundingBox grow(double x, double y, double z);
    BoundingBox shrink(double x, double y, double z);

    Vector getMin();
    Vector getMax();
}
