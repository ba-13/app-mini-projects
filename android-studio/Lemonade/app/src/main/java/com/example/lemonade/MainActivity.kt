package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeAppPreview()
                }
            }
        }
    }
}

@Composable
fun ImageCaption(
    messageId: Int,
    imageId: Int,
    imageContentId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = imageId)
    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onImageClick,
            modifier = Modifier.width(240.dp),
            contentPadding = PaddingValues(20.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC3ECD2)
            )
        ) {
            Image(painter = image, contentDescription = stringResource(imageContentId))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(messageId), fontSize = 18.sp)
    }
}

@Composable
fun LemonadeApp() {
    var screenNumber by remember {
        mutableStateOf(0)
    }
    var numberClicks by remember {
        mutableStateOf(0)
    }

    var messageId: Int
    var imageId: Int
    var imageContentId: Int
    var onImageClick: () -> Unit
    when (screenNumber) {
        0 -> {
            messageId = R.string.select_lemon
            imageId = R.drawable.lemon_tree
            imageContentId = R.string.lemon_tree
            onImageClick = {
                screenNumber = 1
                numberClicks = (1..4).random()
            }
        }

        1 -> {
            messageId = R.string.squeeze_lemon
            imageId = R.drawable.lemon_squeeze
            imageContentId = R.string.lemon_squeeze
            onImageClick = {
                numberClicks -= 1
                if (numberClicks <= 0) {
                    screenNumber = 2
                }
            }
        }

        2 -> {
            messageId = R.string.drink_lemon
            imageId = R.drawable.lemon_drink
            imageContentId = R.string.lemon_drink
            onImageClick = {
                screenNumber = 3
            }
        }

        else -> {
            messageId = R.string.restart_lemon
            imageId = R.drawable.lemon_restart
            imageContentId = R.string.lemon_restart
            onImageClick = {
                screenNumber = 0
            }
        }
    }

    Column {
        Text(
            text = "Lemonade",
            modifier = Modifier
                .background(Color(0xFFFFDF00))
                .fillMaxWidth()
                .padding(25.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        ImageCaption(
            messageId = messageId,
            imageId = imageId,
            imageContentId = imageContentId,
            onImageClick = onImageClick,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}