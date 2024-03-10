package com.example.cmpe277_app1

import android.content.Intent
import android.os.Bundle
import android.app.AlertDialog
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cmpe277_app1.ui.theme.CMPE277App1Theme

class MainActivity : ComponentActivity() {
    private var counter by mutableIntStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CMPE277App1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComponent(name = "Activity A") {
                        Button(onClick = {
                            startActivity(Intent(this, ActivityB::class.java).apply {
                                putExtra("counter", counter)
                            })
                        }) { Text(text = "Start Activity B") }
                        Button(onClick = {
                            startActivity(Intent(this, ActivityC::class.java).apply {
                                putExtra("counter", counter)
                            })
                        }) { Text(text = "Start Activity C") }
                        Button(onClick = {
                            AlertDialog.Builder(this)
                                .setTitle("Simple Dialog")
                                .setMessage("This is a simple Android dialog.")
                                .setPositiveButton("Okay") { dialog, _ -> dialog.dismiss() }
                                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                                .show()
                        }) { Text(text = "Start Dialog") }
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = "counter = $counter")
                        Spacer(modifier = Modifier.size(20.dp))
                        Button(onClick = {
                            finish()
                        }) { Text(text = "Close App") }
                    }
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        counter += 1
    }

    override fun onDestroy() {
        super.onDestroy()
        counter = 0
    }
}

@Composable
fun MainComponent(name: String, content: @Composable () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.size(30.dp))
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CMPE277App1Theme {
        MainComponent(name = "Activity Preview") {
            Button(onClick = {

            }) { Text(text = "Start Activity B") }
            Button(onClick = {

            }) { Text(text = "Start Activity C") }
            Button(onClick = {

            }) { Text(text = "Start Dialog") }
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "counter = 0")
            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = {

            }) { Text(text = "Close App") }
        }
    }
}