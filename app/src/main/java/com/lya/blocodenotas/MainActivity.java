package com.lya.blocodenotas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //primeiro devemos definir o evento de click

        FloatingActionButton fbSalvar = findViewById(R.id.fb_salvar);
        editAnotacao = findViewById(R.id.editAnotacao);   // AQUI RECUPERO ID DEO BOTAO SALVAR

        preferencias = new AnotacaoPreferencias(getApplicationContext()); //dentro do parentese , pegue o contexto que passamos la na anotacaopreferencias

        fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textoRecuperado = editAnotacao.getText().toString(); // aqui se cria um STRING que vai recuperar o texto recuperado, onde recebe o editANotacao e dai vou capturar o que foi digitado com getText, e vou utilizar o metodo toString, onde converter esse texto recuperado para uma string

                //Agora vamos fazer uma validação, ou seja uma estrutura de condição
                //verificar se o texto esta vazio, se digitamos alguma coisa ou nao, por isso da condição

                if (textoRecuperado.equals("")) {   //obs: nao pode ter espaço entre parentese
                    // se meu texto recuperado for igual vazio, quero mostrar uma mensagem para o usuário

                    Toast.makeText(getApplicationContext(), "Preencha a anotação!", Toast.LENGTH_SHORT).show(); //mensagem que é um toast , pasando contexto e definir uma mensagem , preencha a anotação, e passar o Toast, definindo um tempo de mensagem como Lenght_short, ou seja vai aparecer em uma forma mais rapida, ou usar o metodo show(), para executar essa mensagem

                }else {

                    preferencias.salvarAnotacao(textoRecuperado); //se caso tiver alguma anotacao , salvar a anotacao, entao vou pegar meu texto recuperado
                    Toast.makeText(getApplicationContext(), "Anotação salva com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }

        });
        //Recuperar anotação , ou seja recuperar o que ja foi salvo

        String anotacao = preferencias.recuperarAnotacao();

        if(!anotacao.equals("")) { // se minha anotacao ela nao estiver vazio, utlizando negação, se anotacao nao estiver vazia, ou seja se tiver anotacao la, eu quero recuperar ela.

            editAnotacao.setText(anotacao); //usando editanot e vou setar o texto e passar propria anotacao que esta utilizando o metodo recuperar

        }

    }
}