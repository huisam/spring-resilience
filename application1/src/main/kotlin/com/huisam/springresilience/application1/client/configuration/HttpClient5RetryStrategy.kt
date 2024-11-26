package com.huisam.springresilience.application1.client.configuration

import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy
import org.apache.hc.core5.http.HttpRequest
import org.apache.hc.core5.http.protocol.HttpContext
import org.apache.hc.core5.util.TimeValue
import org.slf4j.LoggerFactory
import java.io.IOException
import kotlin.reflect.KClass

open class HttpClient5RetryStrategy(
    maxRetries: Int,
    defaultRetryInterval: TimeValue,
    clazzes: List<KClass<IOException>>,
    codes: List<Int>
): DefaultHttpRequestRetryStrategy(
    maxRetries, defaultRetryInterval, clazzes.map { it.java }, codes
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun retryRequest(
        request: HttpRequest,
        exception: IOException,
        execCount: Int,
        context: HttpContext
    ): Boolean {
        logger.info("retry from apache http client5 execCount=$execCount request=$request")

        return super.retryRequest(request, exception, execCount, context)
    }
}