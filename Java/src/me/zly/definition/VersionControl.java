package me.zly.definition;

import java.util.Random;

/**
 * Implementation the isBadVersion API @_278.FirstBadVersion
 */

public class VersionControl {

    int n;

    int version;

    public VersionControl(int n) {
        this.n = n;
        this.version = new Random().nextInt() % n;
    }

    public boolean isBadVersion(int version) {

        if (version < this.version) return false;
        else return true;

    }

}