package id.my.kaorikizuna

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.my.kaorikizuna.ui.theme.IntentionallyActiveTheme
import id.my.kaorikizuna.ui.theme.horizontalPadding


@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    // use the MaterialTheme to style the text so that it can become unified throughout the project
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier.padding(40.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun FeatureCard(cardTitle: String, cardSubtitle: String, icon: Int) {
    val image = painterResource(id = icon)
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
    ) {
//      make the row have two items, namely the icon on the left side and content on the right side
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .size(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = image, contentDescription = null, modifier = Modifier.size(35.dp)
                )
            }
            Column {
                Text(cardTitle, style = MaterialTheme.typography.bodyLarge)
                Text(cardSubtitle, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun Features() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            "Features",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = horizontalPadding)
        )
        FeatureCard(
            cardTitle = stringResource(R.string.feature_easy),
            cardSubtitle = stringResource(R.string.feature_easy_description),
            icon = R.drawable.ic_sentiment_satisfied
        )
        FeatureCard(
            cardTitle = stringResource(R.string.feature_personalized),
            cardSubtitle = stringResource(R.string.feature_personalized_description),
            icon = R.drawable.ic_preliminary
        )
        FeatureCard(
            cardTitle = stringResource(R.string.feature_offline),
            cardSubtitle = stringResource(R.string.feature_offline_description),
            icon = R.drawable.ic_public_off
        )
    }
}

@Composable
fun BottomButton(text: String = "Start Now", navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 100.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(onClick = { navController.navigate("exercises") }) {
            Text(text)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
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
                Title(
                    text = stringResource(id = R.string.display_text),
                    modifier = Modifier.padding(paddingValue)
                )
                Features()
                BottomButton(navController = navController)
            }
        })
    }
}
