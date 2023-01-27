package uz.gita.event_app_u.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.event_app_u.repository.AppRepository
import uz.gita.event_app_u.repository.impl.AppRepositoryImpl


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository

}