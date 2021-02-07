package com.varivoda.igor.zagonetke.ui.home

import android.graphics.Typeface
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.varivoda.igor.zagonetke.R
import com.varivoda.igor.zagonetke.ui.MainActivity
import com.varivoda.igor.zagonetke.ui.riddle.MY_TYPEFACE
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setActionBarText(getString(R.string.home_page))

        val typeface = Typeface.createFromAsset(context?.assets,
            MY_TYPEFACE
        )
        welcomeText.typeface = typeface

        easy.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLevelsFragment(0))
        }

        middle.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLevelsFragment(1))
        }

        difficult.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLevelsFragment(2))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.settings_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.settings){
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment())
            return true
        }
        return super.onOptionsItemSelected(item)

    }

}