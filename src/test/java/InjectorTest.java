import injector.Injector;
import somepackage.SomeBean;
import org.junit.jupiter.api.Test;

public class InjectorTest {

    @Test
    public void testWithFirstImplementation() {
        SomeBean bean = new Injector("dep1.properties").inject(new SomeBean());
        System.out.println("Expected AC:");
        bean.foo();
    }

    @Test
    public void testWithAlternativeImplementation() {
        SomeBean bean = new Injector("dep2.properties").inject(new SomeBean());
        System.out.println("Expected BC:");
        bean.foo();
    }
}
