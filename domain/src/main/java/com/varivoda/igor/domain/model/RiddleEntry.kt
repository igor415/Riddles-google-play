package com.varivoda.igor.domain.model


data class RiddleEntry(
    val id: Int,
    val question: String,
    val answer: String,
    val categoryId: Int
)