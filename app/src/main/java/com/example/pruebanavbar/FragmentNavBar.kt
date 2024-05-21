package com.example.pruebanavbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pruebanavbar.databinding.FragmentNavbarBinding


class FragmentNavBar : Fragment() {
    private var _binding: FragmentNavbarBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavbarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar OnClickListener para los elementos de la barra de navegación superior
        binding.imagelogo.setOnClickListener {
            Toast.makeText(activity, "Logo presionado", Toast.LENGTH_SHORT).show()
        }

        binding.imageProfile.setOnClickListener {
            Toast.makeText(activity, "Perfil presionado", Toast.LENGTH_SHORT).show()
        }

        binding.imagenotificaiones.setOnClickListener {
            Toast.makeText(activity, "Notificaciones presionadas", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}