package newdev.merceariabarao.DatabaseRom.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import newdev.merceariabarao.DatabaseRom.Entities.ProdutoEntity;
import newdev.merceariabarao.DatabaseRom.Entities.UsuarioEntity;

@Dao
public interface UsuarioDao {
    @Insert
    public long[] insert(UsuarioEntity... entities);

    @Query("select * from usuario where email = :paramEmail + senha = :paramSenha")
    public UsuarioEntity selectByEmail(String paramEmail, String paramSenha);

}

