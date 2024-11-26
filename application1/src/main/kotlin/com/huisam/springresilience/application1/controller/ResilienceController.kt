package com.huisam.springresilience.application1.controller

import com.huisam.springresilience.application1.client.PostDto
import com.huisam.springresilience.application1.service.ResilienceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/resilience")
class ResilienceController(
    private val resilienceService: ResilienceService
) {
    @GetMapping("/post/retry")
    fun getPostRetry(
        @RequestParam id: Long,
    ): PostDto {
        return resilienceService.retry(id)
    }

    @GetMapping("/post/retryable")
    fun getPostRetryable(
        @RequestParam id: Long,
    ): PostDto {
        return resilienceService.retryable(id)
    }
}