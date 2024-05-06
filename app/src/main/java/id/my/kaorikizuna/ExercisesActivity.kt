package id.my.kaorikizuna

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.my.kaorikizuna.ui.theme.IntentionallyActiveTheme
import id.my.kaorikizuna.ui.theme.horizontalPadding

// make the exercises as a list, don't give any interaction in it because it's not necessary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExercisesScreen(navController: NavController) {
    IntentionallyActiveTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            CenterAlignedTopAppBar(
                title = {
                    (Text(
                        stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineLarge
                    ))
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }, content = { paddingValue ->
            Column {
                WarmUps(paddingValues = paddingValue)
                Divider()
                Exercises()
            }

        })
    }
}

@Composable
fun ExerciseCard(
    exerciseName: String, exerciseDescription: String
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp), modifier = Modifier.padding(6.dp)
        ) {
            Text(text = exerciseName, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = exerciseDescription,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Composable
fun WarmUps(paddingValues: PaddingValues) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(horizontalPadding)
            .padding(paddingValues)
    ) {
        Text("Warm Ups", style = MaterialTheme.typography.titleLarge)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            items(warmUps) { item ->
                ExerciseCard(item.title, item.description)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Exercises() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .padding(horizontalPadding)
            .padding(vertical = 10.dp)
    ) {
        Text("Exercises", style = MaterialTheme.typography.titleLarge)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(5.dp)) {
            items(exercises) { item ->
                ExerciseCard(exerciseName = item.title, exerciseDescription = item.description)
            }
        }
    }
}
