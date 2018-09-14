package newdev.merceariabarao.DatabaseRom.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import newdev.merceariabarao.DatabaseRom.Entities.ProdutoEntity;
import newdev.merceariabarao.DatabaseRom.view_entity.produtocategoriaEntity;

@Dao
public interface ProdutoDao {
    @Insert
    public long[] insert(ProdutoEntity... entities);

    @Query("select * from produto order by upper(nome), upper(descricaoprod), upper(unidadedemedida), upper(valorun), upper(qntdprod), upper(categoria)")
    public List<ProdutoEntity> selectAll();

    @Query("select * from produto where codigo = :codigo")
    public ProdutoEntity selectByCodigo(Long codigo);

    @Delete
    public int delete(ProdutoEntity... entities);

    @Update
    public int update(ProdutoEntity... entities);

    @Query("select ifnull(max(codigo), 0) + 1 from produto")
    public Long getProximoCodigo();


  @Query("select qntdprod*valorun as VallTotalAllProd"+" from produto")
    public Long mult01();

    @Query("select sum(VallTotalAllProd) as somaAllValTot"+" from produto p")
    public Long Soma01();

}