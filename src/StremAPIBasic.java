import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StremAPIBasic {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11,22,66,55,44,33,88,99,77,99,55,22,11,99);

        // return sum of even numbers
        int sum = numbers.stream().filter(x -> x%2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even numbers: " + sum);

        // return first largest number
        int max = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("first largest number: " + max);

        // return 3rd largest numbers
        Integer thirdLargest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
        System.out.println("3rd largest number: " + thirdLargest);

        // return all duplicate numbers
        Set<Integer> set = new HashSet<>();
        List<Integer> listOfDuplicates = numbers.stream().filter(x -> !set.add(x)).collect(Collectors.toList());
        System.out.println("dulicate Numbers: " + listOfDuplicates);

        // return frequency of each number
        Map<Integer, Long> frequency = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of Numbers: " + frequency);

        // sort by frequency
        List<Map.Entry<Integer, Long>> sortedFreq = frequency.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue).reversed().thenComparing(Map.Entry<Integer, Long>::getValue))
                .collect(Collectors.toList());
        System.out.println("sorted Frequency of Numbers: " + sortedFreq);

        // return Map with frequency: key and value: List of number having that frequency
        Map<Long, List<Integer>> frequencyAsList = frequency.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry:: getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println("Frequency:List Of Numbers:" +frequencyAsList);


        String fruits = "banana, apple, lemon, orange, apple, watermelon, banana, kiwi, banana, lemon, avocado, berry";

        // return frequency of word in string
        Map<String, Long> collect = Arrays.stream(fruits.split(", ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freq" + collect);

        // group words by initial letter and sorted
        Map<Character, List<String>> groupByIntialLetter = Arrays.stream(fruits.split(", ")).distinct()
                .collect(Collectors.groupingBy(s -> s.charAt(0), TreeMap::new, Collectors.toList()));
        System.out.println("group words by initial letter : "+ groupByIntialLetter);

        // return map with word length as key and value as word
        Map<Integer, String> map = Arrays.stream(fruits.split(", "))
                .collect(Collectors.toMap(
                        String::length,                 // key = string length
                        Function.identity(),            // value = string itself
                        (v1, v2) -> v1                  // merge function if duplicate keys
                ));
        System.out.println(map);

        // sum of all numbers
        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum of all numbers: " + sum1);


    }

}
