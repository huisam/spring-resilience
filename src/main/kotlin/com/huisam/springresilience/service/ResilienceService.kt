package com.huisam.springresilience.service

import io.github.resilience4j.retry.annotation.Retry
import com.huisam.springresilience.client.JsonPlaceHolderClient
import com.huisam.springresilience.client.PostDto
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service
import java.io.IOException
import java.lang.Exception

@Service
class ResilienceService(
    private val jsonPlaceHolderClient: JsonPlaceHolderClient,
) {
    @Retryable(
        maxAttempts = 3,
        include = [IOException::class],
        backoff = Backoff(delay = 1000L, multiplier = 2.0, maxDelay = 5000L)
    )
    fun retryable(id: Long): PostDto {
        throwException(id)
    }

    @Recover
    fun getPost(id: Long, exception: Exception): PostDto {
        return jsonPlaceHolderClient.getPost(id)
    }

    @Retry(name = "post", fallbackMethod = "retryFallback")
    fun retry(id: Long): PostDto {
        throwException(id)
    }

    fun retryFallback(id: Long, throwable: Throwable): PostDto {
        return jsonPlaceHolderClient.getPost(id)
    }

    private fun throwException(id: Long): Nothing {
        when (id) {
            1L -> throw IOException("Fail")
            2L -> throw IllegalArgumentException("Wrong")
            else -> throw RuntimeException(IOException("other"))
        }
    }
}