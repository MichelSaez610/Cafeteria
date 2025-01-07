package com.cafe.cafeteria.Models

data class PostresModel(val postre:String, val preu:Number) {
    override fun toString(): String {
        return postre
    }
}
