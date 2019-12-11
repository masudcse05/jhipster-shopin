package com.mhaque.jhipster.web.rest;

import com.mhaque.jhipster.service.JhipstershopinKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jhipstershopin-kafka")
public class JhipstershopinKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipstershopinKafkaResource.class);

    private JhipstershopinKafkaProducer kafkaProducer;

    public JhipstershopinKafkaResource(JhipstershopinKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
