package somepackage;

/**
 * Класс, реализующий SomeOtherInterface. Поведение: печать 'C'.
 */
public class SODoer implements SomeOtherInterface {
    @Override
    public void doSomeOther() {
        System.out.println("C");
    }
}
