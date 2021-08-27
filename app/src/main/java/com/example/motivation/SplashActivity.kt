package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash.* // Metodo antigo

// Toda aplicação que tem AppCompatActivity, tem um contexto, que mais ou menos o que salva
class SplashActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) { // Se a barra for diferente de null
            supportActionBar!!.hide() // Esconda a barra
        }

        buttonSave.setOnClickListener(this) // Fique escutando o botão, quando for clicado etc
    }

    override fun onClick(view: View) { // Quando o usuario clicar no botão, execute handleSave()
        val id = view.id
        if(id == R.id.buttonSave){
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if (name != "") { // Se o que o user for diferente de vazio faça isso
            startActivity(Intent(this, MainActivity::class.java))
            // Intenção de iniciar uma nova Activity
            // Quando clicar vá para MainActivity, deixe o Java criar uma instancia
            // E colocar no Recycler do Android
        } else { // Criando um Toast para caso de error
            Toast.makeText(this, "Informe o seu nome!", Toast.LENGTH_SHORT).show()
        } // Se o user não informar nada, e a string for vazia, mostre um Toast para ele
    }
}