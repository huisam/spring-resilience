package com.huisam.springresilience.client

data class PostDto(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
)