package it.unibo.oop.lab.collections1;

import java.util.Comparator;

public class MyPairCompare implements Comparator<Pair<Integer, String>> {

    @Override
    public int compare(Pair<Integer, String> o1, Pair<Integer, String> o2) {
        return o1.getFirst() - o2.getFirst();
    }

}
