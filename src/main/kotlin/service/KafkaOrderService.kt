package service

import config.KafkaProperties
import model.OrderProcessingDto
import org.springframework.kafka.core.KafkaTemplate

class KafkaOrderService(
    private val kafkaProperties: KafkaProperties,
    private val producerProcessing: KafkaTemplate<String, OrderProcessingDto>
) {

    fun sendOrderProcessing(orderProcessingDto: OrderProcessingDto) {
        producerProcessing.send(kafkaProperties.processing, orderProcessingDto)
    }
}