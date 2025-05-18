package somepackage;

/**
 * Реализация SomeInterface. Поведение: печать 'A'.
 */
public class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}
