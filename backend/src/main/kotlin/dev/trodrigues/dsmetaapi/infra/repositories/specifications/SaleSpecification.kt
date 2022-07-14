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
                predicates.add(
                    cb.greaterThanOrEqualTo(root.get("date"), convertToLocalDate(it))
                )
            }

            saleFilter.maxDate?.let {
                predicates.add(
                    cb.lessThanOrEqualTo(root.get("date"), convertToLocalDate(it))
                )
            }

//            predicates.add(
//                cb.desc(root.get("amount"))
//            )

            cb.and(*predicates.toTypedArray())
        }
    }

    private fun convertToLocalDate(date: String): LocalDate {
        return try {
            LocalDate.parse(date)
        } catch (exception: Exception) {
            LocalDate.now()
        }
    }
}
