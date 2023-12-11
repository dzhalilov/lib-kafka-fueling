package domain

enum class FuelingOrderStatus {
    CREATED,
    PROCESSING,
    FUELLING,
    CHANGE_DUE,
    COMPLETED,
    CANCELED
}