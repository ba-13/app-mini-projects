package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.ui.text.style.TextAlign
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        "Anshuman Barnwal",
                        "Android Developer Extraordinaire",
                        "+11 (123) 444 555 666",
                        "@AndroidDev",
                        "ba13@android.dev"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    description: String,
    phone: String,
    share: String,
    email: String,
    modifier: Modifier = Modifier
) {
    val androidLogo = painterResource(id = R.drawable.android_logo)
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFCCEDD3))
    ) {
        Column(
            Modifier
                .weight(7f)
                .fillMaxWidth(1f)
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = androidLogo,
                contentDescription = null,
                modifier = Modifier
                    .background(Color(0xFF1F2F3F))
                    .width(110.dp)
                    .height(110.dp)
            )
            Text(
                text = name,
                fontSize = 35.sp,
                modifier = modifier.padding(4.dp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light
            )
            Text(
                text = description,
                color = Color(0xFF349C25),
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
        }
        Column(
            Modifier
                .weight(2f)
                .fillMaxWidth(1f)
                .padding(35.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.Call,
                    contentDescription = null,
                    tint = Color(0xFF349C25),
                    modifier = modifier
                        .height(30.dp)
                        .padding(start = 4.dp, end = 16.dp)
                )
                Text(
                    text = phone,
                    textAlign = TextAlign.Left,
                    modifier = modifier.width(180.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.Share,
                    contentDescription = null,
                    tint = Color(0xFF349C25),
                    modifier = modifier
                        .height(30.dp)
                        .padding(start = 4.dp, end = 16.dp)
                )
                Text(
                    text = share,
                    textAlign = TextAlign.Left,
                    modifier = modifier.width(180.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = null,
                    tint = Color(0xFF349C25),
                    modifier = modifier
                        .height(30.dp)
                        .padding(start = 4.dp, end = 16.dp)
                )
                Text(
                    text = email,
                    textAlign = TextAlign.Left,
                    modifier = modifier.width(180.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting(
            "Anshuman Barnwal",
            "Android Developer Extraordinaire",
            "+11 (123) 444 555 666",
            "@AndroidDev",
            "jen.doe@android.dev"
        )
    }
}