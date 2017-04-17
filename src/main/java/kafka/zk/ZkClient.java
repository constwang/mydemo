package kafka.zk;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by wa on 2017/4/9.
 */
public class ZkClient {
    static class TestWatcher implements Watcher {

        public void process(WatchedEvent watchedEvent) {
            watchedEvent.getType();
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, new TestWatcher());
        String str = zk.create("fa/test", "testdata".getBytes(), null, CreateMode.EPHEMERAL);
        System.out.println(str);
        //zk.getData();
    }
}
