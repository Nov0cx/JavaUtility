package de.niklas.utility.misc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<A, B> implements Cloneable<Pair<A, B>> {
    private A a;
    private B b;

    public void setAB(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Pair<A, B> clone() {
        return new Pair<>(a, b);
    }
}
