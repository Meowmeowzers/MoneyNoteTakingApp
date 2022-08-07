package com.test.moneynote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.test.moneynote.database.MainDatabase
import com.test.moneynote.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Money Note"

//        val shareViewModel: ShareViewModel by activityViewModels()
        val application = requireNotNull(this.activity).application
        val dataSource = MainDatabase.getInstance(application).databaseDao
        val viewModelFactory = ListViewModelFactory(dataSource, application)
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        val adapter = MainRecyclerAdapter(MainRecyclerListener {
//                id: Problems2, num: Int ->
//            viewModel.onChoiceClick(id, num)
        })

        binding.mainRecycler.adapter = adapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}