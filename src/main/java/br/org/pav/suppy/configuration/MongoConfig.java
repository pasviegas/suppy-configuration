package br.org.pav.suppy.configuration;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

@Configuration
@PropertySource("classpath:production-mongo.properties")
public class MongoConfig {

    @Value("${mongo.host.name}")
    private String host;

    @Value("${mongo.host.port}")
    private Integer port;

    @Value("${mongo.db.name}")
    private String name;

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new Mongo(host, port);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongo(), name);
    }

}

