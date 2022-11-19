package com.example.dicodingjetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicodingjetcoffee.model.dummyCategory
import com.example.dicodingjetcoffee.ui.components.CategoryIcon
import com.example.dicodingjetcoffee.ui.components.SearchBar
import com.example.dicodingjetcoffee.ui.components.SectionText
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
    Column {
        JetCoffeeBanner()
        SectionText(title = stringResource(id = R.string.section_category))
        CategoryRow()
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
