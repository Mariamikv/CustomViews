package com.example.customviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customviews.adapters.RocketAdapter
import com.example.customviews.animationactivities.*
import com.example.customviews.databinding.ActivityMainBinding
import com.example.customviews.models.RocketAnimationItem
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var animationItemsAdapter = RocketAdapter(this)
    private val animationData = mutableListOf<RocketAnimationItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setData()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = animationItemsAdapter
        }

        animationItemsAdapter.setData(animationData)
    }

    private fun setData(){
        animationData.add(RocketAnimationItem(getString(R.string.title_no_animation),
            Intent(this, NoAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_launch_rocket),
            Intent(this, LaunchRocketValueAnimatorAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_spin_rocket),
            Intent(this, RotateRocketAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_accelerate_rocket),
            Intent(this, AccelerateRocketAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_launch_rocket_objectanimator),
            Intent(this, LaunchRocketObjectAnimatorAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_color_animation),
            Intent(this, ColorAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.launch_spin),
            Intent(this, LaunchAndSpinAnimatorSetAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.launch_spin_viewpropertyanimator),
            Intent(this, LaunchAndSpinViewPropertyAnimatorAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_with_doge),
            Intent(this, FlyWithDogeAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_animation_events),
            Intent(this, WithListenerAnimationActivity::class.java)))

        animationData.add(RocketAnimationItem(getString(R.string.title_there_and_back),
            Intent(this, FlyThereAndBackAnimationActivity::class.java)))

    }
}