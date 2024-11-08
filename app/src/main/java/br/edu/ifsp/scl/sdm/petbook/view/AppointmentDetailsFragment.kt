package br.edu.ifsp.scl.sdm.petbook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import br.edu.ifsp.scl.sdm.petbook.R
import br.edu.ifsp.scl.sdm.petbook.databinding.FragmentAppointmentDetailsBinding
import br.edu.ifsp.scl.sdm.petbook.viewmodel.AppointmentViewModel

class AppointmentDetailsFragment : Fragment() {

    private lateinit var fadb: FragmentAppointmentDetailsBinding
    private val viewModel: AppointmentViewModel by viewModels()
    private val args: AppointmentDetailsFragmentArgs by navArgs() // Recebe o ID da consulta dos argumentos de navegação. A ser implementado.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fadb = FragmentAppointmentDetailsBinding.inflate(inflater, container, false)
        return fadb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observa e exibe os dados da consulta no layout. Precisa ser implementado.
        viewModel.getAppointmentById(args.appointmentId).observe(viewLifecycleOwner) { appointment ->
            appointment?.let {
                fadb.etPetName.setText(it.petName)
                fadb.etClinicName.setText(it.clinicName)
                fadb.spAppointmentType.setSelection(getAppointmentTypeIndex(it.appointmentType))
                fadb.etAppointmentDate.setText(it.date)
                fadb.etDescricaoAtendimento.setText(it.description)
            }
        }
    }

    private fun getAppointmentTypeIndex(type: String): Int {
        // Aqui, preciso implementar uma lógica para encontrar o índice do tipo de consulta no Spinner
        val types = resources.getStringArray(R.array.appointment_types)
        return types.indexOf(type)
    }
}
