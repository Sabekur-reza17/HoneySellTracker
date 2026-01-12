package com.sabekur2017.HoneySellTracker

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HoneySaleRepository : JpaRepository<HoneySale, Long> {
    fun findByBatchId(batchId: String): List<HoneySale>
}
