package dev.trodrigues.dsmetaapi.infra.providers.sms.impl

import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import dev.trodrigues.dsmetaapi.infra.providers.sms.SmsService
import dev.trodrigues.dsmetaapi.infra.repositories.SaleRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SmsServiceImpl(
    @Value("\${twilio.account-sid}") private val twilioAccountSid: String,
    @Value("\${twilio.auth-token}") private val twilioAuthToken: String,
    @Value("\${twilio.phone-from}") private val twilioPhoneFrom: String,
    @Value("\${twilio.phone-to}") private val twilioPhoneTo: String,
    private val saleRepository: SaleRepository
) : SmsService {

    override fun sendSms(saleId: Long) {
        val sale = saleRepository.findById(saleId).orElseThrow { IllegalArgumentException() }
        Twilio.init(twilioAccountSid, twilioAuthToken)

        val from = PhoneNumber(twilioPhoneFrom)
        val to = PhoneNumber(twilioPhoneTo)
        val date = "${sale.date?.monthValue}/${sale.date?.year}"
        val text =
            "O vendedor %s na data %s teve um total de R$ %.2f em vendas".format(sale.sellerName, date, sale.amount)
        val message = Message.creator(to, from, text).create()
        println(message.sid)
    }
}
