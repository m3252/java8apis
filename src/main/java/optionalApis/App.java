package optionalApis;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<OnlineClass> optionalTwo = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        /*OnlineClass onlineClass = optional.orElseGet(() -> createNewClass());
        OnlineClass onlineClass2 = optionalTwo.orElseGet(App::createNewClass);
        OnlineClass onlineClass3 = optionalTwo.orElseThrow(() -> {
            return new IllegalArgumentException();
        });*/

        Optional<OnlineClass> onlineClass4 = optional.filter(oc -> !oc.isClosed());
        Optional<OnlineClass> onlineClass5 = optionalTwo.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass4.isEmpty());
        System.out.println(onlineClass5.isEmpty());

    }

    private static OnlineClass createNewClass() {
        System.out.println(" creating new online class");
        return new OnlineClass(10, "New Class", false);
    }

}
