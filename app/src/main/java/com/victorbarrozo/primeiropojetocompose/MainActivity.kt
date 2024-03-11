package com.victorbarrozo.primeiropojetocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.victorbarrozo.primeiropojetocompose.ui.theme.PrimeiroPojetoComposeTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeiroPojetoComposeTheme {
                Conversation(SampleData.conversationSample)
            }
        }
    }
}
data class Message(val author: String, val body: String)
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

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
                .border(
                    3.dp, MaterialTheme.colorScheme.primary, CircleShape
                )
        )
        //add um espaço horizontal entre a imagem e coluna
        Spacer(modifier = Modifier.width(8.dp))
        //Mantem atualizada se a mensagem expandir ou não
        var isExpanded by remember { mutableStateOf(false) }
        val surFaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else
            MaterialTheme.colorScheme.surface
        )

            Column(modifier = Modifier.clickable{ isExpanded = !isExpanded}) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )
                //Add um espaço entre autor e corpo da mensagem
                Spacer(modifier = Modifier.width(4.dp))
                Surface(shape = MaterialTheme.shapes.medium,
                    shadowElevation = 10.dp,
                    color = surFaceColor,
                    modifier = Modifier.animateContentSize().padding(1.dp)
                    ) {
                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(all = 8.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

    }


@Preview
@Composable
fun PreviewConversation() {
    PrimeiroPojetoComposeTheme {
        Conversation(SampleData.conversationSample)
    }
}

/*
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
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
*/






