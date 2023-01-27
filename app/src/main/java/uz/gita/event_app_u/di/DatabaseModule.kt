package uz.gita.event_app_u.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.gita.event_app_u.data.room.AppDatabase
import uz.gita.event_app_u.data.room.dao.EventDao
import uz.gita.event_app_u.data.room.entity.EventEntity
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "event_data.db")
            .build()
    }

    @[Provides Singleton]
    fun provideEventDao(appDatabase: AppDatabase): EventDao =
        appDatabase.eventDao()

}