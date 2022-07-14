package dev.trodrigues.dsmetaapi.infra.repositories.specifications

import dev.trodrigues.dsmetaapi.api.controllers.filters.SaleFilter
import dev.trodrigues.dsmetaapi.domain.entities.Sale
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate
import javax.persistence.criteria.Predicate

object SaleSpecification {

    fun getSales(saleFilter: SaleFilter): Specification<Sale> {
        return Specification { root, _, cb ->
            val predicates = mutableListOf<Predicate>()

            saleFilter.minDate?.let {
                val minDate = convertToLocalDate(it)
                predicates.add(
                    cb.greaterThanOrEqualTo(root.get("date"), minDate ?: LocalDate.now().minusYears(1))
                )
            }

            saleFilter.maxDate?.let {
                predicates.add(
                    cb.lessThanOrEqualTo(root.get("date"), convertToLocalDate(it) ?: LocalDate.now())
                )
            }

            cb.and(*predicates.toTypedArray())
        }
    }

    private fun convertToLocalDate(date: String): LocalDate? {
        return try {
            LocalDate.parse(date)
        } catch (exception: Exception) {
            null
        }
    }
}
