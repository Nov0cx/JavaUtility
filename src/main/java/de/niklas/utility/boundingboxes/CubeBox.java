package de.niklas.utility.boundingboxes;

import de.niklas.utility.math.Vector;
import de.niklas.utility.misc.Cloneable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CubeBox implements BoundingBox, Cloneable<CubeBox> {

    private double minX, minY, minZ, maxX, maxY, maxZ;

    public CubeBox(Vector position, double size) {
        this(position.getX() - size / 2, position.getY() - size / 2, position.getZ() - size / 2,
                position.getX()  + size / 2, position.getY() + size / 2, position.getZ() + size / 2);
    }

    @Override
    public boolean collides(BoundingBox other) {
        if (other instanceof CubeBox) {
            CubeBox otherBox = (CubeBox) other;
            return otherBox.maxX >= this.minX && otherBox.minX <= this.maxX && otherBox.maxY >= this.minY
                    && otherBox.minY <= this.maxY && otherBox.maxZ >= this.minZ && otherBox.minZ <= this.maxZ;
        }
        return false;
    }

    @Override
    public boolean collides(Vector other) {
        return other.getX() >= minX && other.getX() <= maxX && other.getY() >= minY && other.getY() <= maxY && other.getZ() >= minZ && other.getZ() <= maxZ;
    }

    @Override
    public double distance(BoundingBox other) {
        if (other instanceof CubeBox) {
            double xwidth = (maxX - minX) / 2, zwidth = (maxZ - minZ) / 2;
            double bxwidth = (((CubeBox) other).maxX - ((CubeBox) other).minX) / 2, bzwidth = (((CubeBox) other).maxZ - ((CubeBox) other).minZ) / 2;
            double hxz = Math.hypot(minX - ((CubeBox) other).minX, minZ - ((CubeBox) other).minZ);

            return hxz - (xwidth + zwidth + bxwidth + bzwidth) / 4;
        }
        return 0;
    }

    @Override
    public double distance(Vector other) {
        double d1 = getMin().distance(other);
        double d2 = getMax().distance(other);
        return Math.min(d1, d2);
    }

    @Override
    public Vector getMidPoint() {
        Vector min = getMin();
        Vector max = getMax();

        return min.getMidPoint(max);
    }

    @Override
    public BoundingBox move(double x, double y, double z) {
        this.minX += x;
        this.minY += y;
        this.minZ += z;
        this.maxX += x;
        this.maxY += y;
        this.maxZ += z;
        return this;
    }

    @Override
    public BoundingBox grow(double x, double y, double z) {
        this.minX -= x;
        this.minY -= y;
        this.minZ -= z;
        this.maxX += x;
        this.maxY += y;
        this.maxZ += z;
        return this;
    }

    @Override
    public BoundingBox shrink(double x, double y, double z) {
        return grow(-x, -y, -z);
    }

    @Override
    public Vector getMin() {
        return new Vector(minX, minY, minZ);
    }

    @Override
    public Vector getMax() {
        return new Vector(maxX, maxY, maxZ);
    }

    @Override
    public CubeBox clone() {
        return new CubeBox(minX, minY, minZ, maxX, maxY, maxZ);
    }
}
