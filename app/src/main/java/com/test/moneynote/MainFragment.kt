package com.test.moneynote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
//        val application = requireNotNull(this.activity).application
//        val dataSource = QuizDatabase.getInstance(application).quizSetDatabaseDao
//        val viewModelFactory = TakeQuizViewModelFactory(dataSource, application, shareViewModel.id)
//        val viewModel =
//            ViewModelProvider(this, viewModelFactory)[TakeQuizViewModel::class.java]
//        binding.lifecycleOwner = viewLifecycleOwner
//        binding.viewModel = viewModel

//        val adapter = TakeQuizAdapter(TakeQuizListener { id: Problems2, num: Int ->
//            viewModel.onChoiceClick(id, num)
//        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}