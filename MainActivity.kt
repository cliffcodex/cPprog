package com.west.%

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.west.%.ui.theme.%

class MainActivity : ComponentActivity() {

    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("%")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }

            %(darkTheme = isDarkTheme) {
                Scaffold(
                    topBar = {
                        Column {
                            TopAppBar(
                                title = { Text("Project") },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surface,
                                    titleContentColor =
                                        MaterialTheme.colorScheme.tertiary
                                ),
                                actions = {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("Dark")
                                        Switch(
                                            checked = isDarkTheme,
                                            onCheckedChange = { isDarkTheme = it }
                                        )
                                    }
                                }

                            )
                            EdgeLine() // Line below TopAppBar
                        }
                    },
                    bottomBar = {
                        Column {
                            EdgeLine() // Line above BottomAppBar
                            BottomAppBar(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme
                                    .colorScheme.tertiary
                            ) {
                                Text(
                                    text = "© 2025 Project",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                ) { padding ->
                    Surface(modifier = Modifier.padding(padding)) {
                        val message = remember { stringFromJNI() }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Text(text = message)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EdgeLine() {
    val lineColor = MaterialTheme.colorScheme.outline.copy(alpha = 
        0.1f)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(lineColor)
    )
}
