package com.bimabagaskhoro.apptest.ui.minigame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bimabagaskhoro.apptest.R
import com.bimabagaskhoro.apptest.databinding.FragmentBottomSheetBinding
import com.bimabagaskhoro.apptest.databinding.FragmentMiniGameBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MiniGameFragment : BottomSheetDialogFragment() {
    private lateinit var viewModel: MiniGameViewModel
    private var _binding: FragmentMiniGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMiniGameBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MiniGameViewModel::class.java)

        viewModel.setMiniGame()

        binding.apply {
            btnReload.setOnClickListener {
               viewModel.setMiniGame()
            }
        }

        viewModel.getMiniGame().observe(viewLifecycleOwner) {
            if (it != null){
                binding.apply {
                    tvFacts.text = it.fact
                    tvLength.text = it.length.toString()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}