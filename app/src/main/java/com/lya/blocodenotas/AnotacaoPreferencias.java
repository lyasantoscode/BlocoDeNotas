package com.lya.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {
    //vamos ter dois métodos, um método para salvar e outro para recuperar

    //antes de desenvover o public, vamos criar um construtor

    private Context context;//vou criar agora um context
    private SharedPreferences preferences;// o share vai pegar as preferencias, vamos usar para recuperar uma anotação
    private SharedPreferences.Editor editor; //vai ser responsavel para salvar anotacao no edito

    private final String NOME_ARQUIVO = "anotação.preferencias";    //NOME_ARQUIVO é onde os dados serão salvos
    private final String CHAVE_NOME = "nome"; //vou criar uma chave para ele, constate é chave, preciso de uma chave para salvar as anotações, que recebe o nome

    public AnotacaoPreferencias(Context c) {//porque vou precisar instanciar na minha main activity depois

        this.context = c ;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0 );       // get precisa de dois parametros, uma string e dois number inteiro, onde nossos dados vao ficar salvo dentro de um arquivo, para isso precisamos criar esse arquivo
        editor = preferences.edit();  //editor é responsavel por salvar anotação


    }

    public void salvarAnotacao(String anotacao) {

        // e dentro do parentese vou criar uma chave
        editor.putString(CHAVE_NOME, anotacao);//vou salvar uma string, por isso defino putStrig, editor sign salvar
        editor.commit();  //commit sign executar

    }

    public String recuperarAnotacao() {//retornando uma string, nesse método

        return preferences.getString(CHAVE_NOME, "") ;    //retornar minhas preferencias, dai vou recuperar minhas string baseado na Chave que é o nome. Ai vamos definir um valor vazio, "vazio" , retornar o vazio

    }

}
