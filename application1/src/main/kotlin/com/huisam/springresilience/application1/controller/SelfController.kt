package com.huisam.springresilience.application1.controller

import com.huisam.springresilience.application1.client.DelayTimeDto
import com.huisam.springresilience.application1.client.SelfClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/self"])
class SelfController(
    private val selfClient: SelfClient
) {
    @GetMapping("/time")
    fun delay(
        @RequestParam t: Int
    ): DelayTimeDto {
        return selfClient.getTime(t)
    }
}