package br.com.jeanramalho.celleptechcurso
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os ids dos componentes visuais
        val txvMainNome : TextView = findViewById(R.id.txvMainNome)
        val txvMainEmail : TextView = findViewById(R.id.txvMainEmail)
        val txvMainGenero : TextView = findViewById(R.id.txvMainGenero)
        val btnMainSair : Button = findViewById(R.id.btnMainSair)
        val btnMainSite : Button = findViewById(R.id.btnMainSite)

        // Recuperando o email passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        // Acessar o arquivo de Shared Preferences
        val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

        // Recuperar dados do arquivos de Shared Prefences
        val nome = sharedPrefs.getString("NOME", "Nome não encontrado")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "Gênero não encontrado")

        // Exibindo os dados no Text View
        txvMainNome.text = "$nome $sobrenome"
        txvMainEmail.text = email
        txvMainGenero.text = genero

        // Listener (Ouvinte) do botão Sair
        btnMainSair.setOnClickListener {

            //Criando e definindo o Alert Dialog (Caixa de diálogo)
            val alert = AlertDialog.Builder(this)
                    .setTitle("Atenção") // Ajustando o título
                    .setMessage("Deseja mesmo sair?") // Ajustando a mensagem
                    .setPositiveButton("Sair") {_, _ ->
                        // Abrindo a tela Login
                        val mIntent = Intent(this, LoginActivity::class.java)
                        startActivity(mIntent)

                        // Encerrando todas as telas da pilha
                        finishAffinity()
                    }
                    .setNeutralButton("Não") { _, _ ->
                        // Não queremos fazer nada
                    }
                    .setCancelable(true)

            alert.show()
        }

        // Listener (Ouvinte) do botão Site Cellep
        btnMainSite.setOnClickListener {
            // Abrindo a Web Activity (Versão uma linha)
            startActivity(Intent(this, WebActivity::class.java))
        }

    }
}