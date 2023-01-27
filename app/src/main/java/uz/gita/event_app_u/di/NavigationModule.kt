package uz.gita.event_app_u.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.event_app_u.navigation.NavigationDispatcher
import uz.gita.event_app_u.navigation.NavigationHandler
import uz.gita.event_app_u.navigation.Navigator
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun bindNavigator(navigationDispatcher: NavigationDispatcher): Navigator

    @[Binds Singleton]
    fun bindNavigationHandler(navigationDispatcher: NavigationDispatcher): NavigationHandler


}