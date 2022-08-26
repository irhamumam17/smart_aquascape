package com.example.smart_aquascape.data

import com.example.smart_aquascape.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            if(username == "admin@gmail.com" && password == "rahasia"){
                val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Admin")
                return Result.Success(fakeUser)
            }
            return Result.Error(IOException("Username or password is wrong"))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}