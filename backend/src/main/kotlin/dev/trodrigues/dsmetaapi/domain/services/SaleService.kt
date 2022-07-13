package dev.trodrigues.dsmetaapi.domain.services

import dev.trodrigues.dsmetaapi.domain.entities.Sale
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SaleService {

    fun getSales(pageable: Pageable): Page<Sale>

}
