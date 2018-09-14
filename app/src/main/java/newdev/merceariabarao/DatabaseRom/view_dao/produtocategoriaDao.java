package newdev.merceariabarao.DatabaseRom.view_dao;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import newdev.merceariabarao.DatabaseRom.view_entity.produtocategoriaEntity;

@Dao
public interface produtocategoriaDao {

    @Query(" select  p.codigo,p.Nome as nome_produto, p.descricaoprod as desc_prod_final, c.descricao as desc_cat, p.unidadedemedida as um , p.valorun as valuni,p.qntdprod as qntd, p.qntdprod*p.valorun as valtot,p.somaAllValTot as valtotall " +
            " from produto p, categoria c" +
            " where p.categoria = c.codigo" +
            " order by upper(p.nome),upper(p.descricaoprod)")
    public List<produtocategoriaEntity> selectAll();

}


