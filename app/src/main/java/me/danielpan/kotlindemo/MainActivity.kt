package me.danielpan.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.danielpan.kotlindemo.kt.NavKtActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById(R.id.textView).setOnClickListener { startActivity(Intent(this@MainActivity, NavKtActivity::class.java)) }
    }
}
