package br.edu.ifsp.scl.sdm.petbook.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.scl.sdm.petbook.databinding.FragmentAppointmentBinding
import br.edu.ifsp.scl.sdm.petbook.viewmodel.AppointmentViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AppointmentFragment : Fragment() {
    private lateinit var fab: FragmentAppointmentBinding
    private val viewModel: AppointmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fab = FragmentAppointmentBinding.inflate(inflater, container, false)
        return fab.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.recyclerViewAppointments.layoutManager = LinearLayoutManager(requireContext())

        // Observando a lista de consultas usando collectLatest
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allAppointments.collectLatest { appointments ->
                // Configurar o adapter aqui.
            }
        }
    }
}
