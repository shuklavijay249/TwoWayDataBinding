package com.example.twoway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.twoway.databinding.MainActivityBinding
import com.example.twoway.ui.theme.TwoWayTheme

class MainActivity : ComponentActivity() {
    private lateinit var databinding:MainActivityBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.main_activity)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        databinding.myViewModel = viewModel
        databinding.lifecycleOwner = this

    }
}
