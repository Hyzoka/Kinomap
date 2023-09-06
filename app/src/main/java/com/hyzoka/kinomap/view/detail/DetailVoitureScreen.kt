package com.hyzoka.kinomap.view.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hyzoka.kinomap.model.Voiture

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailVoitureScreen(voiture: Voiture, onBack :() -> Unit) {

    val sliderList = remember {
        mutableListOf(
            voiture.icon.url.left,
            voiture.icon.url.right,
        )
    }

    IconButton(
        onClick = { onBack() },
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Text(
                text = "${voiture.id} : ${voiture.name}",
                modifier = Modifier
                    .padding(bottom = 16.dp),
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )

        HorizontalPager(
            pageCount = sliderList.size,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        ) { page ->
            Box {
                Surface(
                    modifier = Modifier.fillMaxWidth().height(250.dp)
                ) {
                    AsyncImage(
                        model = sliderList[page],
                        modifier = Modifier.padding(8.dp),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}