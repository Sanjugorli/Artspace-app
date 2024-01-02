package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var currentStep by remember { mutableIntStateOf(1) }
    val imageResource = when (currentStep) {
        1->R.drawable.dove
        2->R.drawable.image2
        3->R.drawable.image3
        else->R.drawable.image4
    }
    val titleResource = when (currentStep) {
        1->R.string.title1
        2->R.string.title2
        3->R.string.title3
        else->R.string.title4
    }
    val yearResource = when (currentStep) {
        1->R.string.year1
        2->R.string.year2
        3->R.string.year3
        else->R.string.year4
    }
    Box{
        Column(
            modifier = Modifier
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = currentStep.toString(),
                modifier = Modifier
                    .padding(20.dp)
                    .width(650.dp)
                    .height(450.dp)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = titleResource),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 32.sp
                )
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .background(Color.White)
                ) {
                    Spacer(modifier = Modifier.padding(1.dp))
                    Text(
                        text = stringResource(id = yearResource),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontSize = 26.sp
                    )
                }
            }
            Spacer(
                modifier = Modifier.padding(20.dp)
            )
            Row(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .background(Color.White)
            ) {
                Button(
                    onClick = {
                        if (currentStep == 2) {
                            currentStep = 1
                        } else if (currentStep == 3) {
                            currentStep = 2
                        } else if (currentStep == 4) {
                            currentStep = 3
                        } else if (currentStep == 1){
                            currentStep = 1
                        } else {
                            currentStep = 1
                        }
                    }
                ) {
                    Text(
                        text = "Previous",
                        Modifier.width(60.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(
                    modifier = Modifier.padding(70.dp)
                )
                Button(
                    onClick = {
                        if (currentStep == 1) {
                            currentStep = 2
                        } else if (currentStep == 2) {
                            currentStep = 3
                        } else if (currentStep == 3) {
                            currentStep = 4
                        } else if (currentStep == 4) {
                            currentStep = 1
                        } else {
                            currentStep = 0
                        }
                    }
                ) {
                    Text(
                        text = "Next",
                        Modifier.width(60.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}