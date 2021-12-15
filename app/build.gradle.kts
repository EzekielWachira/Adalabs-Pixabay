plugins {
    id("kotlin-android")
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.daggerPlugin)
    id(BuildPlugins.navigationSafeArgs)
}

android {
    compileSdkVersion(AndroidSDK.compileSdk)

    defaultConfig {
        applicationId = "com.ezzy.adanianpixabay"
        minSdkVersion(AndroidSDK.minSdk)
        targetSdkVersion(AndroidSDK.targetSdk)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        vectorDrawables {
            useSupportLibrary = true
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(Dependencies.legacySupport)
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.materialComponents)
    implementation("androidx.preference:preference:1.1.1")

    //dependency injection hilt
    implementation(Dependencies.daggerHilt)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("com.google.android.material:material:1.4.0")
    kapt(Dependencies.daggerKtxCompiler)
//    implementation("com.google.android.material:material:1.4.0")

    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
    // Feature module Support
    implementation(Dependencies.navigationDynamic)
    // ViewModel
    implementation(Dependencies.lifecycleViewModel)
    // LiveData
    implementation(Dependencies.liveData)
    //COROUTINES
    implementation(Dependencies.coroutines)
    implementation(Dependencies.coroutinesCore)
    kapt(Dependencies.lifecyleCompiler)
    //ROOM DATABASE
    implementation(Dependencies.roomRuntime)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomKtx)

    //retrofit
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.retrofit)
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    //timber
    implementation(Dependencies.timber)
    //glide
    implementation(Dependencies.glide)
    kapt(Dependencies.glideAnnotation)

    implementation(Dependencies.workerKtx)
    implementation(Dependencies.circleImageView)
    implementation(Dependencies.multiDex)

    implementation(Dependencies.sdpAndroid)
    implementation(Dependencies.sspAndroid)
    implementation(Dependencies.spinKit)

    //work manager
    implementation(BuildPlugins.workManager)
    implementation(BuildPlugins.startUP)
    //hilt worker
    implementation(BuildPlugins.hiltWorker)

    //paging library
    implementation(BuildPlugins.pagingLib)

    //data store
    implementation(Dependencies.dataStore)

    implementation(Dependencies.sweetAlert2)

    //Instrumentation Test
    androidTestImplementation(TestLibraries.runner)
    androidTestImplementation(TestLibraries.rules)
    androidTestImplementation(TestLibraries.hiltTest)
    kaptAndroidTest(TestLibraries.hiltCompiler)
    androidTestImplementation(TestLibraries.androidXJUnit)
    androidTestImplementation(TestLibraries.androidXTestCore)
    androidTestImplementation(TestLibraries.androidMockK)
    androidTestImplementation(TestLibraries.truth)
    //Unit Tests
    testImplementation(TestLibraries.jUnit)
    testImplementation(TestLibraries.roomTest)
    testImplementation(TestLibraries.mockK)
    testImplementation(TestLibraries.roboelectric)
    testImplementation(TestLibraries.truth)
    testImplementation(TestLibraries.runner)
    testImplementation(TestLibraries.androidXJUnit)
    testImplementation(TestLibraries.coroutinesTest)
    testImplementation(TestLibraries.archComponentTest)
    testImplementation(TestLibraries.liveDataTesting)
    testImplementation(TestLibraries.hiltTest)
    kaptTest(TestLibraries.hiltCompiler)
    testImplementation("com.github.marcinOz:TestCoroutineRule:1.0.1")
//    testImplementation("com.github.marcinOz:TestCoroutineRule:1.0.1")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
}