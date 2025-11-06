package com.example.layoutsmodificadores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsYModificadoresDemo()
        }
    }
}

@Composable
fun LayoutsYModificadoresDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF9FAFB)),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            "Layouts y Modificadores",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // 🧱 1. Ejemplo de Row y Column
        EjemploRowYColumn()

        // 🧩 2. Espaciado, relleno y alineación
        EjemploPaddingYAlign()

        // 🧊 3. Formas, bordes y colores
        EjemploBordesYClip()

        // ⚖️ 4. Uso de weight y distribución proporcional
        EjemploWeight()

        // 📐 5. Box y superposición de elementos
        EjemploBox()
    }
}

// 🧱 1. Row y Column
@Composable
fun EjemploRowYColumn() {
    Text("Row y Column:", fontWeight = FontWeight.SemiBold)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE3F2FD))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Izquierda")
            Text("Centro")
            Text("Derecha")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {}) { Text("A") }
            Button(onClick = {}) { Text("B") }
            Button(onClick = {}) { Text("C") }
        }
    }
}

// 🧩 2. Padding, Margin (con Spacer) y alineación
@Composable
fun EjemploPaddingYAlign() {
    Text("Padding y alineación:", fontWeight = FontWeight.SemiBold)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFF8E1))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Texto centrado", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(12.dp))
        Text("Texto alineado a la izquierda", modifier = Modifier.align(Alignment.Start))
        Spacer(modifier = Modifier.height(12.dp))
        Text("Texto alineado a la derecha", modifier = Modifier.align(Alignment.End))
    }
}

// 🧊 3. Formas, bordes y colores
@Composable
fun EjemploBordesYClip() {
    Text("Formas y colores:", fontWeight = FontWeight.SemiBold)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xFF90CAF9))
        )

        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF81C784))
        )

        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color(0xFFFF8A65))
                .border(3.dp, Color.White, CircleShape)
        )
    }
}

// ⚖️ 4. Distribución proporcional (weight)
@Composable
fun EjemploWeight() {
    Text("Distribución con weight:", fontWeight = FontWeight.SemiBold)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color(0xFFBBDEFB)),
            contentAlignment = Alignment.Center
        ) { Text("1x") }

        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight()
                .background(Color(0xFF64B5F6)),
            contentAlignment = Alignment.Center
        ) { Text("2x") }
    }
}

// 📐 5. Box y superposición
@Composable
fun EjemploBox() {
    Text("Box y superposición:", fontWeight = FontWeight.SemiBold)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(0xFFE0F7FA)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF4DD0E1))
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color(0xFF00796B))
        )
        Text("Superposición", color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutsYModificadoresPreview() {
    LayoutsYModificadoresDemo()
}
