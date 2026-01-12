package com.sabekur2017.HoneySellTracker

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class HoneySale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val batchId: String,
    val sellingDate: LocalDate,
    val buyerName: String,
    val quantityKg: Double,
    val amount: BigDecimal,
    val paymentCleared: Boolean,
    val dueDate: LocalDate? = null,
    val paymentMethod: String
)
