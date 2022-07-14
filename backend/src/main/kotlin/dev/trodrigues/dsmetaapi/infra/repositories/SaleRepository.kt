package dev.trodrigues.dsmetaapi.infra.repositories

import dev.trodrigues.dsmetaapi.domain.entities.Sale
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface SaleRepository : JpaRepository<Sale, Long>, JpaSpecificationExecutor<Sale> {

    @Query("select s from Sale s where s.date between :minDate and :maxDate order by s.amount desc")
    fun findSalesByDates(minDate: LocalDate, maxDate: LocalDate, pageable: Pageable): Page<Sale>
}
