package service

import config.KafkaProperties
import model.OrderStatusDto
import org.springframework.kafka.core.KafkaTemplate

class KafkaStatusService(
    private val kafkaProperties: KafkaProperties,
    private val producerStatus : KafkaTemplate<String, OrderStatusDto>
) {

    fun sendOrderStatus(orderStatusDto: OrderStatusDto) {
        producerStatus.send(kafkaProperties.status, orderStatusDto)
    }
}