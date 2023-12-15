package service

interface ListenerInterface<T> {

    fun getMessage(dto: T)
}