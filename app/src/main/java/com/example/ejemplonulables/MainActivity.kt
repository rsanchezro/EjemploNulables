package com.example.ejemplonulables

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var editTextNombre: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextTelefono: EditText
    lateinit var boton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarComponentes()
        boton.setOnClickListener {
            mostrarUsuario(this)
        }

    }

    private fun inicializarComponentes() {

        this.editTextNombre=findViewById<EditText>(R.id.editTextNombre)
        this.editTextEmail=findViewById<EditText>(R.id.editTextemail)
        this.editTextTelefono=findViewById<EditText>(R.id.editTextTelef)
        this.boton=findViewById<Button>(R.id.button)



    }

    private fun mostrarUsuario(){
            //Muestro el nombre
      Toast.makeText(this,"Nombre: ${editTextNombre.text}",Toast.LENGTH_LONG).show()
        var texto_email:String=""
      /*  if(editTextEmail.text!=null)
        {
            texto_email=editTextEmail.text.toString()
        }
        else
        {
         texto_email="Email desconocido"
        }
        Toast.makeText(this,texto_email, Toast.LENGTH_LONG).show()
*/
        //IGUAL QUE LO DE ANTES PERO EN VERSIÓN KOTLIN
        Toast.makeText(this,
            editTextEmail.text?.let {
            it
        }?:"Email desconocido", Toast.LENGTH_LONG).show()

        Toast.makeText(this,
            editTextTelefono.text?.let {
                it.length.toString()
            }?:"Telefono no disponible",
            Toast.LENGTH_LONG
        ).show()








    }

}

fun mostrarUsuario(contexto: Context)
{
    Toast.makeText(contexto,"Hola",Toast.LENGTH_LONG).show()

}


