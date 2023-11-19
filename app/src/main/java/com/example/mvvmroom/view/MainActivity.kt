package com.example.mvvmroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mvvmroom.data.ContactDatabase
import com.example.mvvmroom.R
import com.example.mvvmroom.data.contactEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database= ContactDatabase.getDatabase(this)

        getData()
        insertdata()

        GlobalScope.launch {
            database.contactDao().insertContact(contactEntity(0,"name 1",1234,0))
        }
    }



    private fun insertdata() {
        var num=0
        var number="name $num"
        GlobalScope.launch {
            database.contactDao().insertContact(contactEntity(0, number,1234,0))

        }
        num++
    }

    private fun getData() {
        database.contactDao().getContact().observe(this) {
            Log.d("Database_data", it.toString())
        }
    }
}