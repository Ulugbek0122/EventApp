package uz.gita.event_app_u.presentation.screens.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.event_app_u.R
import uz.gita.event_app_u.databinding.ScreenMainBinding
import uz.gita.event_app_u.presentation.adapters.EventAdapter
import uz.gita.event_app_u.presentation.viewmodels.MainViewModel
import uz.gita.event_app_u.presentation.viewmodels.impl.MainViewModelImpl
import uz.gita.event_app_u.service.EventService


@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main) {


    private val viewBinding: ScreenMainBinding by viewBinding()

    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    private val adapter: EventAdapter by lazy {
        EventAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.listEvents.adapter = adapter
        viewModel.allEventData.onEach {
            adapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        adapter.setSwitchChangedListener {
            viewModel.itemClick(it)
        }

        val intent = Intent(requireContext(), EventService::class.java)
        requireActivity().startService(intent)

    }


}