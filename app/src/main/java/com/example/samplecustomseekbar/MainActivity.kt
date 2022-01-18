package com.example.samplecustomseekbar

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.samplecustomseekbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private val _answer: MutableLiveData<String> = MutableLiveData()
    val answer: LiveData<String> = _answer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.seekBar.progress = 1
        onProgressChange(1)
    }

    fun onProgressChange(progress: Int) {
        _answer.value = when (progress) {
            0 -> getString(R.string.yes)
            1 -> getString(R.string.neither)
            else -> getString(R.string.no)
        }
    }

    fun onClickedText(progress: Int) {
        binding.seekBar.progress = progress
    }
}