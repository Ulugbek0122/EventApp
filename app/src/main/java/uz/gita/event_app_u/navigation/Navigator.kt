package uz.gita.event_app_u.navigation

import androidx.navigation.NavDirections


interface Navigator {

    suspend fun navigateTo(direction: NavDirections)

    suspend fun navigationUp()
}