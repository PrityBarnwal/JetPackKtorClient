package com.applaunch.jcui.ui.screen.Home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.request.ImageRequest
import com.applaunch.jcui.R
import com.applaunch.jcui.network.Resources
import com.applaunch.jcui.ui.model.HomeModel.HomeDataModel
import com.applaunch.jcui.ui.theme.DarkBlack
import com.applaunch.jcui.ui.theme.Drax
import com.applaunch.jcui.ui.utils.MyUtils
import com.applaunch.jcui.viewModel.HomeViewModel


@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    HomeScreenDesign(viewModel)
}

@Composable
fun HomeScreenDesign(viewModel: HomeViewModel) {

    Box(
        modifier = Modifier
            .height(200.dp)
            .background(Drax)
    ) {
        HomeImage()
    }
    Box(modifier = Modifier.padding(top = 150.dp)) {
//        val data = HomeData()
//        val getAllData =
//        LazyColumn(  contentPadding = PaddingValues(bottom = 16.dp, start = 16.dp, end = 16.dp),
//            verticalArrangement = Arrangement.spacedBy(10.dp)){
//            items() { item ->
//                ListCard(item)
//            }
//        }
        val context = LocalContext.current
        val movies = viewModel.home.collectAsState()
        movies.value?.let {
            when (it) {
                is Resources.Failure -> {
                    Toast.makeText(context, it.exception.message!!, Toast.LENGTH_SHORT).show()
                }
                is Resources.Success -> {
                    HomeList(home = it.result)
                }
                is Resources.Loading -> {
                    //do letter
                }
            }
        }
    }
}

@Composable
fun HomeList(home: List<HomeDataModel>) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(home) { item ->
                ListCard(item)
            }
        }
}

@Composable
fun HomeImage() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 16.dp, top = 56.dp)
                    .width(160.dp)
                    .height(60.dp),
                painter = painterResource(id = R.drawable.ic_bgm),
                contentDescription = "bgm"
            )
            Image(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 56.dp, end = 16.dp)
                    .width(156.dp)
                    .height(50.dp),
                painter = painterResource(id = R.drawable.draxmilar),
                contentDescription = "draxmilar"
            )
        }
    }
}

@Composable
fun ListCard(homeDataModel: HomeDataModel) {
    var selectedIndex by remember { mutableStateOf("-1") }
    var likeIcon by remember {
        mutableStateOf(homeDataModel.isLike)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = (2.dp),
                color = if (homeDataModel._id == selectedIndex) Drax else Color.White,
                RoundedCornerShape(16.dp)
            )
            .selectable(selected = homeDataModel._id == selectedIndex,
                onClick = {
                    if (selectedIndex != homeDataModel._id)
                        selectedIndex = homeDataModel._id else selectedIndex = "-1"
                })
            .clip(RoundedCornerShape(16.dp))
    ) {
        Column {
            Box() {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(343.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://bgm-staging.s3.eu-central-1.amazonaws.com/" + homeDataModel.image)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_place_holder),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
//                Image(
//                    modifier = Modifier.fillMaxWidth(),
//                    painter = rememberImagePainter(data = "https://bgm-staging.s3.eu-central-1.amazonaws.com/" + homeDataModel.image),
//                    contentDescription = "dummy Image", contentScale = ContentScale.Crop
//                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                ) {
                    ListItem(homeDataModel)
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
//BottomSheet(homeDataModel = homeDataModel)
                    favItem(homeDataModel)
                }
            }

            Text(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
                fontFamily = FontFamily.Default,
                text = homeDataModel.title,
                color = DarkBlack,
                fontSize = 14.sp
            )
            Row(modifier = Modifier.clickable(onClick = {
                likeIcon = !likeIcon
            })) {
                Image(
                    modifier = Modifier.padding(bottom = 16.dp, start = 16.dp),
                    painter = painterResource(id = if (likeIcon) R.drawable.ic_like_selected else R.drawable.ic_like_unselected),
                    contentDescription = "like Image"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "36 likes", color = DarkBlack, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun ListItem(homeDataModel: HomeDataModel) {
    Column(modifier = Modifier.padding(start = 16.dp, bottom = 48.dp)) {
        Text(text = "Rehazentrum Straubing Dr Hierl", color = Color.White, fontSize = 24.sp)
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(text = (homeDataModel.streamType ?: homeDataModel.writtenBy), color = Color.White, fontSize = 12.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_oval),
                contentDescription = "oval",
                modifier = Modifier.padding(8.dp)
            )
            Text(text = MyUtils.convertDate(homeDataModel.date), color = Color.White, fontSize = 12.sp)
        }
        Row(
            modifier = Modifier
                .background(color = Drax, shape = RoundedCornerShape(60.dp))
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_live_circle),
                contentDescription = "live icon",
                modifier = Modifier
                    .size(18.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Live BroadCast", color = Color.White, fontSize = 12.sp)
        }
    }
}


@Composable
fun favItem(homeDataModel: HomeDataModel, onClick: () -> Unit = {}) {
    var favIcon by remember {
        mutableStateOf(homeDataModel.isFavorite)
    }

    Box(
        modifier = Modifier
            .padding(top = 16.dp, end = 16.dp)
            .clickable(onClick = {
                onClick.invoke()
                favIcon = !favIcon
            })
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .height(40.dp)
                .width(40.dp)
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            painter = painterResource(id = if (favIcon) R.drawable.ic_favorite_selected else R.drawable.ic_favorite_unselected),
            contentDescription = "Fav Image"
        )
    }
}

