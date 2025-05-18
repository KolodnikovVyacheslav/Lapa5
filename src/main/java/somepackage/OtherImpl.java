package somepackage;

/**
 * Другая реализация интерфейса SomeInterface. Поведение: печать 'B'.
 */
public class OtherImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.println("B");
    }
}
