import injector.Injector;
import somepackage.SomeBean;
import org.junit.jupiter.api.Test;

/**
 * Тесты внедрения зависимостей для класса SomeBean.
 */
public class InjectorTest {

    /**
     * Проверяет внедрение с реализацией SomeImpl.
     */
    @Test
    public void testWithFirstImplementation() {
        SomeBean bean = new Injector("dep1.properties").inject(new SomeBean());
        System.out.println("Expected AC:");
        bean.foo();
    }

    /**
     * Проверяет внедрение с реализацией OtherImpl.
     */
    @Test
    public void testWithAlternativeImplementation() {
        SomeBean bean = new Injector("dep2.properties").inject(new SomeBean());
        System.out.println("Expected BC:");
        bean.foo();
    }
}
