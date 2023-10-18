package com.example.countertracking.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    CounterTracking()
                }
            }
                }
            }
        }


@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Modifier.background(Color.Transparent)
            CounterTracking()
    }
}

@Composable
fun CounterTracking() {
    var displayText = remember { mutableStateOf("0")}

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (modifier = Modifier
            .height(80.dp)
            .width(50.dp)){
            CountDisplay(displayText)
        }
        Row() {
            Column() {
                FirstButton(displayText)
            }
            Column {
                SecondButton(displayText)
            }
        }
    }
}

@Composable
fun CountDisplay (display: MutableState<String>) {
    Text(text = display.value,
        modifier = Modifier
            .height(200.dp)
            .padding(10.dp)
            .fillMaxWidth(),
            fontSize = 40.sp, fontWeight = FontWeight.ExtraBold)
}

@Composable
fun FirstButton(display: MutableState<String>) {
    Button(modifier = Modifier
        .background(Color.White)
        .height(100.dp)
        .width(120.dp)
        .padding(4.dp), onClick = {
        val currentCount = display.value.toInt()
        display.value = (currentCount + 1).toString()
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
    ) {
        Text(text = "Up",
            fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SecondButton(display: MutableState<String>) {
    Button(modifier = Modifier
        .background(Color.White)
        .height(100.dp)
        .width(120.dp)
        .padding(4.dp), onClick = {
        val currentCount = display.value.toInt()
        display.value = (currentCount - 1).toString()
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
    ) {
        Text(text = "Down",  fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}

