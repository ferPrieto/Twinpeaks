package prieto.fernando.twinpeaks.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.view_bottom.*
import prieto.fernando.presentation.MainViewModel
import prieto.fernando.spacex.R
import javax.inject.Inject

class InputTextFragment @Inject constructor(
    viewModelFactory: ViewModelProvider.Factory
) : Fragment(R.layout.fragment_input_text) {

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
        setViewModelObservers()
        setUpClickListeners()
    }

    private fun setupNavigation() {
        requireActivity().let { fragmentActivity ->
            (fragmentActivity as AppCompatActivity).setSupportActionBar(toolbar)
            NavigationUI.setupActionBarWithNavController(
                fragmentActivity, findNavController()
            )
        }
    }

    private fun setViewModelObservers() {
        viewModel.reversedText.observe(viewLifecycleOwner, Observer { setUpReversedStateViews(it) })
    }

    private fun setUpReversedStateViews(reversedText: String) {
        reversed_textview.text = reversedText
        changeVisibilityReversedFields(true)
        changeVisibilityOriginalFields(false)
    }

    private fun changeVisibilityReversedFields(show: Boolean) {
        reversed_textview.isVisible = show
        record_button.isVisible = show
    }

    private fun changeVisibilityOriginalFields(show: Boolean) {
        original_text.isVisible = show
        reverse_button.isVisible = show
    }

    private fun setUpClickListeners() {
        reverse_button.setOnClickListener {
            viewModel.reverseText(bottom_edit_text.text.toString())
        }

        record_button.setOnClickListener {

        }
    }
}
