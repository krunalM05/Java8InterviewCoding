import java.util.*;
import java.util.stream.Collectors;

public class StringManipulationCoding {

    public static void main(String[] args) {
        String str  = "Java is God!";

        // reverse String
        StringBuilder s = new StringBuilder(str);
        System.out.println("reverse string:" + s.reverse());

        // find first repeating character
        Set<String> set = new HashSet<>();
        Arrays.stream(str.split("")).filter(c -> !c.equals(" ")).filter(c -> !set.add(c))
                .findFirst().ifPresent(System.out::println);

        // find count of each word
        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect.toString());

        Map<String, Long> collect2 = collect.entrySet().stream().filter(entryset -> entryset.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect2);

        // return count of each vowel
        Map<String, Long> collect1 = Arrays.stream(str.toLowerCase().split("")).filter("aeiou"::contains)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(collect1.toString());

        String sentance = "Java is programming language best of all time love it";
        // group by length
        Map<Integer, List<String>> collect3 = Arrays.stream(sentance.split(" "))
                .collect(Collectors.groupingBy(String::length));
        System.out.println(collect3);

        String s1 = "Java";
        String s2 = "vaja";

        // check anagrams or not - same char with same freq in both strings
        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.equals(arr1, arr2));
    }

}
