package uz.gita.event_app_u.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.event_app_u.data.room.entity.EventEntity


interface AppRepository {

    suspend fun insertEventData(eventEntity: EventEntity)

    suspend fun updateEventData(eventEntity: EventEntity)

    fun getAllEvents(): Flow<List<EventEntity>>
}