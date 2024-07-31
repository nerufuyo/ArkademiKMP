@file:OptIn(ExperimentalPagerApi::class)

package com.example.arkademikmp.android.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.arkademikmp.android.MyApplicationTheme
import com.example.arkademikmp.android.R
import com.example.arkademikmp.android.presentation.home.components.CardShow
import com.example.arkademikmp.android.presentation.home.components.ImageCarousel
import com.example.arkademikmp.android.presentation.home.components.MarketList
import com.example.arkademikmp.android.presentation.home.components.StatusBar
import com.google.accompanist.pager.ExperimentalPagerApi

data class Tab(val title: String, val icon: String)
data class GridItem(val id: Int, val iconResId: Int)
data class CardItem(
    val id: Int,
    val title: String,
    val description: String
)


class TabBarState {
    private val _tabs = mutableListOf<Tab>()
    val tabs: List<Tab> get() = _tabs

    var selectedTabIndex: Int = 0
        private set

    fun addTab(tab: Tab) {
        _tabs.add(tab)
    }

    fun selectTab(index: Int) {
        selectedTabIndex = index
    }
}

@Composable
fun TabBarComponent(tabBarState: TabBarState) {
    val selectedTabIndex = remember { mutableStateOf(tabBarState.selectedTabIndex) }

    TabRow(selectedTabIndex = selectedTabIndex.value, modifier = Modifier.fillMaxWidth()) {
        tabBarState.tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(tab.title, color = MaterialTheme.colorScheme.tertiary) },
                selected = selectedTabIndex.value == index,
                onClick = {
                    selectedTabIndex.value = index
                    tabBarState.selectTab(index)
                },
                icon = {
                    when (tab.title) {

                        "Tukar Voucher" -> Image(
                            painter = painterResource(id = R.drawable.voucher),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )

                        "Cek Sertifikat" -> Image(
                            painter = painterResource(id = R.drawable.certificate),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )

                        "Panduan Pelatihan" -> Image(
                            painter = painterResource(id = R.drawable.panduan),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )

                        else -> Image(
                            painter = painterResource(id = R.drawable.carousel_image),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun HomeScreen() {
    val tabBarState = remember {
        TabBarState().apply {
            addTab(Tab("Tukar Voucher", "voucher"))
            addTab(Tab("Cek Sertifikat", "certificate"))
            addTab(Tab("Panduan Pelatihan", "panduan"))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
    ) {
        StatusBar()
        TabBarComponent(tabBarState)
        ImageCarousel(
            images = listOf(
                "https://media.istockphoto.com/id/1127245421/id/foto/wanita-tangan-berdoa-untuk-berkat-dari-tuhan-pada-latar-belakang-matahari-terbenam.jpg?s=1024x1024&w=is&k=20&c=TUQx5y7a9vWn-E035IjoJhu61AiQbYHrl6EkIQX4UQM=",
                "https://media.istockphoto.com/id/1127245421/id/foto/wanita-tangan-berdoa-untuk-berkat-dari-tuhan-pada-latar-belakang-matahari-terbenam.jpg?s=1024x1024&w=is&k=20&c=TUQx5y7a9vWn-E035IjoJhu61AiQbYHrl6EkIQX4UQM=",
                "https://media.istockphoto.com/id/1127245421/id/foto/wanita-tangan-berdoa-untuk-berkat-dari-tuhan-pada-latar-belakang-matahari-terbenam.jpg?s=1024x1024&w=is&k=20&c=TUQx5y7a9vWn-E035IjoJhu61AiQbYHrl6EkIQX4UQM="
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        MarketList()
        CardShow()
    }
}
