package com.huisam.springresilience.application2.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ProblemDetail
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(Throwable::class)
    fun handleException(e: Throwable): ErrorResponse {
        logger.error("Exception occurred", e)

        return ErrorCommonResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.message)
    }
}

data class ErrorCommonResponse(
    private val statusCode: HttpStatusCode,
    private val errorMessage: String?,
): ErrorResponse {
    override fun getStatusCode(): HttpStatusCode = statusCode

    override fun getBody(): ProblemDetail = ProblemDetail.forStatusAndDetail(statusCode, errorMessage)
}