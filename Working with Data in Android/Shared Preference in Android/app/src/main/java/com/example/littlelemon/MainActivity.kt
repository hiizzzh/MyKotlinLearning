package com.example.littlelemon

import android.content.Context
import android.os.Bundle
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
 private val tipMenuLiveDataField = MutableLiveData<Boolean>()
    private val sharedPreferences by lazy {
        getSharedPreferences("LittleLemon", MODE_PRIVATE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tipMenuLiveDataField.value = sharedPreferences.getBoolean("Tip", false)
        setContent {
            LittleLemonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        Text(text = "Add Tip?")
                        val selected = tipMenuLiveDataField.observeAsState(false)
                        Switch(checked = selected.value, onCheckedChange = {
                            sharedPreferences.edit(commit = true) {putBoolean("Tip", it) }
                            runOnUiThread {tipMenuLiveDataField.value= it }})

                    }
                }
            }
        }
    }
}


