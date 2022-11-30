package com.example.dicodingjetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicodingjetcoffee.model.*
import com.example.dicodingjetcoffee.ui.components.*
import com.example.dicodingjetcoffee.ui.theme.DicodingJetCoffeeTheme
import com.example.dicodingjetcoffee.ui.theme.LightGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DicodingJetCoffeeTheme {
                DicodingJetCoffeeApp()
            }
        }
    }
}

@Composable
fun DicodingJetCoffeeApp(){
    Scaffold(bottomBar = { BottomNav() }) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState()).padding(it)) {
            JetCoffeeBanner()
            HomeSection(
                title = stringResource(id = R.string.section_category),
                content = { CategoryRow() }
            )

            HomeSection(
                title = stringResource(id = R.string.section_favorite_menu),
                content = { MenuRow(listMenu = dummyMenu) }
            )

            HomeSection(
                title = stringResource(id = R.string.section_best_seller_menu),
                content = { MenuRow(listMenu = dummyBestSellerMenu) }
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DicodingJetCoffeePreview(){
    DicodingJetCoffeeTheme {
        DicodingJetCoffeeApp()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DicodingJetCoffeeTheme {
        Greeting("Android")
    }
}

@Composable
fun JetCoffeeBanner(bannerModifier: Modifier=Modifier){
    Box(modifier = bannerModifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(modifier: Modifier=Modifier){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ){
        items(dummyCategory, key = {it.textCategory}){ category->
            CategoryIcon(category = category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryRowPreview(){
    DicodingJetCoffeeTheme {
        CategoryRow()
    }
}

@Composable
fun MenuRow(
    modifier: Modifier=Modifier,
    listMenu:List<Menu>
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(listMenu, key = {it.title}){ menus-> 
            MenuItem(menu = menus)
        }

    }
}

@Composable
fun BottomNav(modifier: Modifier=Modifier){
    BottomNavigation(
        modifier=modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
    ) {
        val navigationItems= listOf<BottomNavOptions>(
            BottomNavOptions(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home
            ),

            BottomNavOptions(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),

            BottomNavOptions(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            )
        )

        navigationItems.map {
            BottomNavigationItem(
                selected = it.title==navigationItems[0].title,
                onClick = {  },
                unselectedContentColor = LightGray,
                icon = {
                    Image(imageVector = it.icon, contentDescription = it.title )
                },
                
                label = {
                    Text(text = it.title)
                }
            )
        }
    }

}


