package br.edu.ifsp.scl.sdm.petbook.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifsp.scl.sdm.petbook.model.dao.AppointmentDao
import br.edu.ifsp.scl.sdm.petbook.model.entity.Appointment

@Database(entities = [Appointment::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAppointmentDao(): AppointmentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pet_appointment_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
