package dev.trodrigues.dsmetaapi.domain.services

import dev.trodrigues.dsmetaapi.domain.entities.Sale
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification

interface SaleService {

    fun getSales(specification: Specification<Sale>, pageable: Pageable): Page<Sale>
}
