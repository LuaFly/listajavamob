package com.luana.lista.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.luana.lista.model.Pessoa;
import com.luana.lista.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);

        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller","Controller iniciado");
        return super.toString();
    }

    public void criarSharedPreferences(){

    }
    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller","Salvo: " + pessoa.toString());

        listaVip.putString("Nome ", pessoa.getNome());
        listaVip.putString("Sobrenome ", pessoa.getSobreNome());
        listaVip.putString("Curso ", pessoa.getCurso());
        listaVip.putString("Telefone ", pessoa.getTelefone());
        listaVip.apply();

    }

    public Pessoa buscar(Pessoa pessoa){
        pessoa.setNome(preferences.getString("Nome", ""));
        pessoa.setSobreNome(preferences.getString("Sobrenome", ""));
        pessoa.setCurso(preferences.getString("Curso", ""));
        pessoa.setTelefone(preferences.getString("Telefone", ""));

        return pessoa;

    }

    public void limpar(){
                listaVip.clear();
                listaVip.apply();
    }

}
