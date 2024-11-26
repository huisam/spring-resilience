package com.huisam.springresilience.application1.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("delay", url = "https://api.heropy.dev")
interface DelayClient {

    @GetMapping("/v0/delay")
    fun getTime(@RequestParam t: Int): DelayTimeDto
}