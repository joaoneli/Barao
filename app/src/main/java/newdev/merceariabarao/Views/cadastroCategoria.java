package newdev.merceariabarao.Views;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import newdev.merceariabarao.DatabaseRom.DatabaseRoom;
import newdev.merceariabarao.DatabaseRom.Entities.CategoriaEntity;
import newdev.merceariabarao.Dialogs.PopupInformacao;
import newdev.merceariabarao.R;

public class cadastroCategoria extends AppCompatActivity {

    private Handler handler = new Handler();
    private Context context = cadastroCategoria.this;
    //
    private TextView tvCodigoCat;
    private TextInputLayout tilNomeCat;
    private TextInputEditText etNomeCat;
    private TextInputLayout tilDescCat;
    private TextInputEditText etDescCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_categoria);
        ininicializaComponentes();
    }

    private void ininicializaComponentes()
    {
        tvCodigoCat = findViewById(R.id.tvCodigoCat);
        tilNomeCat = findViewById(R.id.tilNomeCat);
        etNomeCat = findViewById(R.id.etNomeCat);
        tilDescCat = findViewById(R.id.tilDescCat);
        etDescCat = findViewById(R.id.etDescCat);

        FloatingActionButton fabConfirmar = findViewById(R.id.fabConfirmar);
        //
        etNomeCat.addTextChangedListener(new TextWatcher()
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
                tilNomeCat.setError(null);
            }
        });

        etDescCat.addTextChangedListener(new TextWatcher()
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
                tilDescCat.setError(null);
            }
        });
        //
        fabConfirmar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                confirmaTela();
            }
        });
        //
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                final Long codigo = DatabaseRoom.getInstance(getApplicationContext()).categoriaDao().getProximoCodigo();
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        tvCodigoCat.setText(codigo.toString());
                    }
                });
            }
        });


    }
    private void confirmaTela()
    {
        if (!validaTela())
            return;

        salvaRegistroFechaTela();
    }

    private void salvaRegistroFechaTela()
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                CategoriaEntity entity = new CategoriaEntity();
                preencheValores(entity);
                try
                {
                    if (DatabaseRoom.getInstance(getApplicationContext()).categoriaDao().insert(entity) != null)
                        fechaTelaSucesso();
                    else
                        PopupInformacao.mostraMensagem(context, handler, "Erro ao inserir");
                }
                catch (SQLiteConstraintException ex)
                {
                    PopupInformacao.mostraMensagem(context, handler, "Código já existe");
                }
            }
        });
    }

    private void preencheValores(CategoriaEntity entity)
    {
        entity.setCodigo(Long.valueOf(tvCodigoCat.getText().toString()));
        entity.setNome(etNomeCat.getText().toString().trim());
        entity.setDescricao(etDescCat.getText().toString().trim());

    }

    private boolean validaTela()
    {
        boolean retorno = true;
        //
        if (etNomeCat.getText().toString().trim().length() == 0)
        {
            tilNomeCat.setError("Informe o nome da categoria");
            retorno = false;
        }
        //
        if (etDescCat.getText().toString().trim().length() == 0)
        {
            tilDescCat.setError("Informe a descricao da categoria");
            retorno = false;
        }

        return retorno;
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
    }
}

