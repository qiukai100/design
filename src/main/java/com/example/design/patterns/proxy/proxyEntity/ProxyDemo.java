package com.example.design.patterns.proxy.proxyEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * 需要被代理的类
 */
@Slf4j
public class ProxyDemo {

    public String run() {
        return "ProxyDemo is run. not params";
    }

    public void run(String msg) {
        log.debug("ProxyDemo is run. msg is {}", msg);
    }
}
