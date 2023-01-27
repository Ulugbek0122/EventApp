package uz.gita.event_app_u.presentation.viewmodels

import kotlinx.coroutines.flow.SharedFlow
import uz.gita.event_app_u.data.room.entity.EventEntity


interface MainViewModel {

    val allEventData: SharedFlow<List<EventEntity>>

    fun itemClick(eventEntity: EventEntity)

    fun getAllEvents()


}