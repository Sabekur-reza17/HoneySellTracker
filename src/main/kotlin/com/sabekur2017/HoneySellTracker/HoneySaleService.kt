package com.sabekur2017.HoneySellTracker

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class HoneySaleService(private val repository: HoneySaleRepository) {

    fun saveSale(sale: HoneySale): HoneySale {
        return repository.save(sale)
    }

    fun getAllSales(): List<HoneySale> {
        return repository.findAll()
    }

    fun getSalesByBatchId(batchId: String): List<HoneySale> {
        return repository.findByBatchId(batchId)
    }

    fun getSalesSummary(batchId: String? = null): Map<String, Any> {
        val sales = if (batchId != null) {
            repository.findByBatchId(batchId)
        } else {
            repository.findAll()
        }

        val totalKg = sales.sumOf { it.quantityKg }
        val totalAmount = sales.fold(BigDecimal.ZERO) { acc, sale -> acc.add(sale.amount) }
        val totalSalesCount = sales.size

        return mapOf(
            "totalKg" to totalKg,
            "totalAmount" to totalAmount,
            "totalSalesCount" to totalSalesCount
        )
    }
}
