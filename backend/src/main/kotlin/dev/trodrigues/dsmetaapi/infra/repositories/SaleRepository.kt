package dev.trodrigues.dsmetaapi.infra.repositories

import dev.trodrigues.dsmetaapi.domain.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository : JpaRepository<Sale, Long>
