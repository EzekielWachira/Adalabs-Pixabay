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

## Art
<img src="/art/Screenshot_2021-12-14-08-43-07-318_com.ezzy.adanianpixabay.jpg"/>

<img src="/art/Screenshot_2021-12-14-08-43-15-460_com.ezzy.adanianpixabay.jpg"/>

### Unit Tests
<img src="/art/Screenshot%202021-12-15%20101536.png"/>
<img src="/art/Screenshot 2021-12-15 101711.png"/>

## LICENSE

````text
MIT License

Copyright (c) 2022 Ezekiel Wachira

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

````
