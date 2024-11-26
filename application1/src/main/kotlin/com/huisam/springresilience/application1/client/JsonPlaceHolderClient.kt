package com.huisam.springresilience.application1.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(value = "json-place-holder-client", url = "https://jsonplaceholder.typicode.com")
interface JsonPlaceHolderClient {
    @GetMapping("/posts/{id}")
    fun getPost(@PathVariable id: Long): PostDto
}