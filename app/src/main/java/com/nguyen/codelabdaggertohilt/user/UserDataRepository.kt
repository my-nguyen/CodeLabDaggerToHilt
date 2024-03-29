package com.nguyen.codelabdaggertohilt.user

import javax.inject.Inject
import kotlin.random.Random

/**
 * UserDataRepository contains user-specific data such as username and unread notifications.
 *
 * This object will have a unique instance in a Component that is annotated with
 * @LoggedUserScope (i.e. only UserComponent in this case).
 */
class UserDataRepository @Inject constructor() {
    var username: String? = null
        private set

    var unreadNotifications: Int? = null
        private set

    init {
        unreadNotifications = randomInt()
    }

    fun refreshUnreadNotifications() {
        unreadNotifications = randomInt()
    }

    fun initData(username: String) {
        this.username = username
        unreadNotifications = randomInt()
    }

    fun cleanUp() {
        username = null
        unreadNotifications = -1
    }

    private fun randomInt(): Int {
        return Random.nextInt(until = 100)
    }
}
