package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ScreenCourse()
            }
        }
    }
}

@Composable
fun ScreenCourse(){
    var courseName by remember { mutableStateOf("") }
    var courseDescription by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding().safeDrawingPadding().verticalScroll(
            rememberScrollState()
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier.weight(1f).background(Color(0XFF9900FF))
                .fillMaxWidth()
        ){
            Text(
            text = "SQLITE_Course",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(vertical = 16.dp),
            color = Color.White,
//            textAlign = Alignment.Center
            )
        }

        Column(
            modifier = Modifier.weight(3f).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditTextField(
                value = courseName,
                onValueChange = {
                    courseName = it
                },
                placeholder = "Course Name",
                modifier = Modifier.fillMaxWidth()
            )
            EditTextField(
                value = courseDescription,
                onValueChange = {
                    courseDescription=it
                },
                placeholder = "Course Desciption",
                modifier = Modifier.fillMaxWidth()
            )
            EditButton(
                modifier = Modifier.padding(16.dp).align(alignment = Alignment.End),
                content = "ADD COURSE"
            )
        }

        Column(
            modifier = Modifier.weight(9f).fillMaxWidth()
        ) {
            RowContent(subject = "English", shortDescription = "Level 1", modifier = Modifier)
        }
    }
}

@Composable
fun EditTextField(
    value: String,
    onValueChange: (String)->Unit,
    placeholder : String,
    modifier: Modifier
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder)
        },
        modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
    )
}

@Composable
fun EditButton(
    modifier: Modifier,
    content : String
) {
    Button(
        onClick = {

        },
        enabled = true,
        colors = ButtonColors(
            contentColor = Color.White,
            containerColor = Color(0XFF9900FF),
            disabledContentColor = Color(0XFF999999),
            disabledContainerColor = Color(0XFF6699CC)
        )
    ) {
        Text(text = content)
    }
}

@Composable
fun RowContent(subject:String, shortDescription:String, modifier: Modifier){
    Row (
        modifier = modifier.padding(top = 15.dp, bottom = 10.dp),

    ){
        Column() {
            Text(text = subject)
            Text(text = shortDescription)
        }
        EditButton(modifier = Modifier.padding(start = 30.dp), content = "UPDATE")
        EditButton(modifier = Modifier.padding(start = 50.dp), content = "SELECT")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        ScreenCourse()
    }
}