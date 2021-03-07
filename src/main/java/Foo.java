import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Foo {

    public static void main(String[] args){

        // 익명 내부 클래스 anonymous inner class java 8 이전
//        RunSomething beforeRunSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("moon");
//                System.out.println("seungchan");
//            }
//        };

        // 람다식 java 8 이후
//        RunSomething afterRunSomething = () -> {
//            System.out.println("moon");
//            System.out.println("seungchan");
//        };
//
//        beforeRunSomething.doIt();
//        afterRunSomething.doIt();

        RunSomething beforeRunSomething = new RunSomething() {
            @Override
            public int doIt(int number) {
                int baseNumber = 10;
                return number + baseNumber;
            }
        };

        RunSomething afterRunSomething = number -> {
            int baseNumber = 10;
            return number + baseNumber;
        };

        System.out.println(beforeRunSomething.doIt(3));
        System.out.println(afterRunSomething.doIt(3));

        /* java8에서 제공하는 함수형 인터페이스 사용법 하나. */
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(3));

        /* java8에서 제공하는 함수형 인터페이스 사용법 둘. */
        Function<Integer, Integer> afterPlus10 = (i) -> i+10;
        System.out.println(afterPlus10.apply(3));

        Function<Integer, Integer> multiply2 = (i) -> i*2;
        System.out.println(multiply2.apply(3));

        Function<Integer, Integer> multiply2AndPlus10 = afterPlus10.compose(multiply2);
        System.out.println("multiply2AndPlus10 :" + multiply2AndPlus10.apply(2));

        Function<Integer, Integer> plus10AndMultiply2 = afterPlus10.andThen(multiply2);
        System.out.println("plus10AndMultiply2 :" + plus10AndMultiply2.apply(2));

        Consumer<Integer> printT = (i) -> System.out.println("Consumer :" + i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println("Supplier :" + get10.get());

        Predicate<String> startWithMoon = (s) -> s.startsWith("Moon");
        System.out.println("Predicate :" + startWithMoon.test("Moonseungchan"));

        Predicate<Integer> isEven = (i) -> i%2 == 0;
        System.out.println("Predicate :" + isEven.test(2));

    }
}
