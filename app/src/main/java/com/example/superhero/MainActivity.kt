package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.ui.theme.SuperHeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroApp() {

}

@Composable
fun HerosItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            //Other Composables go here
            /*TODO*/
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroTheme {
        SuperHeroApp()
    }
}