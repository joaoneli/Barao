package newdev.merceariabarao.DatabaseRom.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import newdev.merceariabarao.DatabaseRom.Entities.CategoriaEntity;

@Dao
public interface CategoriaDao {
    @Insert
    public long[] insert(CategoriaEntity... entities);

    @Query("select * from categoria order by upper(nome),upper(descricao)")
    public List<CategoriaEntity> selectAll();

    @Query("select * from categoria order by upper(nome), upper(descricao)")
    public CategoriaEntity[] selectAllArray();

    @Query("select ifnull(max(codigo), 0) + 1 from categoria")
    public Long getProximoCodigo();
}
