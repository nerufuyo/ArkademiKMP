package com.example.arkademikmp.android.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.arkademikmp.android.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState


@ExperimentalPagerApi
@Composable
fun ImageCarousel(images: List<Any>, modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()
    Column(modifier = modifier) {
        HorizontalPager(
            count = images.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            val image = images[page]
            val painter = when (image) {
                is String -> rememberAsyncImagePainter(
                    model = image,
                    error = painterResource(id = R.drawable.carousel_image)
                )

                is Int -> painterResource(id = image)
                else -> throw IllegalArgumentException("Unsupported image type")
            }
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        PagerIndicator(pagerState = pagerState, count = images.size)
    }
}


@ExperimentalPagerApi
@Composable
fun PagerIndicator(pagerState: PagerState, count: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(count) { index ->
            val color = if (pagerState.currentPage == index) Color.Black else Color.Gray
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .padding(4.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}
