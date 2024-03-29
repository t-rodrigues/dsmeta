package dev.trodrigues.dsmetaapi.domain.services.impl

import dev.trodrigues.dsmetaapi.domain.entities.Sale
import dev.trodrigues.dsmetaapi.domain.services.SaleService
import dev.trodrigues.dsmetaapi.infra.repositories.SaleRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service

@Service
class SaleServiceImpl(
    private val saleRepository: SaleRepository
) : SaleService {

    override fun getSales(specification: Specification<Sale>, pageable: Pageable): Page<Sale> =
        saleRepository.findAll(specification, pageable)
}
