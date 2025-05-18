package somepackage;

import injector.AutoInjectable;

public class SomeBean {

    @AutoInjectable
    private SomeInterface logic;

    @AutoInjectable
    private SomeOtherInterface altLogic;

    public void foo() {
        if (logic != null) logic.doSomething();
        if (altLogic != null) altLogic.doSomeOther();
    }
}
