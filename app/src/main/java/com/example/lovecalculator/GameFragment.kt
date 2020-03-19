package com.example.lovecalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.lovecalculator.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // val action = GameFragmentDirections.actionGameFragmentToResultFragment()
        // action.nameFirst = binding.firstNameEditText.text.toString()
        // action.nameSecond = binding.secondNameEditText.text.toString()

        binding.calculateButton.setOnClickListener {
            if ((binding.firstNameEditText.text.toString() == "") || (binding.secondNameEditText.text.toString() == "")) {
                bread("Please enter both names")
            } else {
                view.findNavController().navigate(
                    GameFragmentDirections.actionGameFragmentToResultFragment(
                        binding.firstNameEditText.text.toString(),
                        binding.secondNameEditText.text.toString()
                    )
                )
            }
        }
    }
}

