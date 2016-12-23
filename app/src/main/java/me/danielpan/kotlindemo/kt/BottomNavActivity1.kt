package me.danielpan.kotlindemo.kt

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import me.danielpan.kotlindemo.R
import me.danielpan.kotlindemo.fragment.ContentFragment

class BottomNavActivity1 : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private var bottomNavigationView: BottomNavigationView? = null
    private var mHome: ContentFragment? = null
    private var mCollection: ContentFragment? = null
    private var mCommunity: ContentFragment? = null
    private var mNotification: ContentFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view) as BottomNavigationView
        bottomNavigationView!!.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.btm_nvg_home -> {
                showToast(R.string.bottom_nav_title_home)
                supportActionBar!!.setSubtitle(R.string.bottom_nav_title_home)
                if (mHome == null) {
                    mHome = ContentFragment.newInstance(0, supportActionBar!!.subtitle!!.toString())
                }
                fragmentTransaction.replace(R.id.content, mHome)
            }
            R.id.btm_nvg_collection -> {
                showToast(R.string.bottom_nav_title_collection)
                supportActionBar!!.setSubtitle(R.string.bottom_nav_title_collection)
                if (mCollection == null) {
                    mCollection = ContentFragment.newInstance(1, supportActionBar!!.subtitle!!.toString())
                }
                fragmentTransaction.replace(R.id.content, mCollection)
            }
            R.id.btm_nvg_community -> {
                showToast(R.string.bottom_nav_title_community)
                supportActionBar!!.setSubtitle(R.string.bottom_nav_title_community)
                if (mCommunity == null) {
                    mCommunity = ContentFragment.newInstance(2, supportActionBar!!.subtitle!!.toString())
                }
                fragmentTransaction.replace(R.id.content, mCommunity)
            }
            R.id.btm_nvg_notification -> {
                showToast(R.string.bottom_nav_title_notification)
                supportActionBar!!.setSubtitle(R.string.bottom_nav_title_notification)
                if (mNotification == null) {
                    mNotification = ContentFragment.newInstance(3, supportActionBar!!.subtitle!!.toString())
                }
                fragmentTransaction.replace(R.id.content, mNotification)
            }
        }
        fragmentTransaction.commit()
        return true
    }

    private fun showToast(@StringRes resId: Int) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }
}
