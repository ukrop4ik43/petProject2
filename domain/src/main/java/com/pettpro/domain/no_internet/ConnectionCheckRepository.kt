package com.pettpro.domain.no_internet

interface ConnectionCheckRepository {
    fun checkConnection(): Boolean
}