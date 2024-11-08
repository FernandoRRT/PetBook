package br.edu.ifsp.scl.sdm.petbook.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.scl.sdm.petbook.model.entity.Appointment
import br.edu.ifsp.scl.sdm.petbook.model.repository.AppointmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppointmentViewModel(private val repository: AppointmentRepository) : ViewModel() {

    // Flow to collect and observe all appointments in the UI
    val allAppointments: Flow<List<Appointment>> = repository.getAllAppointments()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    // Function to add a new appointment
    fun addAppointment(appointment: Appointment) {
        viewModelScope.launch {
            repository.insertAppointment(appointment)
        }
    }

    // Function to update an existing appointment
    fun updateAppointment(appointment: Appointment) {
        viewModelScope.launch {
            repository.updateAppointment(appointment)
        }
    }

    // Function to delete an appointment
    fun deleteAppointment(appointment: Appointment) {
        viewModelScope.launch {
            repository.deleteAppointment(appointment)
        }
    }
}