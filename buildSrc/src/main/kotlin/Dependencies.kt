const val kotlinVersion = "1.5.30"
const val hilt_version = "2.40.1"

object BuildPlugins {
    private object Version {
        const val buildToolsVersion = "4.2.1"
        const val gsmVersion = "4.3.5"
    }
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Version.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
    const val safeArgsPlugins = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerPlugin = "dagger.hilt.android.plugin"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
    const val googleServices = "com.google.gms:google-services:${Version.gsmVersion}"
    const val googleServicesPlugin = "com.google.gms.google-services"
    const val workManager = "androidx.work:work-runtime-ktx:$${Versions.work_version}"
    const val startUP = "androidx.startup:startup-runtime:1.0.0"
    const val hiltWorker = "androidx.hilt:hilt-work:1.0.0"
    const val pagingLib = "androidx.paging:paging-runtime-ktx:${Versions.paging_version}"
}

object AndroidSDK {
    const val minSdk = 19
    const val targetSdk = 31
    const val compileSdk = targetSdk
}

object TestLibraries {
    private object Version {
        // tests
        const val junit = "4.13"
        const val espresso = "3.3.0"
        const val roboelectric = "4.6.1"
        const val androidXJUnit = "1.1.1"
        const val truth = "1.0.1"
        const val androidXTestCore = "1.3.0"
        const val runner = "1.3.0"
        const val rules = "1.3.0"
        const val archComponentTest = "2.1.0"
        const val mockK = "1.10.0"
        const val liveDataTesting = "1.1.2"
        const val hiltVersion = "2.38.1"
    }
    const val hiltTest = "com.google.dagger:hilt-android-testing:${Version.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hiltVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val jUnit = "junit:junit:${Version.junit}"
    const val roboelectric = "org.robolectric:robolectric:${Version.roboelectric}"
    const val androidXJUnit = "androidx.test.ext:junit:${Version.androidXJUnit}"
    const val truth = "com.google.truth:truth:${Version.truth}"
    const val androidXTestCore = "androidx.test:core:${Version.androidXTestCore}"
    const val runner = "androidx.test:runner:${Version.runner}"
    const val rules = "androidx.test:rules:${Version.rules}"
    const val roomTest = "androidx.room:room-testing:${Versions.roomVersion}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    const val archComponentTest =
        "androidx.arch.core:core-testing:${Version.archComponentTest}"
    const val mockK = "io.mockk:mockk:${Version.mockK}"
    const val androidMockK = "io.mockk:mockk-android:${Version.mockK}"
    const val liveDataTesting = "com.jraska.livedata:testing-ktx:${Version.liveDataTesting}"

}

object Dependencies {

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val materialComponents = "com.google.android.material:material:${Versions.materialDesignVersion}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constrainLayoutVersion}"
    const val daggerHilt = "com.google.dagger:hilt-android:$hilt_version"
    const val daggerKtxCompiler = "com.google.dagger:hilt-android-compiler:$hilt_version"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupportVersion}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    const val navigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val lifecyleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleVersion}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideAnnotation = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"
    const val workerKtx = "androidx.work:work-runtime-ktx:${Versions.workVersion}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageViewVersion}"
    const val multiDex = "androidx.multidex:multidex:${Versions.multidexVersion}"
    const val sdpAndroid = "com.intuit.sdp:sdp-android:${Versions.sdpAndroidVersion}"
    const val sspAndroid = "com.intuit.ssp:ssp-android:${Versions.sdpAndroidVersion}"

    const val firebase = "com.google.firebase:firebase-bom:${Versions.firebaseVersion}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseFireStore = "com.google.firebase:firebase-firestore-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseStorage = "com.google.firebase:firebase-storage-ktx"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseUiAuth = "com.firebaseui:firebase-ui-auth:${Versions.firebaseUiVersion}"
    const val firebaseUiForFirestore = "com.firebaseui:firebase-ui-firestore:${Versions.firebaseUiVersion}"
    const val coroutinesForFirebase = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesForFirebaseVersion}"
    const val sweetAlert = "com.github.thomper:sweet-alert-dialog:${Versions.sweetAlertVersion}"
    const val sweetAlert2 = "com.github.thomper:sweet-alert-dialog:${Versions.sweetAlertVersion}"
    const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStoreVersion}"
    const val typedDataStore = "androidx.datastore:datastore:${Versions.dataStoreVersion}"

    const val kmProgress = "com.github.krishnanmuthaiahpillai:ProgressBar:${Versions.kmProgressVersion}"
    const val skydoveProgress = "com.github.skydoves:progressview:${Versions.skydoveVersion}"
    const val mpCharts = "com.github.PhilJay:MPAndroidChart:${Versions.mpChartVersion}"
    const val anyCharts = "com.github.AnyChart:AnyChart-Android:${Versions.anycharts_version}"
    const val cardSlider = "com.github.IslamKhSh:CardSlider:${Versions.cardSliderVersion}"
    const val spinKit = "com.github.ybq:Android-SpinKit:${Versions.spinKitVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
}