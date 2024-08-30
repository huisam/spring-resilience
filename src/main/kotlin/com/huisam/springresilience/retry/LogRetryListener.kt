package com.huisam.springresilience.retry

import org.slf4j.LoggerFactory
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.RetryListener

class LogRetryListener : RetryListener {
    private val logger = LoggerFactory.getLogger(LogRetryListener::class.java)

    override fun <T : Any?, E : Throwable?> open(context: RetryContext?, callback: RetryCallback<T, E>?): Boolean {
        return super.open(context, callback)
    }

    override fun <T : Any, E : Throwable> onError(
        context: RetryContext,
        callback: RetryCallback<T, E>,
        throwable: Throwable
    ) {
        logger.info("retry from $context")
    }
}