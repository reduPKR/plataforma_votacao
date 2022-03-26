package br.com.candidato.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GsonVotoDeserializer<T> implements Deserializer {
    public static final String TYPE = "asdasd";

    private final Gson gson = new GsonBuilder().create();
    private Class<T> type;

    @Override
    public void configure(Map configs, boolean isKey) {
        String typeName = String.valueOf(configs.get(TYPE));
        try {
            this.type = (Class<T>) Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Classe nao existe");
        }
    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return gson.fromJson(new String(bytes), type);
    }
}
