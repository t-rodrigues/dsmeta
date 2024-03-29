package dev.trodrigues.dsmetaapi.api.controllers

import dev.trodrigues.dsmetaapi.api.controllers.filters.SaleFilter
import dev.trodrigues.dsmetaapi.domain.entities.Sale
import dev.trodrigues.dsmetaapi.domain.services.SaleService
import dev.trodrigues.dsmetaapi.infra.providers.sms.SmsService
import dev.trodrigues.dsmetaapi.infra.repositories.specifications.SaleSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sales")
class SaleController(
    private val saleService: SaleService,
    private val smsService: SmsService
) {

    @GetMapping
    fun getSales(
        saleFilter: SaleFilter,
        @PageableDefault(
            size = 20,
            page = 0,
            sort = ["amount"],
            direction = Sort.Direction.DESC
        ) pageable: Pageable
    ): Page<Sale> =
        saleService.getSales(SaleSpecification.getSales(saleFilter), pageable)

    @GetMapping("/{saleId}/notification")
    fun notifySms(@PathVariable saleId: Long) = smsService.sendSms(saleId)
}
