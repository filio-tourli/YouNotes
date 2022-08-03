package com.filio.younotes.di

import android.app.Application
import androidx.room.Room
import com.filio.younotes.db.NotesDao
import com.filio.younotes.db.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): NotesDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            NotesDatabase::class.java,
            "notes_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

    @Provides
    @Singleton
    fun providePokemonDao(database: NotesDatabase): NotesDao {
        return database.getNotesDao()
    }
}