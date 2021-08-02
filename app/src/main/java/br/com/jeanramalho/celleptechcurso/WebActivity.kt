package br.com.jeanramalho.celleptechcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //referenciar o id do componente
        val wbvWeb : WebView = findViewById(R.id.wbvWeb)

        //habilitando a leitura de codigos javascript
        wbvWeb.settings.javaScriptEnabled = true

        //carregando uma pagina
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack")

        //Definindo o webview como cliente web padrão
        wbvWeb.webViewClient = WebViewClient()
    }
}