package newdev.merceariabarao.Views;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import newdev.merceariabarao.DatabaseRom.Dao.ProdutoDao;
import newdev.merceariabarao.DatabaseRom.DatabaseRoom;
import newdev.merceariabarao.DatabaseRom.Entities.CategoriaEntity;
import newdev.merceariabarao.DatabaseRom.Entities.ProdutoEntity;
import newdev.merceariabarao.Dialogs.PopupInformacao;
import newdev.merceariabarao.R;

public class cadastroproduto extends AppCompatActivity {

    public Handler handler = new Handler();
    //
    public static final String EXTRA_CODIGO = "newdev.merceariabarao.codigo";
    private static final int CADASTRO_CATEGORIA = 1;
    //
    private TextView tvCodigo;
    private TextInputLayout tilNome;
    private TextInputLayout tilDescProduto;
    private TextInputLayout tilValun;
    private TextInputLayout tilQntdprod;
    private TextInputEditText etNome;
    private TextInputEditText etDescProd;
    private TextInputEditText etValun;
    private TextInputEditText etQntdprod;
    private Spinner spCategoria;
    private Spinner spUnidadeDeMedida;




    //
    private ProdutoEntity produtoEntity;
    private ProdutoDao produtoDao;
    private List<CategoriaEntity> categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastroproduto);

        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                Long codigo = getIntent().getLongExtra(EXTRA_CODIGO, -1);
                produtoEntity = DatabaseRoom.getInstance(getApplicationContext()).produtoDao().selectByCodigo(codigo);
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ininicializaComponentes();
                        carregaCategorias();
                        carregaUnidadeDeMedida();

                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case CADASTRO_CATEGORIA:
                carregaCategorias();
                break;
        }
    }

    private void ininicializaComponentes()
    {
        tvCodigo = findViewById(R.id.tvCodigo);
        tilNome = findViewById(R.id.tilNome);
        tilDescProduto = findViewById(R.id.tilDescProd);
        tilValun = findViewById(R.id.tilValun);
        tilQntdprod = findViewById(R.id.tilQntdprod);
        //
        etNome = findViewById(R.id.etNome);
        etDescProd = findViewById(R.id.etDescProd);
        spUnidadeDeMedida = findViewById(R.id.spUnidadeDeMedidas);
        etValun = findViewById(R.id.etValun);
        etQntdprod = findViewById(R.id.etQntdprod);
        spCategoria = findViewById(R.id.spCategoria);

        FloatingActionButton fabConfirmar = findViewById(R.id.fabConfirmar);
        FloatingActionButton fabDeletar = findViewById(R.id.fabDeletar);
        FloatingActionButton fabAdicionarCidade = findViewById(R.id.fabAdicionarCategoria);
        //
        etNome.addTextChangedListener(new TextWatcher()
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
            tilNome.setError(null);
        }
    });
        etDescProd.addTextChangedListener(new TextWatcher()
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
                tilDescProduto.setError(null);
            }
        });

        etValun.addTextChangedListener(new TextWatcher()
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
                tilValun.setError(null);
            }
        });
        etQntdprod.addTextChangedListener(new TextWatcher()
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
                tilQntdprod.setError(null);
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
        fabAdicionarCidade.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivityForResult(new Intent(cadastroproduto.this, cadastroCategoria.class), CADASTRO_CATEGORIA);
            }
        });

        //
        if (produtoEntity == null)
            fabDeletar.setEnabled(false);
        else
        {
            fabDeletar.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    deleteRegistroFechaTela();
                }
            });
        }
        //

    }

    private void carregaUnidadeDeMedida()
    {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.unidade_de_medida, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUnidadeDeMedida.setAdapter(adapter);
    }


    private void carregaCategorias()
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                final List<CategoriaEntity> categoriaEntities = DatabaseRoom.getInstance(getApplicationContext()).categoriaDao().selectAll();
                categoriaEntities.add(0, new CategoriaEntity(0l, "Categoria", "Descricao"));
                spCategoria.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        ArrayAdapter adapter = new ArrayAdapter(cadastroproduto.this, android.R.layout.simple_spinner_item, categoriaEntities);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spCategoria.setAdapter(adapter);
                        //
                        if (produtoEntity != null)
                            carregaValores();
                        else
                        {
                            AsyncTask.execute(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    final Long proximoCodigo = DatabaseRoom.getInstance(getApplicationContext()).produtoDao().getProximoCodigo();
                                    tvCodigo.post(new Runnable()
                                    {
                                        @Override
                                        public void run()
                                        {
                                            tvCodigo.setText(proximoCodigo.toString());
                                        }
                                    });
                                }
                            });

                        }
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

    private boolean validaTela()
    {
        boolean retorno = true;
        //
        if (etNome.getText().toString().trim().length() == 0)
        {
            tilNome.setError("Informe o nome do produto");
            retorno = false;
        }

        if (etDescProd.getText().toString().trim().length() == 0)
        {
            tilDescProduto.setError("Informe a descricao do produto");
            retorno = false;
        }

        if (spUnidadeDeMedida.getSelectedItemPosition() <= 0)
        {
            PopupInformacao.mostraMensagem(this, "Selecione a unidade de medida");
            retorno = false;
        }
        //

        if (etValun.getText().toString().trim().length() == 0)
        {
            tilValun.setError("Informe o valor do produto");
            retorno = false;
        }

        if (etQntdprod.getText().toString().trim().length() == 0)
        {
            tilQntdprod.setError("Informe a quantidade do produto");
            retorno = false;
        }
        //
        if (spCategoria.getSelectedItemPosition() <= 0)
        {
            PopupInformacao.mostraMensagem(this, "Selecione a categoria");
            retorno = false;
        }
        //
        return retorno;
    }

    private void salvaRegistroFechaTela()
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                ProdutoDao produtoDao = DatabaseRoom.getInstance(getApplicationContext()).produtoDao();
                if (produtoEntity == null)
                {
                    ProdutoEntity produtoEntity = new ProdutoEntity();
                    preencheValores(produtoEntity);
                    try
                    {
                        if (produtoDao.insert(produtoEntity) != null) {
                            fechaTelaSucesso();}
                        else
                            PopupInformacao.mostraMensagem(cadastroproduto.this, handler, "Erro ao inserir");
                    }
                    catch (SQLiteConstraintException ex)
                    {
                        PopupInformacao.mostraMensagem(cadastroproduto.this, handler, "Código já existe");
                    }
                }
                else
                {
                    preencheValores(produtoEntity);
                    if (produtoDao.update(produtoEntity) > 0){
                        fechaTelaSucesso();}
                    else
                        PopupInformacao.mostraMensagem(cadastroproduto.this, handler, "Erro ao inserir");
                }
            }
        });
    }

    private void deleteRegistroFechaTela()
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                if (DatabaseRoom.getInstance(getApplicationContext()).produtoDao().delete(produtoEntity) > 0)
                    fechaTelaSucesso();
                else
                    PopupInformacao.mostraMensagem(cadastroproduto.this, handler, "Erro ao remover");
            }
        });

    }

    private void preencheValores(ProdutoEntity produtoEntity)
    {
        produtoEntity.setCodigo(Long.valueOf(tvCodigo.getText().toString()));
        produtoEntity.setNome(etNome.getText().toString().trim());
        produtoEntity.setDescricaoprod(etDescProd.getText().toString().trim());
        produtoEntity.setUnidadedemedida(spUnidadeDeMedida.getSelectedItem().toString());
        produtoEntity.setValorun(etValun.getText().toString().trim());
        produtoEntity.setQntdprod(etQntdprod.getText().toString().trim());
        produtoEntity.setCategoria(((CategoriaEntity) spCategoria.getSelectedItem()).getCodigo());

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

    private void carregaValores()
    {
        tvCodigo.setText(produtoEntity.getCodigo().toString());
        etNome.setText(produtoEntity.getNome());
        etDescProd.setText(produtoEntity.getDescricaoprod());

        etValun.setText(produtoEntity.getValorun());
        etQntdprod.setText(produtoEntity.getQntdprod());


    /*    for (int i = 1; i < spUnidadeDeMedida.getCount(); i++)
        {
            if (((ProdutoEntity) spUnidadeDeMedida.getItemAtPosition(i)).getCodigo().equals(produtoEntity.getUnidadedemedida()))
            {
                spUnidadeDeMedida.setSelection(i, true);
            }
        }
*/
        for (int i = 1; i < spCategoria.getCount(); i++)
        {
            if (((CategoriaEntity) spCategoria.getItemAtPosition(i)).getCodigo().equals(produtoEntity.getCategoria()))
            {
                spCategoria.setSelection(i, true);
            }
        }
    }

}
