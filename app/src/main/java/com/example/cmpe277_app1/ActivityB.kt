package com.example.cmpe277_app1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cmpe277_app1.ui.theme.CMPE277App1Theme

//import com.example.cmpe277_app1.MainActivity.Companion.counter

class ActivityB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMPE277App1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComponent(name = "Activity B") {
                        Button(onClick = {
                            finish()
                        }) { Text(text = "Finish B") }
                    }
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        var counter = intent.getIntExtra("counter", 0)
        counter += 5
    }
}