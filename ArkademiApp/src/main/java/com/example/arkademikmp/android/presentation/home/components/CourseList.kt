package com.example.arkademikmp.android.presentation.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.arkademikmp.android.R
import com.example.arkademikmp.android.presentation.home.CardItem


@Composable
fun CardItemViews(item: CardItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.carousel_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = item.title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.description, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
fun HorizontalCardList(items: List<CardItem>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            CardItemViews(item = item)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CardShow() {
    val items = List(10) { index ->
        CardItem(
            id = index,
            title = "Item $index",
            description = "Description for item $index"
        )
    }
    HorizontalCardList(items = items)

}
