package br.com.jeanramalho.celleptechcurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //pesquisar o que é uma função lambida

        //programar o comportamento da tela splash
        //abrir a loginActivity apos esperar 2,5 segundos
        Handler(Looper.getMainLooper()).postDelayed({

            // Criando uma intent e guardando ela em uma variavel
            //no Intent() é preciso passar 2 informções a tela que voce esta e a tela que voce quer ir
            val mIntent = Intent(this, LoginActivity::class.java)

            //iniciando a Intent ou seja intenção de troca de tela
            startActivity(mIntent)

            //desativar tela splash
            finish()
        }, 2500)

        }
}