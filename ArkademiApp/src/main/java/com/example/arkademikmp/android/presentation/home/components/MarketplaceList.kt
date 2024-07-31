package com.example.arkademikmp.android.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.arkademikmp.android.R
import com.example.arkademikmp.android.presentation.home.GridItem


@Composable
fun GridItemView(item: GridItem) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = item.iconResId),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
            )
        }
    }
}

@Composable
fun HorizontalGrid(items: List<GridItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(items.chunked(3)) { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowItems.forEach { item ->
                    GridItemView(item)
                }
                repeat(3 - rowItems.size) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(4.dp)
                            .border(0.5.dp, Color.Transparent)
                    )
                }
            }
        }
    }
}

@Composable
fun PreviewGridWithItems() {
    val items = listOf(
        GridItem(1, R.drawable.bukalapak),
        GridItem(2, R.drawable.tokopedia),
        GridItem(3, R.drawable.sekolahmu),
        GridItem(4, R.drawable.pintar),
        GridItem(4, R.drawable.pijar)
    )
    HorizontalGrid(items)
}

@Composable
fun MarketList() {
    Column {
        Text(
            text = "Beli di Marketplace Pilihanmu",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        PreviewGridWithItems()
    }
}