package br.edu.ifsp.scl.sdm.petbook.model.repository

import br.edu.ifsp.scl.sdm.petbook.model.dao.AppointmentDao
import br.edu.ifsp.scl.sdm.petbook.model.entity.Appointment
import kotlinx.coroutines.flow.Flow

class AppointmentRepository(private val appointmentDao: AppointmentDao) {

    // Método para inserir uma nova consulta
    suspend fun insertAppointment(appointment: Appointment): Long {
        return appointmentDao.insert(appointment)
    }

    // Função para atualizar uma consulta existente
    suspend fun updateAppointment(appointment: Appointment) {
        appointmentDao.update(appointment)
    }

    // Função para deletar uma consulta
    suspend fun deleteAppointment(appointment: Appointment) {
        appointmentDao.delete(appointment)
    }

    // Método para recuperar todas as consultas, retornando como Flow
    fun getAllAppointments(): Flow<List<Appointment>> = appointmentDao.getAllAppointments()
}
