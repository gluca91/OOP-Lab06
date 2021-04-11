package it.unibo.oop.lab.collections1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private static int nanotime;
    private static long result;
    private static TreeSet<Pair<Integer, String>> set;
    private static TreeSet<Pair<Integer, CountMe>> tmpSet;

    private UseCollection() {
    }

    /**
     * @param s unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers from
         * 1000 (included) to 2000 (excluded).
         */
        final var list = new ArrayList<Integer>();
        Stream.iterate(1000, i -> i + 1).limit(1000).forEach(i -> list.add(i));
        System.out.println(list);
        System.out.println();
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code without
         * using any looping construct (for, while), populate it with the same contents
         * of the list of point 1.
         */
        final var list2 = new LinkedList<>(list);
        System.out.println(list);
        System.out.println(list2);
        System.out.println();
//        list.forEach(i -> list2.add(i));
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last element
         * of the first list. You can not use any "magic number". (Suggestion: use a
         * temporary variable)
         */
        var tmp = new LinkedList<>(list);
        tmp.remove(list2.getFirst());
        tmp.remove(list2.getLast());
        tmp.addFirst(list2.getLast());
        tmp.addLast(list2.getFirst());
        list.clear();
        list.addAll(tmp);

        System.out.println(list);
        System.out.println(list2);
        System.out.println();

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        list.forEach(i -> System.out.print(i + "/"));
        System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of the
         * collection: measure the time required to add 100.000 elements as first
         * element of the collection for both ArrayList and LinkedList, using the
         * previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        Stream.iterate(0, i -> i + 1).limit(100_000).forEach(i -> list.add(0, i));
        time = System.nanoTime() - time;
        System.out.println("ArrayList: " + time / 1_000_000);

        time = System.nanoTime();
        Stream.iterate(0, i -> i + 1).limit(100_000).forEach(i -> list2.addFirst(i));
        time = System.nanoTime() - time;
        System.out.println("LinkedList: " + time / 1_000_000);
        /*
         * 6) Measure the performance of reading 1000 times an element whose position is
         * in the middle of the collection for both ArrayList and LinkedList, using the
         * collections of point 5. In order to measure times, use as example
         * TestPerformance.java.
         */
        System.out.println("ArrayList:");
        time = System.nanoTime();
        Stream.iterate(((int) list.size() / 2), i -> i + 1).limit(1000).forEach(i -> System.out.print(list.get(i)));
        time = System.nanoTime() - time;
        System.out.println();
        System.out.println("ArrayList: " + time / 1_000_000);

        System.out.println("LinkedList:");
        time = System.nanoTime();
        Stream.iterate(((int) list2.size() / 2), i -> i + 1).limit(1000).forEach(i -> System.out.print(list2.get(i)));
        time = System.nanoTime() - time;
        System.out.println();
        System.out.println("LinkedList: " + time / 1_000_000);
        /*
         * 7) Build a new Map that associates to each continent's name its population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        final var map = new HashMap<String, Long>();
        map.put("Africa", 1_110_635_000L);
        map.put("America", 972_005_000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
//        System.out.println(map.values().stream().mapToLong(Long::longValue).sum());
//        System.out.println(map.values().stream().reduce((i, j) -> i = i + j).get());
//        System.out.println(map.values().stream().reduce(0L, (i, j) -> i + j));
//        System.out.println(map.values().stream().reduce(0L, Long::sum));
//        System.out.println(map.values().stream().collect(Collectors.summingLong(Long::longValue)));

        final var a = new CountMe("A");
        final var b = new CountMe("B");
        final var c = new CountMe("C");
        final var d = new CountMe("D");
        final var e = new CountMe("E");

        final var countList = new ArrayList<CountMe>();
        countList.add(a);
        countList.add(b);
        countList.add(c);
        countList.add(d);
        countList.add(e);
        System.out.println();
        var ora = LocalTime.now();
        System.out.println(ora.getMinute() + " -- " + ora.getSecond());
        System.out.println();
        Stream.iterate(0, k -> k + 1).limit(1000).forEach(k -> {

            set = new TreeSet<Pair<Integer, String>>(new MyPairCompare());

            tmpSet = new TreeSet<Pair<Integer, CountMe>>((i, j) -> i.getFirst() - j.getFirst());
            
            // D, C, B, A, E
//            exec(e, () -> result = map.values().stream().collect(Collectors.summingLong(Long::longValue)));
//            exec(a, () -> result = map.values().stream().mapToLong(Long::longValue).sum());
//            exec(c, () -> result = map.values().stream().reduce(0L, (i, j) -> i + j));
//            exec(d, () -> result = map.values().stream().reduce(0L, Long::sum));
//            exec(b, () -> result = map.values().stream().reduce((i, j) -> i = i + j).get());

            
//            exec(e, () -> result = map.values().stream().collect(Collectors.summingLong(Long::longValue)));
//            exec(a, () -> result = map.values().stream().mapToLong(Long::longValue).sum());
//            exec(b, () -> result = map.values().stream().reduce((i, j) -> i = i + j).get());
//            exec(c, () -> result = map.values().stream().reduce(0L, (i, j) -> i + j));
//            exec(d, () -> result = map.values().stream().reduce(0L, Long::sum));

            
//            exec(c, () -> result = map.values().stream().reduce(0L, (i, j) -> i + j));
//            exec(d, () -> result = map.values().stream().reduce(0L, Long::sum));
//            exec(b, () -> result = map.values().stream().reduce((i, j) -> i = i + j).get());
//            exec(a, () -> result = map.values().stream().mapToLong(Long::longValue).sum());
//            exec(e, () -> result = map.values().stream().collect(Collectors.summingLong(Long::longValue)));

            
            exec(d, () -> result = map.values().stream().reduce(0L, Long::sum));
            exec(c, () -> result = map.values().stream().reduce(0L, (i, j) -> i + j));
            exec(b, () -> result = map.values().stream().reduce((i, j) -> i = i + j).get());
            exec(e, () -> result = map.values().stream().collect(Collectors.summingLong(Long::longValue)));
            exec(a, () -> result = map.values().stream().mapToLong(Long::longValue).sum());

            // D, C, B, E, A
//            exec(a, () -> result = map.values().stream().mapToLong(Long::longValue).sum());
//            exec(b, () -> result = map.values().stream().reduce((i, j) -> i = i + j).get());
//            exec(c, () -> result = map.values().stream().reduce(0L, (i, j) -> i + j));
//            exec(d, () -> result = map.values().stream().reduce(0L, Long::sum));
//            exec(e, () -> result = map.values().stream().collect(Collectors.summingLong(Long::longValue)));

            final var arr = new ArrayList<>(tmpSet);
            Stream.iterate(0, i -> i + 1).limit(arr.size())
                    .forEachOrdered(i -> countList.get(countList.indexOf(arr.get(i).getSecond())).addOne(i));

//            set.forEach(i -> System.out.print(i.getSecond()));
//            System.out.println();

            try {
                Thread.sleep(100);
            } catch (InterruptedException z) {
                // TODO Auto-generated catch block
                z.printStackTrace();
            }

        });

        ora = LocalTime.now();
        System.out.println();
        System.out.println(ora.getMinute() + " -- " + ora.getSecond());
        System.out.println();
        countList.forEach(i -> System.out.println(i.toString()));

    }

    private static void exec(CountMe obj, final Runnable toRun) {
        nanotime = (int) (System.nanoTime());
        toRun.run();
        nanotime = (int) (System.nanoTime()) - nanotime;
//        txt = txt + ": " + result + " / " + nanotime;
        final String txt = obj.getName() + "/" + nanotime + "\t";
        set.add(new Pair<Integer, String>(nanotime, txt));
        tmpSet.add(new Pair<Integer, CountMe>(nanotime, obj));
    }
}
