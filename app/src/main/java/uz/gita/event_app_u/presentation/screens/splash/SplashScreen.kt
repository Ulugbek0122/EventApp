package uz.gita.event_app_u.presentation.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import uz.gita.event_app_u.R
import uz.gita.event_app_u.data.room.dao.EventDao
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {

    @Inject
    lateinit var dao: EventDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenStarted {
            delay(2000)
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToMainScreen())
        }
    }

}