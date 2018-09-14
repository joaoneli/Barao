package newdev.merceariabarao.Views;

import android.arch.persistence.room.util.TableInfo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import newdev.merceariabarao.DatabaseRom.Dao.UsuarioDao;
import newdev.merceariabarao.DatabaseRom.DatabaseRoom;
import newdev.merceariabarao.DatabaseRom.Entities.UsuarioEntity;
import newdev.merceariabarao.R;

public class login extends AppCompatActivity {
    private TextView cadastro;
    private TextView login;
    private UsuarioDao userdao;
    private UsuarioEntity usuarioEntity;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        cadastro = (TextView) findViewById(R.id.TVCadastro);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(login.this, cadastrouser.class);
                startActivity(myIntent);
            }

        });


        login = (TextView) findViewById(R.id.TVLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText SenhaUsuario = (EditText) findViewById(R.id.edtSenhaLog);
                EditText EmailUsuario = (EditText) findViewById(R.id.edtSenhaLog);

               String emailLogin =EmailUsuario.getText().toString();
               String senhaLogin = SenhaUsuario.getText().toString();


                Toast.makeText(
                        getApplicationContext(), //contexto da aplicação
                        "Logado com Sucesso!", //mensagem mostrada
                        Toast.LENGTH_LONG //duração da mensagem
                ).show();
                Intent intent = new Intent(login.this, index.class);
                startActivity(intent);

/*
                if (EmailUsuario == null || EmailUsuario.length() <= 0) {

                    //se não digitou nada notifica
                    //mostra a mesnagem
                    Toast.makeText(
                            getApplicationContext(), //contexto da aplicação
                            "Usuário Invalido!", //mensagem mostrada
                            Toast.LENGTH_LONG //duração da mensagem
                    ).show();
                } else if(SenhaUsuario == null || SenhaUsuario.length() <= 0) {

                    //se não digitou nada notifica
                    //mostra a mesnagem
                    Toast.makeText(
                            getApplicationContext(), //contexto da aplicação
                            "Senha Invalido!", //mensagem mostrada
                            Toast.LENGTH_LONG //duração da mensagem
                    ).show();
                }
                else {

                    if () {

                        Toast.makeText(
                                getApplicationContext(), //contexto da aplicação
                                "Logado com Sucesso!", //mensagem mostrada
                                Toast.LENGTH_LONG //duração da mensagem
                        ).show();
                        Intent intent = new Intent(login.this, index.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(
                                getApplicationContext(), //contexto da aplicação
                                "Erro!", //mensagem mostrada
                                Toast.LENGTH_LONG //duração da mensagem
                        ).show();
                    }
                  }*/
            }
            });
    }
}