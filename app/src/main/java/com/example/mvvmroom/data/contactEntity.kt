package com.example.mvvmroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactdetails")
data class contactEntity(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val contactnumber:Int,
    val isActive:Int
)
