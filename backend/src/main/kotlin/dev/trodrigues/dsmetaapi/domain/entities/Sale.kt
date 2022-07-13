package dev.trodrigues.dsmetaapi.domain.entities

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "tb_sales")
data class Sale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val sellerName: String,
    val visited: Int = 0,
    val deals: Int = 0,
    val amount: BigDecimal = BigDecimal.ZERO,
    val date: LocalDate? = null,
)
