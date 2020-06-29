package com.example.design.zookeeper;

import lombok.SneakyThrows;
import org.apache.zookeeper.ZooKeeper;

import java.io.Closeable;

public class ZkClient implements Closeable {

    private final static ThreadLocal<ZooKeeper> zkLocals = new ThreadLocal<>();

    @Override
    @SneakyThrows
    public void close() {
        ZooKeeper zk = zkLocals.get();
        if (zk != null) zk.close();
    }
}
