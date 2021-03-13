package interfaceChange;

public interface Foo {

    // 인터페이스의 모든 메소드는 퍼블릭
    void printName();


    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자를 대문자로 바꿔 출력한다.
     */
    // Foo 인터페이스를 상속받는 클래스에 영향을 주지 않는다.
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();

}
