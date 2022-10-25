package com.example.aplicacion3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicacion3.databinding.ActivityMainNuevoBinding
import kotlinx.android.synthetic.main.activity_main_nuevo.*

class MainActivityNuevo : AppCompatActivity(){
    //vincular las vistas con MainActivity
    private lateinit var binding: ActivityMainNuevoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val parExtra = intent.extras
        /*var miVar = parExtra?.getString("valor1")
        binding.txtDato.text =miVar.toString()*/

        binding.txtGuardar.setOnClickListener{
            val txtNom = binding.IdIngreso.text
            val txtCue = binding.Idpassword.text


            val intento2 = Intent (this, MainActivity::class.java)
            intento2.putExtra("mensaje", "nuevo")
            intento2.putExtra("login", "${IdIngreso}")
            intento2.putExtra("password", "${Idpassword}")
            startActivity(intento2)
        }

    }
}