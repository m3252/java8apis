import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = Greeting::hi;
        UnaryOperator<String> hello = greeting::hello;

//        Supplier<Greeting> newGreeting = Greeting::new; // 서플라이어는 그리팅이 아니다.
//        Greeting greeting1 = newGreeting.get();  // 그리팅이 되는 시점

        Function<String, Greeting> moonGreeting = Greeting::new;
        Greeting moon = moonGreeting.apply("moon"); // String 을 인자로 받는 Greeting 생성
        System.out.println(moon.getName());

        Supplier<Greeting> newGreeting2 = Greeting::new; // 디폴트 생성자로 Greeting 생성

        String[] names = {"moon", "keesun", "toby"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
