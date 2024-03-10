package com.victorbarrozo.primeiropojetocompose

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorbarrozo.primeiropojetocompose.ui.theme.PrimeiroPojetoComposeTheme
import java.io.ObjectInputStream.GetField



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeiroPojetoComposeTheme {
                Surface() {
                    Message("Victor", "aprendendo a usar Jetpack Compose")
                }
            }
        }
    }
}
data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message){
    //adicioma padding na mensagem
    Row (modifier = Modifier.padding(all =8.dp)){
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "profile picture",
            modifier = Modifier
                //Configura tamanho da imagem
                .size(40.dp)
                //Configura forma da imagem
                .clip(CircleShape)
                .border(3.dp, MaterialTheme.colorScheme.primary, CircleShape
            )
        )
        //add um espaço horizontal entre a imagem e coluna
        Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary
                )
                //Add um espaço entre autor e corpo da mensagem
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = msg.body)
            }
        }

    }



@Preview
@Composable
fun PreviewMessageCard() {
    PrimeiroPojetoComposeTheme {
        Surface {
            MessageCard(
                msg = Message("Victor", "aprendendo a usar Jetpack Compose")
            )
        }
    }
}





