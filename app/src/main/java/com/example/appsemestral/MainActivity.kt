package com.example.appsemestral

import android.graphics.Color
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import com.example.appsemestral.ui.WimApp
import com.example.appsemestral.ui.theme.AppSemestralTheme

/** FragmentActivity (y no ComponentActivity) porque BiometricPrompt la necesita. */
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )
        setContent {
            AppSemestralTheme {
                WimApp()
            }
        }
    }
}