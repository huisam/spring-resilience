package com.huisam.springresilience.application1.retry

import com.huisam.springresilience.application1.retry.LogRetryListener
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.RetryListener
import org.springframework.retry.annotation.EnableRetry
import org.springframework.retry.support.MetricsRetryListener

@EnableRetry
@Configuration(proxyBeanMethods = false)
class RetryConfiguration {

    @Bean
    fun metricsRetryListener(
        meterRegistry: MeterRegistry
    ): RetryListener {
        return MetricsRetryListener(meterRegistry)
    }

    @Bean
    fun logRetryListener(): RetryListener = LogRetryListener()
}

