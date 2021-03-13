package interfaceChange;

public interface Bar extends Foo {

    // void printNameUpperCase();

    default void printNameUpperCase(){
        System.out.println("Bar");
    }

}
