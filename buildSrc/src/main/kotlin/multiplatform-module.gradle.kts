import org.gradle.accessors.dm.LibrariesForLibs
import util.commonAndroid

val libs = the<LibrariesForLibs>()

plugins {
   id("org.jetbrains.kotlin.multiplatform")
   id("com.android.library")

   id("all-modules-commons")
}

kotlin {
   androidTarget()
   jvm()

   // iOS targets require a Mac with Xcode installed
   val enableIosTargets = System.getProperty("os.name").contains("mac", ignoreCase = true)
   if (enableIosTargets) {
      iosArm64()
      iosSimulatorArm64()
   }
}

commonAndroid {
   namespace = "com.matejdro.micropebble.noresources"
   compileSdk = 36
   defaultConfig {
      minSdk = 30
   }
   compileOptions {
      sourceCompatibility = JavaVersion.VERSION_17
      targetCompatibility = JavaVersion.VERSION_17
   }
}
