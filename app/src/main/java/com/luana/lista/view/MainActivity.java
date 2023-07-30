package com.luana.lista.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luana.lista.R;
import com.luana.lista.controller.PessoaController;
import com.luana.lista.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    PessoaController controller;
    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    EditText editNome;
    EditText editSobrenome;
    EditText editCurso;
    EditText editTelefone;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        //Atribuir valores ao objetvo
        //Conforme template
        pessoa.setNome("Luana");
        pessoa.setSobreNome("Ferreira");
        pessoa.setCurso("Android");
        pessoa.setTelefone("11-999995555");

        outraPessoa = new Pessoa();
        outraPessoa.setNome("Lucas");
        outraPessoa.setSobreNome("Cruz");
        outraPessoa.setCurso("B.I");
        outraPessoa.setTelefone("16-999995544");

        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNome.setText(pessoa.getNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editCurso.setText(pessoa.getCurso());
        editTelefone.setText(pessoa.getTelefone());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNome.setText("");
                editSobrenome.setText("");
                editCurso.setText("");
                editTelefone.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setNome(editNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCurso(editCurso.getText().toString());
                pessoa.setTelefone(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " +pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("Nome ", pessoa.getNome());
                listaVip.putString("Sobrenome ", pessoa.getSobreNome());
                listaVip.putString("Curso ", pessoa.getCurso());
                listaVip.putString("Telefone ", pessoa.getTelefone());
                listaVip.apply();

                controller.salvar(pessoa);

            }
        });

  /*      dadosPessoa= "Priemeiro Nome: ";
        dadosPessoa += pessoa.getNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCurso();
        dadosPessoa+= " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefone();


        dadosOutraPessoa = "Priemeiro Nome: ";
        dadosOutraPessoa += outraPessoa.getNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa += " Curso Desejado: ";
        dadosOutraPessoa += outraPessoa.getCurso();
        dadosOutraPessoa += " Telefone de Contato: ";
        dadosOutraPessoa += outraPessoa.getTelefone();*/


        //Log.i("POOAndroid",pessoa.toString());
        //Log.i("POOAndroid",outraPessoa.toString());

    }
}