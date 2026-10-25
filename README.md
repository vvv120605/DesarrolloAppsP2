# WIM 100 — Postulación y evaluación

Aplicación móvil Android desarrollada en Kotlin para digitalizar el proceso de postulación, revisión y evaluación de candidatas al programa **WIM 100 – DYM Cyber**.

El proyecto se desarrolla para la asignatura **DSY1105 — Desarrollo de Aplicaciones Móviles**, de Duoc UC, como parte de la Evaluación Parcial 2.

La aplicación permite registrar y consultar candidaturas, revisar antecedentes, aplicar una matriz de evaluación, consultar resultados consolidados y mantener un historial de las operaciones realizadas.

> **Proyecto académico:** todos los datos utilizados son ficticios o sintéticos. La aplicación no se conecta a la API real de LinkedIn y la matriz de evaluación es provisional, sujeta a validación del socio formador.

## 1. Integrantes del equipo

| Integrante | Usuario de GitHub | Responsabilidades |
|---|---|---|
| Vanessa Roberson | @vvv120605 | Issues #1, #3, #4, #5, #9 |
| David Navarrete | @daaaavvvvv | Issues #2, #6, #7, #8 |

**Repositorio:** https://github.com/vvv120605/DesarrolloAppsP2

## 2. Funcionalidades principales

### Gestión de candidaturas
- Registrar nuevas candidatas mediante un formulario con validaciones.
- Consultar candidaturas registradas.
- Buscar candidatas y filtrar por estado.
- Consultar antecedentes, experiencia, CV en PDF y enlace ficticio al perfil profesional.

### Evaluación
- Evaluar candidatas mediante cinco criterios ponderados.
- Asignar puntajes de 1 a 5 por criterio.
- Calcular el puntaje ponderado y mostrar el resultado sobre 100 puntos.
- Solicitar justificación cuando un criterio recibe una puntuación igual o inferior a 2.
- Registrar observaciones generales y el nombre de la evaluadora.
- Evitar evaluaciones duplicadas para una misma candidata y evaluadora.

### Resultados y seguimiento
- Consultar resultados consolidados y rankings por promedio.
- Gestionar estados de candidatura: postulada, en evaluación, evaluada, seleccionada y no seleccionada.
- Registrar eventos relevantes en un historial, como evaluaciones, consultas y resoluciones.
- Consultar los resultados según el rol de la persona usuaria.

### Perfiles de usuario
- **Evaluadora:** registra candidaturas y realiza evaluaciones.
- **Dirección:** consulta resultados y resuelve candidaturas.

## 3. Tecnologías utilizadas

| Tecnología | Uso |
|---|---|
| Kotlin 2.2.10 | Lenguaje de programación |
| Android SDK | Desarrollo de la aplicación Android |
| Jetpack Compose | Construcción declarativa de interfaces |
| Material Design 3 | Componentes y diseño visual |
| Navigation Compose 2.9.8 | Navegación entre pantallas |
| ViewModel y StateFlow | Gestión del estado y arquitectura MVVM |
| Room 2.8.4 | Persistencia local mediante SQLite |
| KSP | Procesamiento de anotaciones de Room |
| Gradle 9.4.1 | Construcción y gestión del proyecto |
| Android Gradle Plugin 9.2.1 | Integración de Android con Gradle |
| JUnit 4.13.2 | Pruebas unitarias |

Las versiones corresponden a las declaradas en la configuración del proyecto.

## 4. Requisitos técnicos

### Requisitos de desarrollo

- **Sistema operativo:** Windows, macOS o Linux compatible con Android Studio.
- **IDE:** Android Studio.
- **Lenguaje:** Kotlin.
- **JDK:** versión 21, según la configuración del proyecto.
- **Sistema de construcción:** Gradle mediante el Gradle Wrapper incluido en el repositorio.
- **SDK de Android:** instalar las plataformas y herramientas requeridas por la configuración del proyecto.
- **Dispositivo de ejecución:** emulador Android o dispositivo físico compatible.
- **Conectividad:** acceso a internet para descargar las dependencias durante la primera sincronización.

### Requisitos de la aplicación

- **Plataforma:** Android.
- **Versión mínima de Android:** API 24
- **Almacenamiento:** base de datos local Room sobre SQLite.
- **Conexión a servicios externos:** la aplicación utiliza datos ficticios para fines académicos y no requiere conexión a una API real de LinkedIn.

### Verificación de configuración

Antes de la entrega, confirmar estos valores en los archivos del proyecto:

- `app/build.gradle.kts`: `minSdk`, `compileSdk`, `targetSdk` y configuración de pruebas.
- `gradle/libs.versions.toml` o archivos de versiones equivalentes: versiones de las dependencias.
- `gradle/wrapper/gradle-wrapper.properties`: versión de Gradle utilizada.

Los valores documentados deben coincidir con la configuración real del repositorio.

## 5. Arquitectura del proyecto

La aplicación utiliza **MVVM (Model–View–ViewModel)** para separar la interfaz, el estado y la lógica de negocio.

El código fuente se organiza en los siguientes paquetes:

- `model/`: entidades, estados, evaluaciones y cálculos de puntaje.
- `data/local/`: base de datos Room, DAO, convertidores y datos sintéticos iniciales.
- `data/repository/`: acceso a los datos y operaciones de candidaturas, evaluaciones e historial.
- `validation/`: validadores independientes de la interfaz.
- `ui/screens/`: pantallas de la aplicación.
- `ui/components/`: componentes visuales reutilizables.
- `ui/viewmodel/`: gestión del estado y comunicación entre la interfaz y los repositorios.
- `navigation/`: rutas y navegación entre pantallas.
- `nativo/`: integración con funciones nativas de Android.
- `di/`: configuración e inicialización de dependencias.
- `ui/theme/`: colores, tipografía y tema visual.

### Flujo de datos

La pantalla observa el estado del ViewModel. El ViewModel procesa las acciones del usuario, aplica las validaciones necesarias y delega las operaciones de datos al repositorio. El repositorio utiliza los DAO de Room para consultar o modificar la base de datos local. Los cambios se reflejan en la interfaz mediante flujos reactivos.

## 6. Persistencia y datos de prueba

La aplicación utiliza Room (biblioteca en android) para almacenar localmente candidaturas, criterios, evaluaciones e historial.
Se incluyen datos sintéticos iniciales para facilitar las pruebas y la demostración de funcionalidades sin tener que registrar todos los datos manualmente.
La persistencia local permite consultar los registros guardados después de cerrar y volver a abrir la aplicación.

## 7. Recursos nativos de Android

La aplicación integra las siguientes funciones del dispositivo:

- **Biometría o credencial del dispositivo:** permite comprobar la disponibilidad de autenticación biométrica o mediante credencial.
- **Notificaciones locales:** informa sobre eventos de evaluación y gestiona el permiso de notificaciones en versiones compatibles de Android.
- **Selector de documentos y visor PDF:** permite seleccionar y consultar archivos PDF utilizando el selector del sistema.
- **Intents:** permite abrir recursos compatibles con otras aplicaciones y compartir información.

La pantalla de perfil permite consultar el estado de los permisos y probar las funciones nativas disponibles.

## 8. Requisitos para ejecutar el proyecto

Antes de abrir el proyecto, se recomienda contar con:

- Android Studio compatible con la configuración del proyecto.
- JDK 21.
- Android SDK y las herramientas necesarias para compilar la aplicación.
- Un emulador Android o un dispositivo compatible con API 24 o superior.
- Conexión a internet durante la primera sincronización, para descargar Gradle y las dependencias necesarias.

## 9. Cómo abrir y ejecutar la aplicación

1. Clonar el repositorio o descargarlo desde GitHub.
2. Descomprimir el proyecto si se descargó como archivo ZIP.
3. Abrir Android Studio y seleccionar **File → Open**.
4. Elegir la carpeta raíz que contiene `settings.gradle.kts`.
5. Esperar a que termine la sincronización de Gradle.
6. Crear o iniciar un dispositivo virtual Android compatible, o conectar un dispositivo físico con la depuración habilitada.
7. Seleccionar la configuración de ejecución `app`.
8. Pulsar **Run** para compilar e iniciar la aplicación.

No se debe abrir únicamente la carpeta 'app', ya que la configuración principal de Gradle está en la raíz del proyecto!!

## 9. Cómo ejecutar las pruebas automáticas

Las pruebas unitarias se encuentran en:

`app/src/test/java/com/example/appsemestral/`

Incluyen pruebas de:

- Validación de los datos de las candidatas.
- Validación de puntajes y observaciones de las evaluaciones.
- Cálculo del puntaje ponderado y normalización de claves de evaluadoras.

### En Windows

Abrir una terminal en la carpeta raíz del proyecto y ejecutar:

```powershell
.\gradlew.bat test
```

## 10. Para la demostración

Para revisar las funcionalidades:

1. Ingresar con un perfil de evaluadora.
2. Probar las validaciones del formulario de candidatura.
3. Consultar los antecedentes y el CV de una candidata.
4. Registrar una evaluación y revisar el resultado calculado.
5. Comprobar el bloqueo de evaluaciones duplicadas.
6. Consultar el historial y los resultados consolidados.
7. Ingresar con el perfil de Dirección para revisar y resolver candidaturas.
8. Cerrar y volver a abrir la aplicación para comprobar la persistencia local.

Las pruebas deben realizarse con datos ficticios. La disponibilidad de cada recurso nativo puede depender de la configuración del dispositivo o emulador.

---

**Proyecto académico — DSY1105, Duoc UC.**
