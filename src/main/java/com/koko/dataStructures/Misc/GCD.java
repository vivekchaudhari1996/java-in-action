package com.koko.dataStructures.Misc;

public class GCD {

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
