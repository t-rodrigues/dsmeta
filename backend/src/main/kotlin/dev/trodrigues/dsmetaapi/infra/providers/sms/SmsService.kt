package dev.trodrigues.dsmetaapi.infra.providers.sms

interface SmsService {

    fun sendSms(saleId: Long)
}
