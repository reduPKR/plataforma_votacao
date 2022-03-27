package br.com.eleitor.kafka;

import br.com.eleitor.eleitor.EleitorService;
import br.com.eleitor.voto.VotoService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.UUID;

public class KafkaService<T> {
    private final KafkaConsumer<String, T> consumer;
    private final ConsumerFunction parse;
    private final Class<T> type;
    private final EleitorService eleitorService;
    private final VotoService votoService;

    public KafkaService(String groupId, String topic, EleitorService eleitorService,
                        VotoService votoService, ConsumerFunction parse, Class<T> type) {
        this.eleitorService = eleitorService;
        this.votoService = votoService;
        this.parse = parse;
        this.consumer = new KafkaConsumer<>(properties(groupId, type));
        this.type = type;
        consumer.subscribe(Collections.singletonList(topic));
    }

    public void run() {
      while (true) {
            var records = consumer.poll(Duration.ofMillis(10000));
            if (!records.isEmpty()) {
                System.out.println(records.count() + " registros");
                for (var record : records) {
                    parse.consume(record);
                }
            }
      }
    }

    private Properties properties(String groupId, Class<T> type) {
        var properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.4:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GsonVotoDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.CLIENT_ID_CONFIG, UUID.randomUUID().toString());
        properties.setProperty(GsonVotoDeserializer.TYPE,type.getName());
        return properties;
    }
}
