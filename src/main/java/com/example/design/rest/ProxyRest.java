package com.example.design.rest;

import com.example.design.patterns.proxy.JDKProxyImpl;
import com.example.design.patterns.proxy.ProxyStaticImpl;
import com.example.design.patterns.proxy.proxyEntity.IProxyDemo;
import com.example.design.patterns.proxy.proxyEntity.impl.ProxyDemoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;

@RestController
@RequestMapping("proxy")
public class ProxyRest {

    private final IProxyDemo iProxyDemo;
    private final JDKProxyImpl jdkProxy;


    @Autowired
    public ProxyRest(ProxyStaticImpl proxyStatic, JDKProxyImpl jdkProxy) {
        this.iProxyDemo = proxyStatic;
        this.jdkProxy = jdkProxy;
    }

    @RequestMapping("testStaticProxy")
    public String testStaticProxy() {
        iProxyDemo.run();
        iProxyDemo.run("test");
        return "SUCCESS";
    }

    @RequestMapping("testJDKProxy")
    public String testJDKProxy() {
        IProxyDemo proxyDemo = new ProxyDemoImpl();
        proxyDemo = (IProxyDemo) Proxy.newProxyInstance(proxyDemo.getClass().getClassLoader(), proxyDemo.getClass().getInterfaces(), jdkProxy);

        proxyDemo.run();
        proxyDemo.run("test");
        return "SUCCESS";
    }
}
