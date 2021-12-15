# Adalabs Pixabay Interview Test
The app consumes the Pixabay API to fetch a list of images and display them on the screen. It also enables image search.
<br />

### Functional requirements
* The user SHOULD see a list of images and the username of the owner.
* The user SHOULD select an image and be able to view image details.
* The user SHOULD search for images and see results in a list.
* When the app opens let the app search for pictures of dogs as default
* The android application SHOULD be able to work offline.

### Architecture
The app uses a combination Clean Architecture and MVVM architecture for separation of concerns from business logic and presentation layer

### Libraries
* Material Design
* Retrofit - A Type-safe HTTP client for android and java which simplfies consuming RESTful APIs.
* Gson - Converts JSON to Java/Kotlin objects.
* OkHttp-logging-interceptor - Makes it easy to log OkHttp network traffic
* Glide - Image loader libraru for android
* Dagger Hilt - Used for Dependency Injection
* Room - Persistence library making it easier to work with SQLite database
* Data Binding - Jetpack library allowing to bind UI components to data sources
* ViewModel - Designed to store and manage UI data in a lifecycler aware fashion.
* Gradle Kotlin DSL build system
