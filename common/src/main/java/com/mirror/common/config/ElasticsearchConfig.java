package com.mirror.common.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mirror
 */
@Configuration
//@ConfigurationProperties(prefix = "elasticsearch")
@ConditionalOnProperty("elasticsearch.host")
//调用日志
@Slf4j
@RequiredArgsConstructor
public class ElasticsearchConfig {
    //这里就是用@value注入
    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.scheme:http}")
    private String scheme;

    @Value("${elasticsearch.apiKey:}")
    private String apiKey;
    //创建一个map
    final ObjectMapper objectMapper;
    //注入bean
    @Bean
    public ElasticsearchClient elasticsearchClient() {
        log.info(">>>>>>>>>>> ElasticsearchClient config init.");
        RestClient restClient = RestClient.builder(
                new HttpHost(host, port, scheme))
                .setDefaultHeaders(
                        new Header[]{
                                new BasicHeader("Authorization", "ApiKey " + apiKey)
                        }
                )
                .build();
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper(objectMapper));
        ElasticsearchClient client = new ElasticsearchClient(transport);

        log.info("ElasticsearchClient init end");
        return client;
    }
}
