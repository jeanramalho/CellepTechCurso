package br.com.jeanramalho.celleptechcurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // capturando as referencias para os componentes visuais por ID e jogando para uma variavel
        val edtLoginEmail : EditText = findViewById(R.id.edtLoginEmail)
        val edtLoginSenha : EditText =  findViewById(R.id.edtLoginSenha)
        val btnLoginEntrar : Button = findViewById(R.id.btnLoginEntrar)
        val btnLoginCadastrar : Button = findViewById(R.id.btnLoginCadastrar)

        //Criando o Listener(ouvinte) do botão
        btnLoginEntrar.setOnClickListener {
            //capturando os dados digitados pelos usuários
            val email = edtLoginEmail.text.toString().trim()
            val senha = edtLoginSenha.text.toString().trim()

            //validação dos campos
            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo Obrigatório"
                edtLoginEmail.requestFocus()
            }
            else if (senha.isEmpty()) {
                edtLoginSenha.error = "Campo Obrigatório"
                edtLoginSenha.requestFocus()
            }
            else {
                // Se os campos nao estão vazios

                //criando referencia ao sharedpreferences
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                val emailLogin = sharedPrefs.getString("EMAIL", "")

                val senhaLogin = sharedPrefs.getString("SENHA", "")

                //faça a verificação se email e senha estão corretos
                if(email == emailLogin && senha == senhaLogin) {
                    // exibindo uma mensagem usando toast
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()

                    // Abrir a MainActivity
                    val mIntent = Intent(this, MainActivity::class.java)

                    mIntent.putExtra("INTENT_EMAIL", email)

                    startActivity(mIntent)
                    finish()
                }
                else {
                    // apresentar uma mensagem de erros usando TOast
                    Toast.makeText(this, "Email ou Senha inválidos", Toast.LENGTH_LONG).show()
                }
            }
        }

        //Listener do botão Cadastrar
        btnLoginCadastrar.setOnClickListener{
            val mIntent = Intent(this, CadastroActivity::class.java)

            startActivity(mIntent)
        }

    }
}