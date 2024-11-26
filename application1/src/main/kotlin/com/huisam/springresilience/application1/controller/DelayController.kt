package com.huisam.springresilience.application1.controller

import com.huisam.springresilience.application1.client.DelayClient
import com.huisam.springresilience.application1.client.DelayTimeDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/delay")
class DelayController(
    private val delayClient: DelayClient,
) {
    @GetMapping("/time")
    fun delay(
        @RequestParam t: Int
    ): DelayTimeDto {
        return delayClient.getTime(t)
    }
}