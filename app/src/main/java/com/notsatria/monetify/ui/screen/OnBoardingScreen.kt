package com.notsatria.monetify.ui.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.notsatria.monetify.R
import com.notsatria.monetify.ui.components.OnBoardingItem
import com.notsatria.monetify.ui.theme.Indigo
import com.notsatria.monetify.ui.theme.MonetifyTheme
import com.notsatria.monetify.utils.PreviewConfigs

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    val onBoardingData = listOf(
        OnBoardingData(
            image = R.drawable.onboarding_1,
            title = "Selamat Datang di Monetify",
            description = "Kelola pengeluaran dan pemasukan Anda dengan mudah. Pantau keuangan Anda dan buat keputusan finansial yang lebih baik."
        ),
        OnBoardingData(
            image = R.drawable.onboarding_2,
            title = "Catat Pengeluaran dengan Mudah",
            description = "Tambahkan pengeluaran harian Anda berdasarkan kategori tertentu. Pantau kemana uang Anda pergi setiap harinya."
        ),
        OnBoardingData(
            image = R.drawable.onboarding_3,
            title = "Analisis Keuangan Anda",
            description = "Lihat ringkasan bulanan, grafik pengeluaran dan pemasukan. Ambil kendali atas keuangan Anda dengan data yang akurat"
        )
    )

    val pagerState = rememberPagerState(pageCount = { onBoardingData.size })

    Surface(
        modifier = modifier.fillMaxSize(), color = Indigo,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(state = pagerState) { page ->
                OnBoardingItem(
                    image = onBoardingData[page].image,
                    title = onBoardingData[page].title,
                    description = onBoardingData[page].description
                )

            }
            Spacer(modifier = Modifier.height(36.dp))
            PageIndicator(
                pageCount = onBoardingData.size,
                currentPage = pagerState.currentPage,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier = Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 12.dp else 10.dp, label = "")
    Box(
        modifier = modifier
            .padding(3.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color.White else Color(0xA8373737))
    )
}

data class OnBoardingData(
    val image: Int,
    val title: String,
    val description: String
)

@PreviewConfigs.DevicePreviews
@Composable
fun OnBoardingScreenPreview() {
    MonetifyTheme {
        OnBoardingScreen()
    }
}