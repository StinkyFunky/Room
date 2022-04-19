package com.example.myapplication.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentation.view.database.AppDatabase
import com.example.myapplication.presentation.view.database.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "myapp.db").allowMainThreadQueries().build()
        binding.apply {
            getBtn.setOnClickListener {

                val data = db.userDao().getAllUsers()
                for (user in data) {
                    textView.append("${user.id}, ${user.name}, ${user.age} \n")
                }
            }

            createBtn.setOnClickListener {
                val name = nameEditText.text.toString()
                val age = ageEditText.text.toString().toInt()

                GlobalScope.launch {
                    db.userDao().insertUser(User(name = name, age = age))
                }
            }

            deleteBtn.setOnClickListener {
                val id = idEditText.text.toString().toInt()
                GlobalScope.launch {
                    db.userDao().deleteUser(id)
                }
            }

            updateBtn.setOnClickListener {
                val id = idEditText.text.toString().toInt()
                val name = nameEditText.text.toString()
                val age = ageEditText.text.toString().toInt()

                db.userDao().updateUser(User(id, name, age))
            }
        }
    }
}
