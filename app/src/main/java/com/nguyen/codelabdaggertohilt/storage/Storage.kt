package com.nguyen.codelabdaggertohilt.storage

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String
}
