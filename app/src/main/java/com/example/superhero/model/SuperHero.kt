package com.example.superhero.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SuperHero(
    @StringRes val superHeroName: Int,
    @StringRes val powers: Int,
    @DrawableRes val imageResourceId: Int,
)
