package com.example.recycelview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recycelview.Adapter.UserAdapter
import com.example.recycelview.Models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var userList: ArrayList<User>
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        userList = ArrayList()
        userList.add(
                User(
                        "Og'ir atletika",
                        "https://storage.kun.uz/source/thumbnails/_medium/7/iJCmOnECh2ZrgJ8e56gSW9PJLWEd98By_medium.jpg"
                )
        )
        userList.add(
                User(
                        "Corona",
                        "https://storage.kun.uz/source/thumbnails/_medium/7/ziFE44kN-MpIsX_h3W1nllRPrfBjPOJA_medium.jpg"
                )
        )
        userList.add(
                User(
                        "Football",
                        "https://storage.kun.uz/source/thumbnails/_medium/7/r4OB7O9UG8RyqQi45J-K7JQmkCbgHe9G_medium.jpg"
                )
        )

        userAdapter = UserAdapter(object : UserAdapter.RvClick {
            override fun onClick(user: User) {
                Toast.makeText(this@MainActivity, "${user.name}", Toast.LENGTH_SHORT).show()
            }


        }, userList)
        rv.adapter = userAdapter


    }
}