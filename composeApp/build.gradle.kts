import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinxSerialization)
    id("com.github.gmazzo.buildconfig") version "5.3.5"
    id("app.cash.sqldelight") version "2.0.2"

}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.android.driver)

        }
        iosMain.dependencies {
            implementation(libs.native.driver)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.kamel.image)

            implementation(libs.coil)
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            implementation(libs.coil.gif)

            implementation(libs.voyager.navigator)
            implementation(libs.voyager.screenmodel)
            implementation(libs.voyager.koin)
            implementation(libs.voyager.transitions)

            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)

            implementation(libs.logback.android)
            implementation(libs.slf4j.api)

            implementation(libs.napier)

            implementation(libs.kotlinx.datetime)

            implementation(project.dependencies.platform(libs.crypto.bom))
            implementation(libs.crypto)
            implementation(libs.crypto.md)

            implementation(libs.bignum)

            implementation(libs.coroutines.extensions)

        }
    }
}

android {
    namespace = "br.com.marvelkmp.app"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "br.com.marvelkmp.app"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}
buildConfig {
    val publicKey = gradleLocalProperties(rootDir).getProperty("PUBLIC_KEY")
    val privateKey = gradleLocalProperties(rootDir).getProperty("PRIVATE_KEY")

    buildConfigField("String", "PUBLIC_KEY", publicKey)
    buildConfigField("String", "PRIVATE_KEY", privateKey)
}

sqldelight {
    databases {
        create("MarvelDatabase") {
            packageName.set("br.com.marvelkmp.app")
        }
    }
}