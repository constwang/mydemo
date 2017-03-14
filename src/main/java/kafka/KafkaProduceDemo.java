package kafka;

import designpattern.singleton.DoubleCheckLockingSingleton;
import designpattern.singleton.EnumSingleton;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wa on 2017/2/23.
 */
public class KafkaProduceDemo {
    static {
        //System.out.println(totalCount);
        totalCount=100;
    }
    static int totalCount=10;


    public static String getValue() {
        return null;
    }

    public static void main(String[] args) {

        //LinkedHashMap map=new LinkedHashMap()
        ArrayList list=new ArrayList();
        ConcurrentHashMap hashMap=new ConcurrentHashMap();
        Vector vector=new Vector();
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        //props.put("acks", "all");
        props.put("retries", 3);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        //props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        //ProducerRecord<String,String> record=new ProducerRecord<String, String>()
        //Partitioner
        System.out.println("start produce");
        //for (int i = 0; i < 1000000; i++)
        producer.send(new ProducerRecord<>("dual-partition", "data-" + Integer.toString(10)));
        //producer.send(new ProducerRecord<String, String>())

        System.out.println("end");
        producer.flush();
        producer.close();

    }
}
