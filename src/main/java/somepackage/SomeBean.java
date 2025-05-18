package somepackage;

import injector.AutoInjectable;

/**
 * Класс с полями, в которые внедряются зависимости.
 */
public class SomeBean {

    @AutoInjectable
    private SomeInterface logic;

    @AutoInjectable
    private SomeOtherInterface altLogic;

    /**
     * Демонстрация вызова внедренных зависимостей.
     */
    public void foo() {
        if (logic != null) logic.doSomething();
        if (altLogic != null) altLogic.doSomeOther();
    }
}
