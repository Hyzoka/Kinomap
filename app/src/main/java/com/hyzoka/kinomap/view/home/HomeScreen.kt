package com.hyzoka.kinomap.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hyzoka.kinomap.R
import com.hyzoka.kinomap.model.*

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(listVoiture: List<Voiture>, onNewsClicked: (Voiture) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.home_page_subtitle),
            style = typography.titleMedium
        )

        LazyColumn(
            modifier = Modifier
                .padding(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = listVoiture) {
                VoitureCardComponent(voiture = it, onClick = {
                    onNewsClicked(it)
                })
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(listVoiture = listOf(
            Voiture(
                id = 0,
                name = "4x4",
                training = null,
                icon = Icons(Anchor(33, 32), size = Size(23, 32), url = UrlImage("", "", ""))

            ),
            Voiture(
                id = 0,
                name = "4x4",
                training = null,
                icon = Icons(Anchor(33, 32), size = Size(23, 32), url = UrlImage("", "", ""))

            )
        ), onNewsClicked = {})
    }
}