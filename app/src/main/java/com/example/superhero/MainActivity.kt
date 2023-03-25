package com.example.superhero

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.data.HeroesRepository
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
    val heroes = HeroesRepository.heroes
    SuperHeroList(heroes = heroes)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SuperHeroList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            SuperHeroTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background) ) {
            itemsIndexed(heroes) {index,  item ->  
                HeroesItem(
                    hero = item,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp))
            }
//            items(heroes) {
//                HeroesItem(hero = it)
//            }
        }
    }
}

@Composable
fun SuperHeroTopAppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .size(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }

}

@Composable
fun HeroesItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = 2.dp,
        modifier = modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            HeroInformation(hero.nameRes,hero.descriptionRes )
            Spacer(modifier = Modifier.width(16.dp))
            HeroIcon(hero.imageRes)


        }

    }
}

@Composable
fun HeroInformation(@StringRes heroName: Int, @StringRes heroDescription: Int, modifier: Modifier = Modifier) {
    Column( ) {
        //Since heroName and heroDescription are on top of Surface their color defaults to onSurface
        //heroName Composable
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.h3,
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
    Box(
        modifier = modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Image(
            contentScale = ContentScale.FillWidth,
            painter = painterResource(heroIcon),
            contentDescription = null,
            alignment = Alignment.TopCenter,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroTheme {
        SuperHeroApp()

    }
}