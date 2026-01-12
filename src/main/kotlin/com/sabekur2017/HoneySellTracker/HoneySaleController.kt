package com.sabekur2017.HoneySellTracker

import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/sales")
class HoneySaleController(private val service: HoneySaleService) {

    @PostMapping
    fun createSale(@RequestBody sale: HoneySale): HoneySale {
        return service.saveSale(sale)
    }

    @GetMapping
    fun getAllSales(): List<HoneySale> {
        return service.getAllSales()
    }

    @GetMapping("/batch/{batchId}")
    fun getSalesByBatchId(@PathVariable batchId: String): List<HoneySale> {
        return service.getSalesByBatchId(batchId)
    }

    @GetMapping("/summary")
    fun getSummary(@RequestParam(required = false) batchId: String?): Map<String, Any> {
        return service.getSalesSummary(batchId)
    }
}
