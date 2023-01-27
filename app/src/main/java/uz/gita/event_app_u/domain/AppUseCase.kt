package uz.gita.event_app_u.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.event_app_u.data.room.entity.EventEntity


interface AppUseCase {

    suspend fun insertEventData(eventEntity: EventEntity)

    suspend fun updateEventData(eventEntity: EventEntity)

    fun getAllEvents(): Flow<List<EventEntity>>

}