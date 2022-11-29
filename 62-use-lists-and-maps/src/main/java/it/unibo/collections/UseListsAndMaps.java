package it.unibo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> arrayList = new ArrayList<>();
        final int MAX_POPULATION = 1000;
        for (int i = 0; i < MAX_POPULATION; i++) {
            arrayList.add(i + 1000);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int last = arrayList.get(arrayList.size() - 1);
        arrayList.set(arrayList.size() - 1, arrayList.get(0));
        arrayList.set(0, last);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.println(arrayList);
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = 0;
        final int NEW_ELEMENTS = 100_000;
        
        test1(time, NEW_ELEMENTS, arrayList);

        test1(time, NEW_ELEMENTS, linkedList);

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        final int READS = 1000;
        
        test2(time, READS, arrayList);

        test2(time, READS, linkedList);
        
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
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
        /*
         * 8) Compute the population of the world
         */
        Map<String,Double> map = new HashMap<>();
        map.put("Africa", 1_110_635_000D);
        map.put("Americas", 972_005_000D);
        map.put("Antartica", 0D);
        map.put("Asia", 4_298_723_000D);
        map.put("Europe", 742_452_000D);
        map.put("Oceania", 38_304_000D);
        map.put("World", map.get("Africa")+map.get("Americas")+map.get("Antartica")+map.get("Asia")+map.get("Europe")+map.get("Oceania"));

        System.out.println(map);
    }
    public static long prepareVariable() {
        long time = System.nanoTime();
        return time;
    }
    public static void computeAndResolve(long time, List<Integer> set) {
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + set.size()
                + " ints to String and inserting them in a Set took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }
    public static void test1 (long time,int index, List<Integer> col) {
        time = prepareVariable();
        for (int i = 0; i < index; i++) {
            col.add(0, i);
        }
        computeAndResolve(time, col);
    }
    public static void test2 (long time, int index, List<Integer> col) {
        time = prepareVariable();
        for (int i = 0; i < index; i++) {
            col.get(col.size() / 2);
        }
        computeAndResolve(time, col);
    }
}
