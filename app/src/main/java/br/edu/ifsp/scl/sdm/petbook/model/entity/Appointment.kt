package br.edu.ifsp.scl.sdm.petbook.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointment")
data class Appointment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val petName: String,
    val clinicName: String,
    val appointmentType: String,
    val appointmentDate: String,
    val description: String
)
