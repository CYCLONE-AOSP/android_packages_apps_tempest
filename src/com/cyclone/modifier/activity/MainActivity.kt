package com.cyclone.modifier.activity

import android.util.Log

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View

import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

import com.cyclone.modifier.fragment.*

import com.android.settings.R

open class MainActivity : CollapsingToolbarBaseActivity(),
        NavigationBarView.OnItemSelectedListener {

    private var mBottomNav: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val nav = View.inflate(this, R.layout.bottom_nav, null)
        val parent: CoordinatorLayout = findViewById(R.id.content_parent)
        val params = CoordinatorLayout.LayoutParams(
            CoordinatorLayout.LayoutParams.MATCH_PARENT,
            resources.getDimensionPixelSize(R.dimen.bottom_nav_height)
        )
        params.gravity = Gravity.BOTTOM
        nav.layoutParams = params
        parent.addView(nav)
        parent.setPadding(0, 0, 0,
            resources.getDimensionPixelSize(R.dimen.bottom_nav_height))
        mBottomNav = findViewById(R.id.bottom_navigation)
        mBottomNav!!.setOnItemSelectedListener(this)
        switchFragment(ThemesFragment(), "debug")
    }

    private fun switchFragment(fragment: Fragment, newTitle: CharSequence) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit()
        title = newTitle
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val title = item.title
        when(item.itemId) {
            // TODO: Add other fragments
            R.id.item_themes -> switchFragment(ThemesFragment(), title)
            R.id.item_qs -> switchFragment(ThemesFragment(), title)
            R.id.item_statusbar -> switchFragment(ThemesFragment(), title)
            R.id.item_extras -> switchFragment(ThemesFragment(), title)
        }
        return true
    }
}
