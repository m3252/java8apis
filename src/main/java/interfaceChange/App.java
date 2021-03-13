package interfaceChange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

    public static void main(String[] args){
        /*Foo foo = new DefaultFoo("moon");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();*/

        List<String> names = new ArrayList<>();
        names.add("moon");
        names.add("kim");
        names.add("lee");
        names.add("foo");

//        names.forEach(System.out::println); // 메소드 레퍼런스

//        Spliterator<String> spliterator = names.spliterator();
//        Spliterator<String> stringSpliterator = spliterator.trySplit();
//        while (spliterator.tryAdvance(System.out::println));
//        System.out.println("==============");
//        while (stringSpliterator.tryAdvance(System.out::println));


//        for(String name : names){
//            System.out.println(name);
//        }

//        long m = names.stream().map(String::toUpperCase)
//                .filter(s -> s.startsWith("M"))
//                .count();
//
//        System.out.println(m);

//        names.removeIf(s -> s.startsWith("m"));
//        names.forEach(System.out::println);

//        names.sort(String::compareToIgnoreCase);
//        names.forEach(System.out::println);

        Comparator<String> comparator = String::compareToIgnoreCase;
        names.sort(comparator.reversed());
        names.forEach(System.out::println);





    }
}
