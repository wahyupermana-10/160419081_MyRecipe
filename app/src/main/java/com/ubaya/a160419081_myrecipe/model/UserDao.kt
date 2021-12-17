package com.ubaya.a160419081_myrecipe.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg user: User)

    @Query("SELECT * FROM user WHERE userId=:userId")
    suspend fun selectUserDetail(userId: Int):User

    @Query("SELECT * FROM user where email =:email AND password=:password")
    suspend fun selectUser(email:String, password: String):User

    @Query("UPDATE user SET active=0 WHERE email=:email")
    suspend fun updateOff(email: String)

    @Query("UPDATE user SET active=1 WHERE email=:email")
    suspend fun updateActive(email: String)

    @Delete
    suspend fun deleteUser(user: User)
}