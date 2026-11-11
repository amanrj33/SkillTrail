package com.aman.skilltrail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.skilltrail.ui.theme.SkillTrailTheme

class MainActivity : ComponentActivity() {

    val tasks = listOf(
        Task(id = 1, title = "Install Android Studio", track = "Android Basics", points = 10, isDone = true),
        Task(id = 2, title = "Write first data class", track = "Android Basics", points = 15, isDone = true),
        Task(id = 3, title = "Build a Composable UI", track = "Jetpack Compose", points = 20, isDone = false),
        Task(id = 4, title = "Connect to a REST API", track = "Networking", points = 25, isDone = false),
        Task(id = 5, title = "Persist data with Room", track = "Database", points = 30, isDone = false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkillTrailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskList(
                        tasks = tasks,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskList(tasks: List<Task>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(tasks) { task ->
            Text(
                text = task.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    SkillTrailTheme {
        TaskList(
            tasks = listOf(
                Task(id = 1, title = "Install Android Studio", track = "Android Basics", points = 10, isDone = true),
                Task(id = 2, title = "Write first data class", track = "Android Basics", points = 15, isDone = true),
                Task(id = 3, title = "Build a Composable UI", track = "Jetpack Compose", points = 20, isDone = false)
            )
        )
    }
}
