package com.example.pruebanavbar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebanavbar.databinding.ActivityHcursosBinding

class HcursosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHcursosBinding
    private lateinit var navBarFragment: FragmentNavBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHcursosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar los fragmentos
        navBarFragment = FragmentNavBar()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_navbar, navBarFragment)
            .replace(R.id.fragmentContenedor, FragmentContenedor())
            .commit()

        // Configurar OnClickListener para los ítems del BottomNavigationView
        binding.navmenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemHome -> {
                    Toast.makeText(this, "Home presionado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemRanking -> {
                    Toast.makeText(this, "Ranking presionado", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemLogros -> {
                    Toast.makeText(this, "Logros presionados", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.itemArticulos -> {
                    Toast.makeText(this, "Artículos presionados", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        // Escuchar los eventos del ciclo de vida de los fragmentos
        supportFragmentManager.registerFragmentLifecycleCallbacks(
            object : androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentViewCreated(
                    fm: androidx.fragment.app.FragmentManager,
                    f: androidx.fragment.app.Fragment,
                    v: View,
                    savedInstanceState: Bundle?
                ) {
                    if (f is FragmentNavBar) {
                        f.binding.imagelogo.setOnClickListener {
                            Toast.makeText(this@HcursosActivity, "Logo presionado", Toast.LENGTH_SHORT).show()
                        }
                        f.binding.imageProfile.setOnClickListener {
                            Toast.makeText(this@HcursosActivity, "Perfil presionado", Toast.LENGTH_SHORT).show()
                        }
                        f.binding.imagenotificaiones.setOnClickListener {
                            Toast.makeText(this@HcursosActivity, "Notificaciones presionadas", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }, true
        )
    }
}