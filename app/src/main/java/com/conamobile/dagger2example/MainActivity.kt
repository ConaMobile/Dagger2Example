package com.conamobile.dagger2example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.conamobile.dagger2example.databinding.ActivityMainBinding
import com.conamobile.dagger2example.utils.UserResource
import com.conamobile.dagger2example.viewmodel.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    @Inject
    lateinit var userViewModel: UserViewModel

    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launch {
            userViewModel.getStateFlow().collect {
                when (it) {
                    is UserResource.Loading -> {}
                    is UserResource.Error -> {}
                    is UserResource.Success -> {
                        Log.d("@@@", "List: ${it.list}")
                    }
                }
            }
        }

    }

    override val coroutineContext: CoroutineContext
        get() = Job()
}