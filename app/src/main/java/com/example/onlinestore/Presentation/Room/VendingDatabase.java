package com.example.onlinestore.Presentation.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.onlinestore.Presentation.Repository.Model.ProductDTO;
import com.example.onlinestore.Presentation.Room.DAO.ILikedProductDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ProductDTO.class}, version = 1, exportSchema = false)
public abstract class VendingDatabase extends RoomDatabase
{
    public abstract ILikedProductDAO productDao();

    private static volatile VendingDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    private static ExecutorService databaseWriteExecutor;

    public static VendingDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (VendingDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            VendingDatabase.class, "vending_store")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static ExecutorService getDatabaseWriteExecutor()
    {
        if (databaseWriteExecutor == null)
        {
            databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        }
        return databaseWriteExecutor;
    }
}
