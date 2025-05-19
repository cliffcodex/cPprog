package com.west.test

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.west.test.ui.theme.TestTheme
import com.west.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    external fun addTwoNumbers(a: Int, b: Int): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            val isDark = isSystemInDarkTheme()
            val view = LocalView.current

            SideEffect {
                WindowCompat.getInsetsController(window, view).apply {
                    isAppearanceLightStatusBars = !isDark // ✅ This controls status bar icon color
                }
                window.statusBarColor = android.graphics.Color.TRANSPARENT
            }

            TestTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                WindowInsets.safeDrawing
                                    .asPaddingValues()
                                    .calculateTopPadding()
                            )
                    ) {
                        AddTwoNumbersUI {
                            addTwoNumbers(it.first, it.second)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddTwoNumbersUI(onCalculate: (Pair<Int, Int>) -> Int) {
    var num1 by remember { mutableStateOf(3) }
    var num2 by remember { mutableStateOf(4) }
    val result = remember(num1, num2) { onCalculate(num1 to num2) }

    Column(Modifier.padding(16.dp)) {
        Text("Add Two Numbers using C++")
        Spacer(Modifier.height(8.dp))
        Text("Num1: $num1, Num2: $num2")
        Spacer(Modifier.height(8.dp))
        Text("Result from C++: $result")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTheme {
        AddTwoNumbersUI { it.first + it.second }
    }
}
