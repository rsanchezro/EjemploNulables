package com.example.ejemplonulables

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplonulables.ui.theme.EjemploNulablesTheme
import kotlin.random.Random

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Llamada al metodo OnCreate de la
        //clase superior(ComponentActivity)
        super.onCreate(savedInstanceState)
        //Extiende toda la interfaz visual
        //al tamaño de la pantalla del dispositivo
        enableEdgeToEdge()
        //Asignar a la activity la interfaz visual
        setContent {

            //Estoy llamando a una funcion
            //@Composable que sirve
            //para fijar el tema de todo lo que
            //este dentro de esa funcion
            EjemploNulablesTheme {

                //Invoco a otra funcion,
                Scaffold(modifier = Modifier.fillMaxSize(), content = { margen ->
                    pantalla(Modifier.padding(margen))
                })
            }

        }

    }
}

@Composable
fun pantalla(mimodificador:Modifier)
{



   var nombre by remember{ mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf(value="") }
    //Obtengo el contexto de la activity
    var micontexto=LocalContext.current
    Log.i("pantalla","Se ejecuta la funcion")
    Column(modifier=mimodificador.padding(top = 32.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){

        TextField(value=nombre, label = {Text("Introduce Nombre")},
            onValueChange = {texto_escrito->
                nombre=texto_escrito
            }
           )
        TextField(value=email,
            {
                email=it
            }, label = {Text("Introduce email")}
            )
        TextField(value=telefono,
            {
                telefono=it
            }, label = {Text("Introduce telefono")}
           )

        Button(onClick = {
            mostrarUsuario(nombre,email,telefono, micontexto)
        }, modifier = Modifier.padding(top = 64.dp)){
            Text("Dar de Alta")
        }

    }


}


fun mostrarUsuario(nombre:String,email:String?,telefono:String?,contexto: Context)
{
   /* var em2:String=""
    if(email!=null)
    {
        em2=email.uppercase()
    }
    else
    {
        em2="Email no proporcionado"
    }*/
   //Lo mismo que en las lineas anteriores pero en Kotlin
    var em=email?.let{
        it.uppercase()
    }?:"Email no proporcionado"

    var longuitud=telefono?.let{
        it.length.toString()
    }?:"Telefono no disponible"

    Toast.makeText(contexto,"Nombre:$nombre",Toast.LENGTH_LONG).show()
    Toast.makeText(contexto,"Email:$em",Toast.LENGTH_LONG).show()
    Toast.makeText(contexto,"Longitud telefono:$longuitud",Toast.LENGTH_LONG).show()





}
@Preview
@Composable
fun pantallaPreview()
{
    Scaffold(modifier = Modifier.fillMaxSize()) { margen ->
        //Pinto los componentes del contenido
        pantalla(Modifier.padding(top=16.dp,
            bottom = 16.dp))

    }
}


