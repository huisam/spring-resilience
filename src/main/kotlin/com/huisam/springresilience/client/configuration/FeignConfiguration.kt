package com.huisam.springresilience.client.configuration

import io.micrometer.core.instrument.binder.httpcomponents.hc5.ObservationExecChainHandler
import io.micrometer.observation.ObservationRegistry
import org.apache.hc.core5.util.TimeValue
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.clientconfig.HttpClient5FeignConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableFeignClients(basePackages = ["com.huisam.springresilience.client"])
@Configuration(proxyBeanMethods = false)
class FeignConfiguration {
    @Bean
    fun httpClient5RetryStrategy() = HttpClient5RetryStrategy(
        1, TimeValue.ofMilliseconds(100), emptyList(), emptyList()
    )

    @Bean
    fun httpClientBuilderCustomizer(
        observationRegistry: ObservationRegistry,
        httpClient5RetryStrategy: HttpClient5RetryStrategy,
    ): HttpClient5FeignConfiguration.HttpClientBuilderCustomizer =
        HttpClient5FeignConfiguration.HttpClientBuilderCustomizer {
            it.setRetryStrategy(httpClient5RetryStrategy)
            it.addExecInterceptorLast("micrometer", ObservationExecChainHandler(observationRegistry))
        }
}
