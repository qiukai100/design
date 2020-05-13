package com.example.design.patterns.proxy;

import com.example.design.patterns.proxy.proxyEntity.IProxyDemo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 静态代理模式
 * 1、必须实现需要代理的接口
 * 2、重写接口时进行增强操作
 */
@Service
public class ProxyStaticImpl implements IProxyDemo {

    @Resource(name = "proxyDemoImpl")
    private IProxyDemo iProxyDemo;
    @Resource
    private EnhanceWay enhanceWay;


    @Override
    public String run() {
        enhanceWay.before();
        Exception exception = null;
        try {
            return iProxyDemo.run();
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) {
                enhanceWay.after();
            } else {
                enhanceWay.afterEx();
            }
        }
    }

    @Override
    public void run(String msg) {
        enhanceWay.before();
        Exception exception = null;
        try {
            iProxyDemo.run(msg);
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            if (exception == null) {
                enhanceWay.after();
            } else {
                enhanceWay.afterEx();
            }
        }
    }
}
