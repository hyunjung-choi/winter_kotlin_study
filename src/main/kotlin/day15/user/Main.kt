package org.hyunjung.day15.user

import kotlinx.coroutines.runBlocking
import org.hyunjung.day15.user.datasource.UserDataSourceImpl
import org.hyunjung.day15.user.repository.UserRepositoryImpl

fun main() = runBlocking {
    val userDataSource = UserDataSourceImpl()
    val repository = UserRepositoryImpl(userDataSource)

    try {
        val users = repository.getUsers()
        println("All Users:")
        users.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching users: ${e.message}")
    }

    try {
        val users = repository.getUsersTop10ByUserName()
        println("Users Top 10 by UserName:")
        users.forEach { println(it) }
    } catch (e: Exception) {
        println("Error fetching users: ${e.message}")
    }
}