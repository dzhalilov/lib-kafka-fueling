package service

import config.KafkaProperties
import model.OrderProcessingDto
import model.OrderStatusDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate

class KafkaStatusService(
    private val kafkaProperties: KafkaProperties,
    private val producerStatus : KafkaTemplate<String, OrderStatusDto>,
    private val listenerInterface: ListenerInterface<OrderProcessingDto>
): FuelingKafkaServiceLib<OrderProcessingDto> {

    fun sendOrderStatus(orderStatusDto: OrderStatusDto) {
        producerStatus.send(kafkaProperties.status, orderStatusDto)
    }

    @KafkaListener(topics = ["FUELING.PROCESSING"], groupId = "fueling-order")
    override fun getMessage(dto: OrderProcessingDto) = listenerInterface.getMessage(dto)

}