package com.hyzoka.kinomap.view.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hyzoka.kinomap.R

@Composable
fun ErrorRetrievingVoitureScreen(onRetryClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.error_retrieving_car), style = typography.subtitle1)

        Button(
            modifier = Modifier.padding(top = 18.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(horizontal = 20.dp),
            onClick = onRetryClicked
        ) {
            Text(
                text = stringResource(id = R.string.retry),
                style = typography.button,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}