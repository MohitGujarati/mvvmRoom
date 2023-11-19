package com.example.mvvmroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contactEntity: contactEntity)

    @Update
    suspend fun updateContact(contactEntity: contactEntity)

    @Delete
    suspend fun deleteContact(contactEntity: contactEntity)

    @Query("select * from contactdetails")
    fun getContact():LiveData<List<contactEntity>>

}