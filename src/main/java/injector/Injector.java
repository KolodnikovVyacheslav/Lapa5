package injector;

import java.lang.reflect.*;
import java.util.Properties;
import java.io.InputStream;

/**
 * Основной класс для внедрения зависимостей в поля объектов.
 */
public class Injector {

    private final Properties configuration;

    /**
     * Создание инжектора и загрузка конфигурации внедрения.
     *
     * @param fileName имя .properties файла с настройками
     */
    public Injector(String fileName) {
        configuration = new Properties();
        try (InputStream stream = ClassLoader.getSystemResourceAsStream(fileName)) {
            if (stream == null) {
                throw new IllegalArgumentException("Не удалось найти properties-файл: " + fileName);
            }
            configuration.load(stream);
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка загрузки конфигурации внедрения", ex);
        }
    }

    /**
     * Производит инъекцию зависимостей в помеченные поля переданного объекта.
     *
     * @param target объект, в который нужно внедрить зависимости
     * @param <T> тип объекта
     * @return объект с внедрёнными полями
     */
    public <T> T inject(T target) {
        Class<?> clazz = target.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field f : declaredFields) {
            if (!f.isAnnotationPresent(AutoInjectable.class)) continue;

            String key = f.getType().getName();
            String implName = configuration.getProperty(key);

            if (implName == null) {
                throw new IllegalStateException("Нет реализации для интерфейса: " + key);
            }

            try {
                Class<?> implClass = Class.forName(implName);
                Object instance = implClass.getDeclaredConstructor().newInstance();
                boolean wasAccessible = f.canAccess(target);
                f.setAccessible(true);
                f.set(target, instance);
                f.setAccessible(wasAccessible);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Ошибка внедрения для поля: " + f.getName(), e);
            }
        }
        return target;
    }
}
