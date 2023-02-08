import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(16);
        integerList.add(2);
        integerList.add(67);
        integerList.add(4);
        Stream stream1 = integerList.stream();

         findMinMax(stream1, Integer::compareTo,
                 (x, y) -> System.out.println("минимальное значение " + x + "\n" + "максимальное значение " + y));

          definitionOfEvenNumbers(integerList);
    }

    public static<T> void findMinMax (Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer){
        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }

    public static void definitionOfEvenNumbers(List list) {
        Stream <Integer> stream = list.stream();
        System.out.println(stream.filter(x -> x %2 == 0)
                .count());
    }
}