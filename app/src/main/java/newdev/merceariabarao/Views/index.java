package newdev.merceariabarao.Views;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import newdev.merceariabarao.Adapter.indexAdapter;
import newdev.merceariabarao.DatabaseRom.DatabaseRoom;
import newdev.merceariabarao.DatabaseRom.view_entity.produtocategoriaEntity;
import newdev.merceariabarao.R;

public class index extends AppCompatActivity {
    private ListView lvlinfo;
    private FloatingActionButton fabAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        inicializaComponentes();
    }

    private void inicializaComponentes() {
        lvlinfo = findViewById(R.id.lvinfo);
        fabAdicionar = findViewById(R.id.fabAdicionar);
        //
        fabAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(index.this, cadastroproduto.class));
            }
        });
        //
        lvlinfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                produtocategoriaEntity item = (produtocategoriaEntity) lvlinfo.getAdapter().getItem(position);
                Intent intent = new Intent(index.this, cadastroproduto.class);
                intent.putExtra(cadastroproduto.EXTRA_CODIGO, item.getCodigo());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    private void carregaLista() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                final List<produtocategoriaEntity> produtocategoriaEntities = DatabaseRoom.getInstance(getApplicationContext()).produtocategoriaDao().selectAll();
                lvlinfo.post(new Runnable() {
                    @Override
                    public void run() {
                        lvlinfo.setAdapter(new indexAdapter(index.this, produtocategoriaEntities));
                    }
                });
            }
        });


    }
}