package proxy;

import pojo.Girl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GirlProxy implements InvocationHandler {

    private Girl girl;

    public GirlProxy(final Girl girl) {
        this.girl = girl;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        System.out.println("Proxy: Okay, the method I need to deal with is: " + method);

        doSomethingBefore();
        /*args是怎么来的？*/
        Object res = method.invoke(girl, args);
        doSomethingAfter();
        return res;
    }

    private void doSomethingBefore() {
        System.out.println("Girl family: Okok, let us do a background check");
    }

    private void doSomethingAfter() {
        System.out.println("Girl family: How is this boy?");
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
            girl.getClass().getClassLoader(),
            girl.getClass().getInterfaces(),
            this
        );
    }
}
