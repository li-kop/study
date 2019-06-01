import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "");

        list.forEach(System.out::println);

        long count = list.stream().filter(String::isEmpty).count();
        System.out.println(count);

        System.out.println(list.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(",")));

        new Random().ints().limit(10).forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list1.stream().filter(list2 -> list2 > 1
        ).forEach(System.out::println);

    }
}
