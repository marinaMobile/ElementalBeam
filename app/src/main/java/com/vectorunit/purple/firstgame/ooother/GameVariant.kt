package com.vectorunit.purple.firstgame.ooother

import android.os.Parcelable
import com.vectorunit.purple.R
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class GameVariant(
    val enemyName: String,
    val enemyLogo: Int,
    val iiimages: Int,
    val priceForPlay: Int
): Parcelable {

    class One(
        val _enemyName: String = "Super Princes",
        val _enemyLogo: Int = R.drawable.sasha_logo_1,
        val _imaaageAdd: Int = R.drawable.g1,
        val _priceForPlay: Int = 100
    ) : GameVariant(
        _enemyName, _enemyLogo, _imaaageAdd, _priceForPlay
    )

    class Tvo(
        val _enemyName: String = "Reachy man",
        val _enemyLogo: Int = R.drawable.sasha_logo_2,
        val _imaaageAdd: Int = R.drawable.g2,
        val _priceForPlay: Int = 150
    ) : GameVariant(
        _enemyName, _enemyLogo, _imaaageAdd, _priceForPlay
    )

    class Three(
        val _enemyName: String = "magic keeper",
        val _enemyLogo: Int = R.drawable.sasha_logo_3,
        val _imaaageAdd: Int = R.drawable.g3,
        val _priceForPlay: Int = 200
    ) : GameVariant(
        _enemyName, _enemyLogo, _imaaageAdd, _priceForPlay
    )

    class Four(

        val _enemyName: String = "enchanted lady",
        val _enemyLogo: Int = R.drawable.sasha_logo_4,
        val _imaaageAdd: Int = R.drawable.g4,
        val _priceForPlay: Int = 250
    ) : GameVariant(
        _enemyName, _enemyLogo, _imaaageAdd, _priceForPlay
    )

    class Five(

        val _enemyName: String = "undying pharaoh",
        val _enemyLogo: Int = R.drawable.sasha_logo_5,
        val _imaaageAdd: Int = R.drawable.g5,
        val _priceForPlay: Int = 300
    ) : GameVariant(
        _enemyName, _enemyLogo, _imaaageAdd, _priceForPlay
    )

}

