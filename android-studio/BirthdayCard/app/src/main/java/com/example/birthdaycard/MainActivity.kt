package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Part 0
//                    GreetingImage(
//                        message = getString(R.string.happy_birthday_text),
//                        from = getString(
//                            R.string.signature_text
//                        )
//                    )
                    // Part 1
//                    LearnTogetherAppScreen(title = la_title, header = la_header, body = la_body)
                    // Part 2
//                    TaskManagerDoneScreen(
//                        imageId = R.drawable.ic_task_completed,
//                        mainMessage = tm_mainMessage,
//                        body = tm_body
//                    );
                    // Part 3
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier // use increments of 4.dp
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 110.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

//@Preview(showBackground = true, name = "BirthdayCard")
@Composable
fun BirthdayGreetingPreview() {
    BirthdayCardTheme {
        GreetingImage(message = "Happy Birthday Perry!", from = "From Sean")
    }
}

/**
 * Practice Compose: Learn Together App Screen
 */

const val la_title: String = "Jetpack Compose tutorial";
const val la_header =
    "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.";
const val la_body =
    "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app's UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI's construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.";

@Composable
fun LearnTogetherAppScreen(
    title: String,
    header: String,
    body: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.bg_compose_background);
    val body_modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp);
    Column() {
        Image(painter = image, contentDescription = null)
        Text(
            text = title,
            fontSize = 20.sp,
            modifier = body_modifier
        )
        Text(
            text = header,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = body_modifier
        )
        Text(
            text = body,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify,
            modifier = body_modifier.padding(bottom = 16.dp)
        )
    }
}

//@Preview(showBackground = true, name = "LearnTogether")
@Composable
fun LearnTogetherAppScreenPreview() {
    BirthdayCardTheme {
        LearnTogetherAppScreen(title = la_title, header = la_header, body = la_body)
    }
}

/**
 * Practice Compose: Task Manager Screen
 */

const val tm_mainMessage: String = "All tasks completed";
const val tm_body: String = "Nice work!";

@Composable
fun TaskManagerDoneScreen(
    imageId: Int,
    mainMessage: String,
    body: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = imageId);
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 220.dp)
        )
        Text(
            text = mainMessage,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 0.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = body,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(4.dp)
        )
    }
}

//@Preview(showBackground = true, name = "TaskManager")
@Composable
fun TaskManagerDoneScreenPreview() {
    BirthdayCardTheme {
        TaskManagerDoneScreen(
            imageId = R.drawable.ic_task_completed,
            mainMessage = tm_mainMessage,
            body = tm_body
        )
    }
}

/**
 * Practice Compose: Quadrant
 */

const val q1t = "Text composable";
const val q1b = "Displays text and follows the recommended Material Design guidelines.";
const val q2t = "Image composable";
const val q2b = "Creates a composable that lays out and draws a given Painter class object.";
const val q3t = "Row composable";
const val q3b = "A layout composable that places its children in a horizontal sequence.";
const val q4t = "Column composable";
const val q4b = "A layout composable that places its children in a vertical sequence.";

@Composable
fun QuadrantText(
    title: String,
    message: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            QuadrantText(
                title = q1t,
                message = q1b,
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            );
            QuadrantText(
                title = q2t,
                message = q2b,
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            );
        }
        Row(Modifier.weight(1f)) {
            QuadrantText(
                title = q3t,
                message = q3b,
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            );
            QuadrantText(
                title = q4t,
                message = q4b,
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            );
        }
    }
}

@Preview(showBackground = true, name = "LearnTogether")
@Composable
fun QuadrantPreview() {
    BirthdayCardTheme {
        Quadrants()
    }
}