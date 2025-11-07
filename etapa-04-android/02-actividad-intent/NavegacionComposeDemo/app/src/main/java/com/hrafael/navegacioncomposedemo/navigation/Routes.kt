package com.hrafael.navegacioncomposedemo.navigation

import android.net.Uri

sealed class Route(val path: String) {
    data object Home : Route("home")

    data object Detail : Route("detail/{id}?name={name}") {
        fun build(id: Int, name: String? = null): String {
            val safeName = name?.let { "name=${Uri.encode(it)}" } ?: "name="
            return "detail/$id?$safeName"
        }
    }

    data object Profile : Route("profile"){}

    data object ProfileSettings : Route("profileSettings/{userId}/{tab}") {
        fun build(userId: Int, tab: String): String {
            val safeTab = Uri.encode(tab)
            return "profileSettings/$userId/$safeTab"
        }
    }
}