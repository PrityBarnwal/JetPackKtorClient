package com.applaunch.jcui.ui.screen.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applaunch.jcui.R
import com.applaunch.jcui.ui.model.HomeModel.HomeDataModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(homeDataModel: HomeDataModel) {

    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "Text 1")
                Text(text = "Text 2")
                Text(text = "Text 3")
                Text(text = "Text 4")
                Text(text = "Text 5")
                Text(text = "Text 6")
                Text(text = "Text 7")
                Text(text = "Text 8")
            }
        },
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetElevation = 12.dp
    ) {
        favItemList(homeDataModel, onClick = {
            scope.launch {
                bottomSheetState.show()
            }
        }
        )
    }
}


//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun MainContent(scope:CoroutineScope,bottomSheetState: ModalBottomSheetState) {
//
//    Surface(modifier = Modifier.fillMaxSize()) {
//
//        Button(modifier = Modifier
//            .height(40.dp)
//            .fillMaxWidth(), onClick = {
//            scope.launch {
//                bottomSheetState.show()
//            }
//        }) {
//            Text(text = "Click me ( Expand me)")
//        }
//
//    }
//
//
//}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun favItemList(homeDataModel: HomeDataModel, onClick: () -> Unit = {}) {
    val favItem = remember {
        mutableStateOf(homeDataModel.isFavorite)
    }

    Box(
        modifier = Modifier
            .padding(top = 16.dp, end = 16.dp)
            .clickable(
                onClick = {
                    if (favItem.value){
                        onClick.invoke()
                    }
                })
    ) {
        Image(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            painter = painterResource(id = R.drawable.ic_favorite_selected),
            contentDescription = "Fav Image"
        )
    }
}