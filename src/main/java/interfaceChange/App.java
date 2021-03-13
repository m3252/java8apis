package interfaceChange;

public class App {

    public static void main(String[] args){
        Foo foo = new DefaultFoo("moon");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printAnything();
    }
}
