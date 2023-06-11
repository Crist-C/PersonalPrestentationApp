package com.example.personalprestentationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personalprestentationapp.ui.theme.PersonalPrestentationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalPrestentationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PresentationCard()
                }
            }
        }
    }
}

@Composable
fun PresentationCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
        .background(Color(0xFF112537)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        MainInformation(
            fullName = stringResource(R.string.cristian_full_name),
            photo = R.drawable.android_logo,
            title = stringResource(R.string.job_tittle),
            modifier = Modifier
                .padding(16.dp).weight(0.6f)
        )
        ContactInformation(
            stringResource(R.string.phone_number),
            stringResource(R.string.social_acount),
            stringResource(R.string.email),
            modifier = Modifier
                .padding(start = 24.dp, end = 16.dp, bottom = 0.dp).weight(0.3f)
        )

    }
}


@Composable
fun MainInformation(fullName: String, photo: Int, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = photo)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Image(
            painter = image,
            contentDescription = "Android Icon",
            Modifier.size(80.dp,80.dp)
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 32.sp,
            color = Color.White
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun ContactInformation(phoneNumber: String, accunt: String, email: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        PersonalInformationField(content = phoneNumber, icon = R.drawable.phone_24, description = "Phone number")
        PersonalInformationField(content = accunt, icon = R.drawable.social_account_24, description = "Social account")
        PersonalInformationField(content = email, icon = R.drawable.email_24, description = "Email account")
    }
}


@Composable
fun PersonalInformationField(content: String, icon: Int, description: String, modifier: Modifier = Modifier) {
    val iconResource = painterResource(id = icon)
    Row(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start) {
        Icon(
            painter = iconResource,
            contentDescription = description,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.padding(start = 24.dp, end = 8.dp)
        )
        Text(
            text = content,
            modifier = modifier,
            color = Color.LightGray
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PresentationCardPreview() {
    PersonalPrestentationAppTheme {
        PresentationCard()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainInformationPreview() {
    PersonalPrestentationAppTheme {
        MainInformation(
            stringResource(id = R.string.cristian_full_name),
            R.drawable.android_logo,
            stringResource(id = R.string.job_tittle)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ContactInformationPreview() {
    PersonalPrestentationAppTheme {
        ContactInformation(
            stringResource(R.string.phone_number),
            stringResource(R.string.social_acount),
            stringResource(R.string.email)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PhonePersonalInformationFieldPreview() {
    PersonalPrestentationAppTheme {
        PersonalInformationField(content = stringResource(id = R.string.phone_number), icon = R.drawable.phone_24, description = "Phone number")
    }
}

@Preview(showBackground = true)
@Composable
fun SocialAccountPersonalInformationFieldPreview() {
    PersonalPrestentationAppTheme {
        PersonalInformationField(content = stringResource(id = R.string.social_acount), icon = R.drawable.social_account_24, description = "Social account")
    }
}

@Preview(showBackground = true)
@Composable
fun EmailPersonalInformationFieldPreview() {
    PersonalPrestentationAppTheme {
        PersonalInformationField(content = stringResource(id = R.string.email), icon = R.drawable.email_24, description = "Email account")
    }
}