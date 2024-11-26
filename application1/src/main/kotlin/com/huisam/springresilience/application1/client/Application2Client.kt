package com.huisam.springresilience.application1.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("application2", url = "http://localhost:8081")
interface Application2Client {
    @GetMapping("/delay/time")
    fun getDelayTime(
        @RequestParam t: Long
    ): DelayTimeDto
}