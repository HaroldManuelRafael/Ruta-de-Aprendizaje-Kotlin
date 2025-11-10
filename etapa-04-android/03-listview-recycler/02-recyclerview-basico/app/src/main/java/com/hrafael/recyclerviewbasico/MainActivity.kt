package com.hrafael.recyclerviewbasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hrafael.recyclerviewbasico.ui.theme.RecyclerViewBasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val frutas = listOf(
            Fruta("Manzana", R.mipmap.ic_launcher),
            Fruta("Banana", R.mipmap.ic_launcher),
            Fruta("Naranja", R.mipmap.ic_launcher),
            Fruta("Pera", R.mipmap.ic_launcher),
            Fruta("Uva", R.mipmap.ic_launcher),
            Fruta("Fresa", R.mipmap.ic_launcher),
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FrutaAdapter(frutas)
    }
}