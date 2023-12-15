package service

interface FuelingKafkaServiceLib<T> {

    fun getMessage(dto: T)
}