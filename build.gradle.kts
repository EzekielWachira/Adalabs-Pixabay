// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.5.30")
    repositories {
        google()
        mavenCentral()
//        jcenter()
    }
    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(BuildPlugins.hiltPlugin)
        classpath(BuildPlugins.safeArgsPlugins)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.7.1")
    }
}

tasks.register("clean").configure {
    delete("build")
}