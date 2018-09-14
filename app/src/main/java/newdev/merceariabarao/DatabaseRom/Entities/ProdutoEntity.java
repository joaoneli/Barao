package newdev.merceariabarao.DatabaseRom.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@ForeignKey(entity = CategoriaEntity.class, childColumns = "categoria", parentColumns = "codigo")
@Entity(tableName = "produto")
public class ProdutoEntity {

    @PrimaryKey
    private Long codigo;

    @ColumnInfo
    private String Nome;
    @ColumnInfo
    private String descricaoprod;


    @ColumnInfo
    private String unidadedemedida;

    @ColumnInfo
    private String valorun;

    @ColumnInfo
    private String qntdprod;

    @ColumnInfo
    private Long categoria;

    @ColumnInfo
    private Long VallTotalAllProd;

    @ColumnInfo
    private Long VallTotalCat;

    @ColumnInfo
    private Long VallTotalAllCat;
    @ColumnInfo
    private Long   somaAllValTot;




    public ProdutoEntity() {

    }

    public ProdutoEntity(Long codigo, String nome, String descricaoprod, String unidadedemedida, String valorun, String qntdprod, Long categoria, Long vallTotalAllProd, Long vallTotalCat, Long vallTotalAllCat, Long somaAllValTot) {
        this.codigo = codigo;
        Nome = nome;
        this.descricaoprod = descricaoprod;
        this.unidadedemedida = unidadedemedida;
        this.valorun = valorun;
        this.qntdprod = qntdprod;
        this.categoria = categoria;
        this.VallTotalAllProd = vallTotalAllProd;
        this.VallTotalCat = vallTotalCat;
        this.VallTotalAllCat = vallTotalAllCat;
        this.somaAllValTot = somaAllValTot;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricaoprod() {
        return descricaoprod;
    }

    public void setDescricaoprod(String descricaoprod) {
        this.descricaoprod = descricaoprod;
    }

    public String getUnidadedemedida() {
        return unidadedemedida;
    }

    public void setUnidadedemedida(String unidadedemedida) {
        this.unidadedemedida = unidadedemedida;
    }

    public String getValorun() {
        return valorun;
    }

    public void setValorun(String valorun) {
        this.valorun = valorun;
    }

    public String getQntdprod() {
        return qntdprod;
    }

    public void setQntdprod(String qntdprod) {
        this.qntdprod = qntdprod;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Long getVallTotalAllProd() {
        return VallTotalAllProd;
    }

    public void setVallTotalAllProd(Long vallTotalAllProd) {
        VallTotalAllProd = vallTotalAllProd;
    }

    public Long getVallTotalCat() {
        return VallTotalCat;
    }

    public void setVallTotalCat(Long vallTotalCat) {
        VallTotalCat = vallTotalCat;
    }

    public Long getVallTotalAllCat() {
        return VallTotalAllCat;
    }

    public void setVallTotalAllCat(Long vallTotalAllCat) {
        VallTotalAllCat = vallTotalAllCat;
    }

    public Long getSomaAllValTot() {
        return somaAllValTot;
    }

    public void setSomaAllValTot(Long somaAllValTot) {
        this.somaAllValTot = somaAllValTot;
    }
}



