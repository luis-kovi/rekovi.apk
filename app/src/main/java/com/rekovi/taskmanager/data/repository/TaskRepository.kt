package com.rekovi.taskmanager.data.repository

import com.rekovi.taskmanager.domain.model.Card
import com.rekovi.taskmanager.domain.model.PermissionType
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getTasks(permissionType: PermissionType, userEmail: String): List<Card>
    fun observeTasksRealtime(permissionType: PermissionType, userEmail: String): Flow<List<Card>>
    suspend fun getTaskById(id: String): Card?
    fun getValidPhases(): List<String>
}

