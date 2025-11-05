# 📘 Estructura de una app Android en Kotlin

Una aplicación Android moderna (usando **Kotlin** y **Android Studio**) se compone de varios elementos organizados en carpetas y archivos clave.

---

## 🧱 1. Estructura general del proyecto

```
MyFirstApp/
│
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml
│   ├── java/
│   │   └── com.example.myfirstapp/
│   │       └── MainActivity.kt
│   ├── res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   ├── mipmap/
│   │   ├── values/
│   │   └── theme/
│   └── build.gradle
│
├── build.gradle (nivel proyecto)
└── settings.gradle
```

---

## 🧱 2. Archivos principales

### `AndroidManifest.xml`
Define la **estructura básica** y configuración general de la aplicación:

```xml
<manifest package="com.example.myfirstapp">
    <application
        android:label="My First App"
        android:icon="@mipmap/ic_launcher">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>
</manifest>
```

---

### `MainActivity.kt`
El punto de entrada de la app.  
Cuando el usuario abre la aplicación, Android crea una **instancia de esta actividad**.

```kotlin
package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                Text("¡Hola, Android con Kotlin!")
            }
        }
    }
}
```

---

### `build.gradle`
Contiene la configuración del proyecto y las dependencias (como Compose, Material3, etc.).

```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.myfirstapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myfirstapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.material3:material3:1.3.0")
}
```

---

## 🧩 3. Carpetas de recursos (`res/`)

- **`layout/`** → define la interfaz si usas XML (no Compose).
- **`drawable/`** → imágenes, formas o íconos personalizados.
- **`values/`** → textos (`strings.xml`), colores (`colors.xml`), estilos (`themes.xml`).
- **`mipmap/`** → íconos de la aplicación en distintas resoluciones.

---

## 🎨 4. Estructura en Jetpack Compose

En Compose, las interfaces ya **no usan XML**, sino **funciones composables** escritas en Kotlin:

```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hola $name!")
}

@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    Greeting("Kotlin")
}
```

---

## 🧠 5. Ciclo de vida básico de una Activity

1. `onCreate()` → inicializa la UI.  
2. `onStart()` → la app es visible.  
3. `onResume()` → la app está en primer plano.  
4. `onPause()` → el usuario cambia de app.  
5. `onStop()` → la app ya no está visible.  
6. `onDestroy()` → la actividad se elimina.
