package com.ProjetoFIBCombustivel

import android.graphics.Color
import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Toast
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color.GREEN as GREEN1
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao_calcular.setOnClickListener{

            if (valor_etanol.text.isBlank() || valor_gasolina.text.isBlank()) {
                text_resultado.text = ""
                text_resultado.setBackgroundColor(parseColor("#ffffff"))
                Toast.makeText(this@MainActivity,"Preencher os campos corretamente.",Toast.LENGTH_SHORT).show()
            } else {
                var indice = 0.7

                var etanol = valor_etanol.text.toString().toDouble()
                var gasolina = valor_gasolina.text.toString().toDouble()
                var calculo = gasolina * indice

                if (calculo > etanol) {
                    text_resultado.setBackgroundColor(parseColor("#009933"))
                    text_resultado.text="ABASTECER COM ETANOL"
                } else {
                    text_resultado.setBackgroundColor(parseColor("#cc0000"))
                    text_resultado.text = "ABASTECER COM GASOLINA"
                }
                Log.i("CALCULO",calculo.toString())
            }
        }
    }
}
