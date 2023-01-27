package uz.gita.event_app_u.repository.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.event_app_u.data.room.dao.EventDao
import uz.gita.event_app_u.data.room.entity.EventEntity
import uz.gita.event_app_u.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val eventDao: EventDao
): AppRepository {

    override suspend fun insertEventData(eventEntity: EventEntity) = eventDao.insertEvent(eventEntity)

    override suspend fun updateEventData(eventEntity: EventEntity) = eventDao.updateEvent(eventEntity)

    override fun getAllEvents(): Flow<List<EventEntity>> = eventDao.getAllEvents()
}