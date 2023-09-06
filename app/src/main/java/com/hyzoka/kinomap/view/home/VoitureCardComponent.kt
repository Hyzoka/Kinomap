package com.hyzoka.kinomap.view

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.hyzoka.kinomap.R
import com.hyzoka.kinomap.model.*
import com.hyzoka.kinomap.ui.theme.palette

@ExperimentalMaterial3Api
@Composable
fun VoitureCardComponent(voiture: Voiture, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = palette.grey100,
        ),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = rememberAsyncImagePainter(
                    model = voiture.icon.url.size50x50,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.placeholder)
                ),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.size(96.dp),
            )
            Text(
                modifier = Modifier
                    .padding(start = 12.dp),
                text = voiture.name,
                style = typography.titleMedium
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun NewsCardComponentPreview() {
    MaterialTheme {
        VoitureCardComponent(
            voiture = Voiture(
                id = 0,
                name = "4x4",
                training = null,
                icon = Icons(Anchor(33, 32), size = Size(23, 32), url = UrlImage("", "", ""))

            ),
            onClick = {}
        )
    }
}