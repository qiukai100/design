package com.example.design.main;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkClientTest {
    private final static Logger log = LoggerFactory.getLogger(ZkClientTest.class);

    private final static String zkServer = "192.168.227.128:2181";

    private final static int timeout = 20 * 1000;

    private final static CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(2);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String path = "/client test";
        byte[] data = "20200623".getBytes("UTF-8");
        ZooKeeper zk = new ZooKeeper(zkServer, timeout, (event) -> log.debug(" receive event : {}", event.getType().name()));
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(COUNT_DOWN_LATCH.toString());
        byte[] val = zk.getData(path, true, new Stat());
        String value = new String(val, "UTF-8");
        System.out.println(value);
        zk.close();
    }
}
