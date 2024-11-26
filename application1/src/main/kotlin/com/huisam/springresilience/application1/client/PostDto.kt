package com.huisam.springresilience.application1.client

data class PostDto(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
)