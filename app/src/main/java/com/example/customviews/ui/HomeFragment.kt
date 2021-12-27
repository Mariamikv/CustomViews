package com.example.customviews.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customviews.R
import com.example.customviews.adapters.RocketAdapter
import com.example.customviews.databinding.FragmentHomeBinding
import com.example.customviews.interfaces.SetOnClickListener
import com.example.customviews.models.RocketAnimationItem
import com.example.customviews.utils.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var animationItemsAdapter: RocketAdapter
    private val animationData = mutableListOf<RocketAnimationItem>()
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        setData()

        animationItemsAdapter = RocketAdapter(object : SetOnClickListener{
            override fun setOnClickListener(intent: Int) {
                findNavController().navigate(intent)
            }

        })

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = animationItemsAdapter
        }

        animationItemsAdapter.setData(animationData)
    }

    private fun setData(){

        animationData.add(RocketAnimationItem(getString(R.string.title_launch_rocket),
            R.id.action_homeFragment_to_accelerateRocketAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.title_spin_rocket),
            R.id.action_homeFragment_to_colorAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.title_accelerate_rocket),
            R.id.action_homeFragment_to_flyThereAndBackAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.title_launch_rocket_objectanimator),
            R.id.action_homeFragment_to_flyWithDogeAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.title_color_animation),
            R.id.action_homeFragment_to_launchAndSApinViewAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.launch_spin),
            R.id.action_homeFragment_to_launchAndSpinAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.launch_spin_viewpropertyanimator),
            R.id.action_homeFragment_to_launchRockerObjectAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.title_with_doge),
            R.id.action_homeFragment_to_launchRocketValueAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.title_animation_events),
           R.id.action_homeFragment_to_rotateRocketAnimationFragment))

        animationData.add(RocketAnimationItem(getString(R.string.title_there_and_back),
            R.id.action_homeFragment_to_withListenerAnimationFragment))

    }
}