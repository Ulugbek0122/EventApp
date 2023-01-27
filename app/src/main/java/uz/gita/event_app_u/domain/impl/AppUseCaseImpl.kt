package uz.gita.event_app_u.domain.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.event_app_u.data.room.entity.EventEntity
import uz.gita.event_app_u.domain.AppUseCase
import uz.gita.event_app_u.repository.AppRepository
import javax.inject.Inject

class AppUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : AppUseCase {

    override suspend fun insertEventData(eventEntity: EventEntity) =
        repository.insertEventData(eventEntity)

    override suspend fun updateEventData(eventEntity: EventEntity) =
        repository.updateEventData(eventEntity)

    override fun getAllEvents(): Flow<List<EventEntity>> =
        repository.getAllEvents()

}