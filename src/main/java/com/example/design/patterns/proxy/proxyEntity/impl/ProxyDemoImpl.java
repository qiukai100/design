package com.example.design.patterns.proxy.proxyEntity.impl;

import com.example.design.patterns.proxy.proxyEntity.IProxyDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProxyDemoImpl implements IProxyDemo {

    @Override
    public String run() {
        return "ProxyDemoImpl is run. not params";
    }

    @Override
    public void run(String msg) {
        log.info("ProxyDemoImpl is run. msg is {}", msg);
    }
}
