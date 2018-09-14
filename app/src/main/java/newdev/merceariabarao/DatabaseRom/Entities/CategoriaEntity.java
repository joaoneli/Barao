package newdev.merceariabarao.DatabaseRom.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "categoria")

public class CategoriaEntity {

    @PrimaryKey
    private Long codigo;

    @ColumnInfo
    private String nome;

    @ColumnInfo
    private String descricao;

    public CategoriaEntity(Long codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public CategoriaEntity() {

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return codigo + " " + nome;
    }
}
