package uz.gita.event_app_u.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.event_app_u.domain.AppUseCase
import uz.gita.event_app_u.domain.impl.AppUseCaseImpl


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun bindAppUseCase(appUseCaseImpl: AppUseCaseImpl): AppUseCase

}