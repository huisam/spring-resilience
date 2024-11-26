package com.huisam.springresilience.application2.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/delay")
class DelayController {
    @GetMapping("/time")
    fun delay(
        @RequestParam t: Long
    ): DelayTimeDto {
        Thread.sleep(t)

        return DelayTimeDto("$t ms 만큼 delay 되었습니다.")
    }
}