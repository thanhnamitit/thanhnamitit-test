package xyz.thanhnamitit.test.screen

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import xyz.thanhnamitit.test.screen.home.HomeFragment

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, HomeFragment())
            .commit()
    }
}