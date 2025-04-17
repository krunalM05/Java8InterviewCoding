import java.util.*;
import java.util.stream.Collectors;

public class HashMapInt {

    public static void main(String[] args) {
        People p1 = new People(11, "Krunal");
        People p2 = new People(45, "Prasad");
        People p3 = new People(46, "Tushar");
        People p4 = new People(89,"Soham");

        Map<People, Double> peopleMap = new HashMap<>();
        peopleMap.put(p1, 45000.0);
        peopleMap.put(p2, 60000.0);
        peopleMap.put(p3,89000.0);
        peopleMap.put(p4,65000.0);
        //peopleMap.put(null, 85000.0);

        // iterate over Map using iterator
        Iterator<Map.Entry<People, Double>> iterator = peopleMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<People, Double> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // iterate using for loop
        for(Map.Entry<People, Double> entry : peopleMap.entrySet()){
            System.out.println(entry.getKey().toString() + " = " + entry.getValue());
        }

        // iterate using keySet
        for(People key : peopleMap.keySet()){
            System.out.println(key.toString() + " = " + peopleMap.get(key));
        }

        // iterate using stream API
        peopleMap
                .forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
        peopleMap.entrySet()
                .forEach(entry -> System.out.println(entry.getKey().toString()+":"+
                        entry.getValue()));

        // sort hashmap based on values
        LinkedHashMap<People, Double> collected = peopleMap.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        collected.forEach((key,value)->System.out.println("Key: " + key + ", Value: " + value));

        //sort hashmap based on people name
        LinkedHashMap<People, Double> collected1 = peopleMap.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        collected1.forEach((key,value)->System.out.println("Key: " + key + ", Value: " + value));


    }
}
