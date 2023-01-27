package uz.gita.event_app_u.presentation.viewmodels.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.event_app_u.data.room.entity.EventEntity
import uz.gita.event_app_u.domain.AppUseCase
import uz.gita.event_app_u.navigation.Navigator
import uz.gita.event_app_u.presentation.viewmodels.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val appUseCase: AppUseCase,
    private val navigator: Navigator
) : MainViewModel, ViewModel() {

    override val allEventData = MutableSharedFlow<List<EventEntity>>(replay = 2, onBufferOverflow = BufferOverflow.DROP_LATEST)

    init {
        viewModelScope.launch {
            appUseCase.getAllEvents().collectLatest {
                allEventData.emit(it)
            }
        }
    }


    override fun itemClick(eventEntity: EventEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            appUseCase.updateEventData(eventEntity)
        }
    }

    override fun getAllEvents() {
        viewModelScope.launch {
            appUseCase.getAllEvents().collectLatest {
                allEventData.emit(it)
            }
        }
    }



}