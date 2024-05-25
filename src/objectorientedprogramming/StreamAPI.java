package objectorientedprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        // List<Integer> list = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /*
         * A stream can be used only once.
         streamList.forEach(n -> System.out.println(n));
         streamList.forEach(n -> System.out.println(n));

         * In the above case, the first one will print all the values in the list.
         * Whereas the second one will throw an exception saying "Stream is already used / closed".
         */

        Stream<Integer> streamList1 = list.stream();
        Stream<Integer> filtered = streamList1.filter(n -> n%2 == 0);
        Stream<Integer> mapped = filtered.map(n -> n*2);
        int reduced = mapped.reduce(0, (c, e) -> c+e);
        System.out.println(reduced);

        int result = list.stream()
                .filter(n -> n%2 == 0)
                .map(n -> n*2)
                .reduce(0, (c, e) -> c+e);
        System.out.println(result);
    }
}
