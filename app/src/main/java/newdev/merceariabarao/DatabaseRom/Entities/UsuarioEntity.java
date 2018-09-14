package newdev.merceariabarao.DatabaseRom.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "usuario")

public class UsuarioEntity {

    @PrimaryKey
    private Long codigo;

    @ColumnInfo
    private String email;

    @ColumnInfo
    private String senha;

    public UsuarioEntity()
    {
    }

    public UsuarioEntity(Long codigo, String email, String senha)
    {
        this.codigo = codigo;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioEntity(String email, String senha) {
        senha = senha;
        email = email;
    }


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}