package newdev.merceariabarao.DatabaseRom.view_entity;

import android.arch.persistence.room.ColumnInfo;

public class produtocategoriaEntity {

    @ColumnInfo
    private Long codigo;

    @ColumnInfo
    private String nome_produto;

    @ColumnInfo
    private String desc_produto_final;

    @ColumnInfo
    private String desc_cat;

    @ColumnInfo
    private String um;

    @ColumnInfo
    private String valuni;

    @ColumnInfo
    private String valtot;

    @ColumnInfo
    private String qntd;

    @ColumnInfo
    private String valtotall;

    @ColumnInfo
    private String valcat;

    @ColumnInfo
    private String valallcat;

    public produtocategoriaEntity()
    {

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDesc_produto_final() {
        return desc_produto_final;
    }

    public void setDesc_produto_final(String desc_produto) {
        this.desc_produto_final = desc_produto;
    }

    public String getDesc_cat() {
        return desc_cat;
    }

    public void setDesc_cat(String desc_cat) {
        this.desc_cat = desc_cat;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public String getValuni() {
        return valuni;
    }

    public void setValuni(String valuni) {
        this.valuni = valuni;
    }

    public String getValtot() {
        return valtot;
    }

    public void setValtot(String valtot) {
        this.valtot = valtot;
    }

    public String getQntd() {
        return qntd;
    }

    public void setQntd(String qntd) {
        this.qntd = qntd;
    }

    public String getValtotall() {
        return valtotall;
    }

    public void setValtotall(String valtotall) {
        this.valtotall = valtotall;
    }

    public String getValcat() {
        return valcat;
    }

    public void setValcat(String valcat) {
        this.valcat = valcat;
    }

    public String getValallcat() {
        return valallcat;
    }

    public void setValallcat(String valallcat) {
        this.valallcat = valallcat;
    }
}
