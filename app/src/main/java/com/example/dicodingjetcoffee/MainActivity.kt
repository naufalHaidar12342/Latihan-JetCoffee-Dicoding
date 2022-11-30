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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicodingjetcoffee.model.Menu
import com.example.dicodingjetcoffee.model.dummyBestSellerMenu
import com.example.dicodingjetcoffee.model.dummyCategory
import com.example.dicodingjetcoffee.model.dummyMenu
import com.example.dicodingjetcoffee.ui.components.*
import com.example.dicodingjetcoffee.ui.theme.DicodingJetCoffeeTheme

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
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
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
