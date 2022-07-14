package dev.trodrigues.dsmetaapi.api.controllers.filters

import java.time.LocalDate

data class SaleFilter(
    val minDate: String? = null,
    val maxDate: String? = null
)

fun SaleFilter.minDateToLocalDate(): LocalDate {
    return LocalDate.parse(this.minDate) ?: LocalDate.MIN
}

fun SaleFilter.maxDateToLocalDate(): LocalDate =
    LocalDate.parse(this.maxDate ?: LocalDate.now().toString())
