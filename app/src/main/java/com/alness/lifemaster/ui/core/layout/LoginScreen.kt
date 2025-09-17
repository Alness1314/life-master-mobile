package com.alness.lifemaster.ui.core.layout


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alness.lifemaster.ui.core.components.EmailEditText
import com.alness.lifemaster.ui.core.components.PasswordEditText
import com.alness.lifemaster.ui.core.components.PrimaryButton
import com.alness.lifemaster.R

@Composable
fun ScreenLogin(
    modifier: Modifier = Modifier,
    logoResId: Int,
    onLogin: () -> Unit,
    isLoading: Boolean = false
) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isVisible: Boolean by rememberSaveable { mutableStateOf(false) }


    fun clearText() {
        username = ""
        password = ""
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            // Card fija abajo (similar a MaterialCardView transparent)
            Surface(
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.0f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.footer_app),
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 14.sp,
                        modifier = Modifier.alpha(0.6f).padding(top = 16.dp, bottom = 16.dp),
                    )
                }
            }
        }
    ) {
        innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
            Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                Column (modifier = Modifier.fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 16.dp)){
                    Box(modifier = modifier.fillMaxWidth().height(250.dp),
                        contentAlignment = Alignment.Center){
                        Image(painter = painterResource(logoResId),
                            contentDescription = "descripcion de la imagen",
                            modifier = Modifier.height(80.dp).fillMaxWidth(0.9f),
                            contentScale = ContentScale.FillWidth
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    //textos
                    Text(
                        text = stringResource(id = R.string.title),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.displaySmall,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(id = R.string.sub_title),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 4.dp, bottom = 16.dp)
                            .alpha(0.5f),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    //form
                    EmailEditText(username, stringResource(id = R.string.label_username), { username = it }, { username = "" })
                    PasswordEditText(
                        password,
                        stringResource(id = R.string.label_passwor),
                        { password = it },
                        isVisible,
                        { isVisible = !isVisible })
                    PrimaryButton( {onLogin()} , stringResource(id = R.string.label_button))
                    // Info pequeño
                    Text(
                        text = stringResource(id = R.string.warning_info),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .alpha(0.4f),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

    }


}




