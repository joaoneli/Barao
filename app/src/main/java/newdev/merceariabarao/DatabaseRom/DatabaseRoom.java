package newdev.merceariabarao.DatabaseRom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import newdev.merceariabarao.DatabaseRom.Dao.CategoriaDao;
import newdev.merceariabarao.DatabaseRom.Dao.ProdutoDao;
import newdev.merceariabarao.DatabaseRom.Dao.UsuarioDao;
import newdev.merceariabarao.DatabaseRom.Entities.CategoriaEntity;
import newdev.merceariabarao.DatabaseRom.Entities.ProdutoEntity;
import newdev.merceariabarao.DatabaseRom.Entities.UsuarioEntity;
import newdev.merceariabarao.DatabaseRom.view_dao.produtocategoriaDao;

@Database(entities = {UsuarioEntity.class, CategoriaEntity.class,ProdutoEntity.class }, version = 15)
public abstract class DatabaseRoom extends RoomDatabase {
    private static final String DATABASE_NAME = "bancoDeDados";

    public abstract UsuarioDao usuarioDao();

    public abstract CategoriaDao categoriaDao();

    public abstract ProdutoDao produtoDao();

    public abstract produtocategoriaDao produtocategoriaDao();

    private static DatabaseRoom instance;

    public static DatabaseRoom getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, DatabaseRoom.class, DATABASE_NAME).build();

        return instance;
    }
}