package br.edu.ifsp.scl.sdm.petbook.model.dao

import androidx.room.*
import br.edu.ifsp.scl.sdm.petbook.model.entity.Appointment
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {
    @Insert
    suspend fun insert(appointment: Appointment): Long

    @Update
    suspend fun update(appointment: Appointment)

    @Delete
    suspend fun delete(appointment: Appointment)

    @Query("SELECT * FROM appointment ORDER BY appointmentDate DESC")
    fun getAllAppointments(): Flow<List<Appointment>>
}
