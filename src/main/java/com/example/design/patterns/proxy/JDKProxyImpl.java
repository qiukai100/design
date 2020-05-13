package com.example.design.patterns.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Service
public class JDKProxyImpl implements InvocationHandler {

    private final EnhanceWay enhanceWay;

    @Autowired
    public JDKProxyImpl(EnhanceWay enhanceWay) {
        this.enhanceWay = enhanceWay;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Exception exception = null;
        try {
            enhanceWay.before();
            return method.invoke(proxy, args);
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            if (exception != null) {
                enhanceWay.after();
            } else {
                enhanceWay.afterEx();
            }
        }
    }
}
