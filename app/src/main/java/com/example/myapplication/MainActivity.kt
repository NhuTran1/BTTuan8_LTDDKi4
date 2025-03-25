package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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
        modifier = Modifier.fillMaxSize().statusBarsPadding().safeDrawingPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier.weight(1f).background(Color(0XFF9900FF))
                .fillMaxWidth()
        ){
            Text(
            text = "SQLITE_Course",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(vertical = 10.dp),
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
                modifier = Modifier.fillMaxWidth(),
                keyboardOption = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )
            )
            EditTextField(
                value = courseDescription,
                onValueChange = {
                    courseDescription=it
                },
                placeholder = "Course Desciption",
                modifier = Modifier.fillMaxWidth(),
                keyboardOption = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                )
            )
            EditButton(
                modifier = Modifier.padding(7.dp).align(alignment = Alignment.End),
                content = "ADD COURSE"
            )
        }

        Column(
            modifier = Modifier.weight(5f).fillMaxWidth()
        ) {
           LazyColumnExample()
        }
    }
}

@Composable
fun EditTextField(
    value: String,
    onValueChange: (String)->Unit,
    placeholder : String,
    modifier: Modifier,
    keyboardOption : KeyboardOptions
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder)
        },
        modifier = modifier.padding(top = 7.dp, bottom = 10.dp),
        keyboardOptions = keyboardOption
//        colors = androidx.compose.material3.TextFieldDefaults(Color.White)
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
fun RowContent(subject: String, shortDescription: String, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()  // Đảm bảo Row chiếm toàn bộ chiều rộng
            .padding()
            ,
        horizontalArrangement = Arrangement.SpaceBetween // Đẩy nút sang phải

    ) {
        Column {
            Text(text = subject, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 5.dp))
            Text(text = shortDescription, fontWeight = FontWeight.Light, fontSize = 14.sp)
        }

        Row {
            EditButton(modifier = Modifier.padding(end = 8.dp), content = "UPDATE")
            EditButton(modifier = Modifier, content = "SELECT")
        }
    }
}

@Composable
fun LazyColumnExample() {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item {
            RowContent(subject = "English", shortDescription = "Level 1", modifier = Modifier)
            RowContent(subject = "English", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 1", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)
            RowContent(subject = "Math", shortDescription = "Level 2", modifier = Modifier)


        }



    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        ScreenCourse()
    }
}