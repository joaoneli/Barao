package newdev.merceariabarao.Views;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import newdev.merceariabarao.DatabaseRom.Dao.UsuarioDao;
import newdev.merceariabarao.DatabaseRom.DatabaseRoom;
import newdev.merceariabarao.DatabaseRom.Entities.UsuarioEntity;
import newdev.merceariabarao.Dialogs.PopupInformacao;
import newdev.merceariabarao.R;

public class cadastrouser extends AppCompatActivity {

    private EditText editTextCadPass;
    private EditText editTextCadEmail;
    private EditText editTextCadConfEmail;
    public Handler handler = new Handler();

    private UsuarioEntity usuarioEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrouser);
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ininicializaComponentes();
                    }
                });
            }
        });
    }
    private void ininicializaComponentes()
    {
        editTextCadEmail = findViewById(R.id.editTextCadEmail);
        editTextCadConfEmail = findViewById(R.id.editTextCadConfEmail);
        editTextCadPass = findViewById(R.id.editTextCadPass);

        Button Cadastro = findViewById(R.id.buttonCad);


        editTextCadEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                editTextCadEmail.setError(null);
            }
        });
        editTextCadConfEmail.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                editTextCadConfEmail.setError(null);
            }
        });

        editTextCadPass.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                editTextCadPass.setError(null);
            }
        });

        Cadastro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                confirmaTela();
            }
        });

    }

    private void confirmaTela()
    {
        if (!validaTela())
            return;

        salvaRegistroFechaTela();
    }

    private boolean validaTela() {
        boolean retorno = true;
        //
        if (editTextCadEmail.getText().toString().trim().length() == 0) {
            editTextCadEmail.setError("Informe o email!");
            retorno = false;
        }

        if (editTextCadConfEmail.getText().toString().trim().length() == 0) {
            editTextCadConfEmail.setError("Digite o email!");
            retorno = false;
        }

        if (editTextCadPass.getText().toString().trim().length() == 0) {
            editTextCadPass.setError("Informe a senha");
            retorno = false;
        }

                     return retorno;

    }

    private void salvaRegistroFechaTela()
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                UsuarioDao usuarioDao = DatabaseRoom.getInstance(getApplicationContext()).usuarioDao();
                if (usuarioEntity == null)
                {
                    UsuarioEntity usuarioEntity = new UsuarioEntity();
                    try
                    {
                        if (usuarioDao.insert(usuarioEntity) != null)
                            fechaTelaSucesso();
                        else
                            PopupInformacao.mostraMensagem(cadastrouser.this, handler, "Erro ao inserir");
                    }
                    catch (SQLiteConstraintException ex)
                    {
                        PopupInformacao.mostraMensagem(cadastrouser.this, handler, "Código já existe");
                    }
                }

            }
        });
    }



    private void fechaTelaSucesso()
    {
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                finish();
            }
        });
        Toast.makeText(
                getApplicationContext(), //contexto da aplicação
                "Cadastro feito com sucesso!", //mensagem mostrada
                Toast.LENGTH_LONG //duração da mensagem
        ).show();
        Intent it = new Intent(cadastrouser.this, login.class);
        startActivity(it);

    }
}

