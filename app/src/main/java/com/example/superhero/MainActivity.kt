package com.example.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.heroes
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
    SuperHeroList()
}

@Composable
fun SuperHeroList( modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background) ) {
        items(heroes) {
            HeroesItem(hero = it)
        }
    }
}

@Composable
fun HeroesItem(hero: Hero, modifier: Modifier = Modifier) {
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
            HeroInformation(hero.nameRes,hero.descriptionRes )
            Spacer(Modifier.weight(1f))
            HeroIcon(hero.imageRes)


        }

    }
}

@Composable
fun HeroInformation(@StringRes heroName: Int, @StringRes heroDescription: Int, modifier: Modifier = Modifier) {
    Column {
        //Since heroName and heroDescription are on top of Surface their color defaults to onSurface
        //heroName Composable
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.h2,
            modifier = modifier.padding(8.dp)
        )
        //heroDescription Composable
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.body1
        )

    }

}

@Composable
fun HeroIcon(@DrawableRes heroIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(heroIcon),
        contentDescription = null )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroTheme {
        SuperHeroApp()

    }
}