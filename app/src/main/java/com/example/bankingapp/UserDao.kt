package com.example.bankingapp

import androidx.room.*
import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM account_details")
    fun getAll():List<User>

    @Query("SELECT * FROM account_details WHERE account_number LIKE :accNo LIMIT 1")
    suspend fun findByAccNo(accNo:Int):User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)
}