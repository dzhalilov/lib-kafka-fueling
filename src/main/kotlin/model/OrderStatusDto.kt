package model

import java.util.*

data class OrderStatusDto(
    val id: UUID,
    val status: FuelingOrderStatus
)
