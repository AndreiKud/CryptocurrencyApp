package ru.andreikud.cryptocurrencyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import ru.andreikud.cryptocurrencyapp.ui.theme.CryptocurrencyAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}