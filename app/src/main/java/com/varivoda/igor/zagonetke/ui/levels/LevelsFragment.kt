package com.varivoda.igor.zagonetke.ui.levels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.varivoda.igor.domain.model.RiddleEntry
import com.varivoda.igor.zagonetke.R
import com.varivoda.igor.zagonetke.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_levels.*
import kotlinx.android.synthetic.main.fragment_levels.view.*
import org.koin.android.viewmodel.ext.android.viewModel


class LevelsFragment : Fragment(), LevelAdapter.OnItemClickListener {

    private val levelsViewModel by viewModel<LevelsViewModel>()
    private var navController: NavController? = null
    private val levelAdapter = LevelAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_levels, container, false)
        setURecyclerView(root)
        return root
    }

    private fun setURecyclerView(root: View) {
        root.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = levelAdapter
            levelAdapter.setOnItemClickListener(this@LevelsFragment)
            setHasFixedSize(true)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = LevelsFragmentArgs.fromBundle(requireArguments()).difficulty
        when(id){
            0 -> (activity as MainActivity).setActionBarText(getString(R.string.levels_title0))
            1 -> (activity as MainActivity).setActionBarText(getString(R.string.levels_title1))
            2 -> (activity as MainActivity).setActionBarText(getString(R.string.levels_title2))
        }
        levelsViewModel.getPoints(id)
        levelsViewModel.data.observe(viewLifecycleOwner, Observer { pair ->
            if (pair == null) return@Observer

            levelAdapter.setItems(pair.first, pair.second.questionId)
            recyclerView.smoothScrollToPosition(pair.second.questionId - pair.first[0].id)
            levelsViewModel.data.value = null
        })
        navController = Navigation.findNavController(view)

    }

    override fun onResume() {
        super.onResume()
        println("provjera nakon povratka: ${LevelsFragmentArgs.fromBundle(requireArguments()).difficulty}")
        //levelsViewModel.getPoints()
    }

    override fun onClick(riddle: RiddleEntry) {
        navController?.navigate(LevelsFragmentDirections.actionLevelsFragmentToRiddleFragment(riddle.id))
    }
}