package service

import config.KafkaProperties
import model.OrderProcessingDto
import model.OrderStatusDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate

class KafkaOrderService(
    private val kafkaProperties: KafkaProperties,
    private val producerProcessing: KafkaTemplate<String, OrderProcessingDto>,
    private val listenerInterface: ListenerInterface<OrderStatusDto>
): FuelingKafkaServiceLib<OrderStatusDto>  {

    fun sendOrderProcessing(orderProcessingDto: OrderProcessingDto) {
        producerProcessing.send(kafkaProperties.processing, orderProcessingDto)
    }

    @KafkaListener(topics = ["FUELING.STATUS"], groupId = "fueling-status")
    override fun getMessage(dto: OrderStatusDto) = listenerInterface.getMessage(dto)
}