package com.example.lazylistaccessibilityissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazylistaccessibilityissue.ui.theme.LazyListAccessibilityIssueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListAccessibilityIssueTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

private enum class ColumnListItem {
    CARD_LARGE,
    CARD_SMALL,
    ROW_LIST
}

private val items = listOf(
    ColumnListItem.CARD_SMALL,
    ColumnListItem.ROW_LIST,
    ColumnListItem.CARD_LARGE,
    ColumnListItem.CARD_LARGE,
    ColumnListItem.ROW_LIST,
    ColumnListItem.CARD_SMALL,
    ColumnListItem.ROW_LIST,
    ColumnListItem.CARD_SMALL
)

@Composable
fun MainScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            when (item) {
                ColumnListItem.CARD_LARGE -> CardLarge()
                ColumnListItem.CARD_SMALL -> CardSmall()
                ColumnListItem.ROW_LIST -> RowList()
            }
        }
    }
}

@Composable
fun CardLarge() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .background(Color.Black)
        .semantics(mergeDescendants = true) {}) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Big Card"
        )
    }
}

@Composable
fun CardSmall() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .background(Color.DarkGray)
        .semantics(mergeDescendants = true) {}) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Small Card"
        )
    }
}

@Composable
fun RowList(itemCount: Int = 20) {
    Column {
        Text(text = "List of Items")
        Spacer(modifier = Modifier.padding(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items(itemCount) {index ->
                RowListItem(index)
            }
        }
    }
}

@Composable
fun RowListItem(item: Int) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .width(150.dp)
            .padding(8.dp)
            .semantics(mergeDescendants = true) {},
    ) {
        Text(text = "Title - $item")
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyListAccessibilityIssueTheme {
        MainScreen()
    }
}