package org.example;

import injector.Injector;
import somepackage.SomeBean;

/**
 * Точка входа: демонстрация внедрения зависимостей.
 */
public class Main {
    public static void main(String[] args) {
        var injector = new Injector("dep1.properties");
        var bean = new SomeBean();
        injector.inject(bean);
        bean.foo();
    }
}
