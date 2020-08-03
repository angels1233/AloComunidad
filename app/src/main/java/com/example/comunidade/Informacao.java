package com.example.comunidade;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.VideoView;

public class Informacao extends AppCompatActivity {
      CheckBox chek1,chek2,chek3,chek4,chek5,chek6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao);
        final WebView webview = findViewById(R.id.web);
        chek1 = findViewById(R.id.check_link1);
        chek2 = findViewById(R.id.check_link2);
        chek3 = findViewById(R.id.check_link3);
        chek4 = findViewById(R.id.check_link4);
        chek5 = findViewById(R.id.check_link5);
        chek6 = findViewById(R.id.check_link6);

        webview.loadUrl("https://www.bndes.gov.br/wps/portal/site/home/imprensa/noticias/conteudo/20130605_nailon");

        chek1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    chek2.setClickable(false);
                    chek3.setClickable(false);
                    chek4.setClickable(false);
                    chek5.setClickable(false);
                    chek6.setClickable(false);

                    webview.loadUrl("https://www.ecycle.com.br/postos/reciclagem.php");

                }else if(isChecked == false){
                    chek2.setClickable(true);
                    chek3.setClickable(true);
                    chek4.setClickable(true);
                    chek5.setClickable(true);
                    chek6.setClickable(true);
                }
            }
        });

        chek2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    chek1.setClickable(false);
                    chek3.setClickable(false);
                    chek4.setClickable(false);
                    chek5.setClickable(false);
                    chek6.setClickable(false);

                    webview.loadUrl("https://www.ecycle.com.br/2046-reciclagem");

                }else if(isChecked == false){
                    chek1.setClickable(true);
                    chek3.setClickable(true);
                    chek4.setClickable(true);
                    chek5.setClickable(true);
                    chek6.setClickable(true);
                }
            }
        });

        chek3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    chek2.setClickable(false);
                    chek1.setClickable(false);
                    chek4.setClickable(false);
                    chek5.setClickable(false);
                    chek6.setClickable(false);

                    webview.loadUrl("https://www12.senado.leg.br/noticias/materias/2016/04/19/sacola-plastica-e-uma-das-maiores-vilas-do-meio-ambiente");

                }else if(isChecked == false){
                    chek2.setClickable(true);
                    chek1.setClickable(true);
                    chek4.setClickable(true);
                    chek5.setClickable(true);
                    chek6.setClickable(true);
                }
            }
        });

        chek4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    chek2.setClickable(false);
                    chek3.setClickable(false);
                    chek1.setClickable(false);
                    chek5.setClickable(false);
                    chek6.setClickable(false);

                    webview.loadUrl("https://www.eosconsultores.com.br/5-consequencias-da-falta-de-saneamento-basico/");

                }else if(isChecked == false){
                    chek2.setClickable(true);
                    chek3.setClickable(true);
                    chek1.setClickable(true);
                    chek5.setClickable(true);
                    chek6.setClickable(true);
                }
            }
        });

        chek5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    chek2.setClickable(false);
                    chek3.setClickable(false);
                    chek4.setClickable(false);
                    chek1.setClickable(false);
                    chek6.setClickable(false);

                    webview.loadUrl("https://www.tuacasa.com.br/como-reutilizar-objetos-na-decoracao/");

                }else if(isChecked == false){
                    chek2.setClickable(true);
                    chek3.setClickable(true);
                    chek4.setClickable(true);
                    chek1.setClickable(true);
                    chek6.setClickable(true);
                }
            }
        });

        chek6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    chek2.setClickable(false);
                    chek3.setClickable(false);
                    chek4.setClickable(false);
                    chek5.setClickable(false);
                    chek1.setClickable(false);

                    webview.loadUrl("https://educador.brasilescola.uol.com.br/estrategias-ensino/reaproveitamento-dos-alimentos.htm");

                }else if(isChecked == false){
                    chek2.setClickable(true);
                    chek3.setClickable(true);
                    chek4.setClickable(true);
                    chek5.setClickable(true);
                    chek1.setClickable(true);
                }
            }
        });







    }
}