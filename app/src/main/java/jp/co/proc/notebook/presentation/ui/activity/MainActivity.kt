package jp.co.proc.notebook.presentation.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.widget.TextView
import jp.co.proc.notebook.R
import jp.co.proc.notebook.presentation.ui.fragment.ExamFragment
import jp.co.proc.notebook.presentation.ui.fragment.InputFragment
import jp.co.proc.notebook.presentation.ui.fragment.SearchFragment

class MainActivity : BaseActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, InputFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, SearchFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, ExamFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.initializeInjector()
        this.applicationComponent?.inject(this)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, InputFragment())
            .commit()
    }
}
