package streamApis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        names.add("moon");
        names.add("kim");
        names.add("lee");
        names.add("toby");



        /*Stream<String> stringStream = names.stream().map(String::toUpperCase);
        names.forEach(System.out::println); // 결과가 바뀌지 않는다.
        stringStream.forEach(System.out::println); // 바뀐 결과를 담아낸 스트림*/

        // names 결과를 바꾸지 않는다. (중개형 오퍼레이터)
        /*List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());// 종료형 오퍼레이터 선언
        collect.forEach(System.out::println);

        System.out.println("============");
        names.forEach(System.out::println);*/

        // 병렬처리 어려운 코드
        for (String name : names){
            if(name.startsWith("k"))
                System.out.println(name.toUpperCase());
        }

        // 쉬운 병렬처리
        /*List<String> collect = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);*/

        List<String> collect = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

    }
}
