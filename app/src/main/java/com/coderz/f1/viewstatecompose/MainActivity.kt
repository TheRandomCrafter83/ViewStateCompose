package com.coderz.f1.viewstatecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coderz.f1.viewstatecompose.ui.theme.ViewStateComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewStateComposeTheme {
                var textToDisplay:String by remember { mutableStateOf("Home") }
                var selectedItem:String by remember{mutableStateOf("home")}
                // A surface container using the 'background' color from the theme
                Scaffold(modifier=Modifier.fillMaxSize(),
                    backgroundColor = MaterialTheme.colors.background,
                    topBar = {StateActionBar()},
                    content = {
                        Column(modifier=Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            MainContent(textToDisplay,
                                modifier=Modifier.padding(8.dp)
                            )
                            Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                IconButton(onClick = {
                                    textToDisplay ="Home"
                                    selectedItem="home"
                                }){
                                    Icon(Icons.Filled.Home, contentDescription = "",
                                    tint = if(selectedItem=="home") MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
                                        )
                                }
                                Spacer(modifier=Modifier.width(8.dp))
                                IconButton(onClick = {
                                    textToDisplay ="Settings"
                                    selectedItem="settings"
                                }){
                                    Icon(Icons.Filled.Settings, contentDescription = "",
                                        tint = if(selectedItem=="settings") MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
                                    )
                                }
                                Spacer(modifier=Modifier.width(8.dp))
                                IconButton(onClick = {
                                    textToDisplay ="About"
                                    selectedItem="about"
                                }){
                                    Icon(Icons.Filled.Info, contentDescription = "",
                                        tint = if(selectedItem=="about") MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
                                    )
                                }
                            }
                        }
                        
                    }
                )
            }
        }
    }
}