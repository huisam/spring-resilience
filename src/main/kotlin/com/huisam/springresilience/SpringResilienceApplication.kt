package com.huisam.springresilience

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringResilienceApplication

fun main(args: Array<String>) {
    runApplication<SpringResilienceApplication>(*args)
}
