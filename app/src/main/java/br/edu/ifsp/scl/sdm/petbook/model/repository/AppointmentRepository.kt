package br.edu.ifsp.scl.sdm.petbook.model.repository

import br.edu.ifsp.scl.sdm.petbook.model.dao.AppointmentDao
import br.edu.ifsp.scl.sdm.petbook.model.entity.Appointment
import kotlinx.coroutines.flow.Flow

class AppointmentRepository(private val appointmentDao: AppointmentDao) {

    // Método para inserir uma nova consulta
    suspend fun insert(appointment: Appointment): Long {
        return appointmentDao.insert(appointment)
    }

    // Método para atualizar uma consulta existente
    suspend fun update(appointment: Appointment) {
        appointmentDao.update(appointment)
    }

    // Método para excluir uma consulta
    suspend fun delete(appointment: Appointment) {
        appointmentDao.delete(appointment)
    }

    // Método para recuperar todas as consultas, retornando como Flow
    fun getAllAppointments(): Flow<List<Appointment>> {
        return appointmentDao.getAllAppointments()
    }
}
