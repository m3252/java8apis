package streamApis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTwo {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java test", true));
        javaClasses.add(new OnlineClass(7, "The Java Code Manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring")) // 오퍼레이션
                .forEach(oc -> System.out.println(oc.getId() + " " + oc.getTitle())); // 스트림을 리턴하지 않으면 종료 오퍼레이션이다.

        System.out.println("\nclose 되지 않은 수업");
        springClasses.stream()
                //.filter(oc -> !oc.isClosed())
                .filter(Predicate.not(OnlineClass::isClosed)) // 단축 버전 메소드 레퍼런스는 부정을 줄 수 없으므로 Predicate.not 메소드를 활용한다.
                .forEach(oc -> System.out.println(oc.getId() + " " + oc.getTitle())); // 스트림을 리턴하지 않으면 종료 오퍼레이션이다.

        System.out.println("\n수업 이름만 모아서 스트림 만들기");
        List<String> collect = springClasses.stream().map(OnlineClass::getTitle).collect(Collectors.toList());
        collect.forEach(System.out::println);


        List<List<OnlineClass>> moonEvents = new ArrayList<>();
        moonEvents.add(springClasses);
        moonEvents.add(javaClasses);

        System.out.println("\n두 수업 목록에 들어있는 모든 수업 아이디 출력");
        moonEvents.stream().flatMap(Collection::stream)
                .forEach(oc -> System.out.print(oc.getId() + " "));

        System.out.println("\n10부터 1씩 증가하는 무제한 스트림 중에서 앞에 20개를 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(20)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\n자바 수업 중 Test 가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("\n스프링 수업 중에 제목이 Spring 이 들어있는 List 만들기");
        springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .forEach(oc -> System.out.println(oc.getTitle()));



    }

}
