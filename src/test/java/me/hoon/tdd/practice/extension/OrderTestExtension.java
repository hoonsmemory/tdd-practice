package me.hoon.tdd.practice.extension;

import org.junit.jupiter.api.extension.*;

public class OrderTestExtension implements BeforeAllCallback, BeforeEachCallback, BeforeTestExecutionCallback, AfterAllCallback, AfterEachCallback, AfterTestExecutionCallback {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("BeforeAllCallback 실행");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("BeforeEachCallback 실행");
        ExtensionContext.Store store = getStore(context);
        store.put("key", "value");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("beforeTestExecution 실행");
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("AfterAllCallback 실행");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("AfterEachCallback 실행");
        ExtensionContext.Store store = getStore(context);
        System.out.println(store.get("key"));
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("afterTestExecution 실행");
        getExtensionContextInfo(context);
    }

    private void getExtensionContextInfo(ExtensionContext context) {
        System.out.println(context.getRequiredTestClass().getName());
        System.out.println(context.getRequiredTestMethod().getName());
    }

    private static ExtensionContext.Store getStore(ExtensionContext context) {
        String testClassName = context.getRequiredTestClass().getName();
        String testMethodName = context.getRequiredTestMethod().getName();
        return context.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
    }
}
