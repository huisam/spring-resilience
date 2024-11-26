package com.huisam.springresilience.application1.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "self-client", url = "http://localhost:8080")
interface SelfClient {

    @GetMapping("/delay/time")
    fun getTime(@RequestParam t: Int): DelayTimeDto
}