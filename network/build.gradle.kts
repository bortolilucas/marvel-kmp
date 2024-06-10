import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.buildconfig)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "network"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.koin.android)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.android.driver)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.kotlinx.coroutines.core)

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
        }
    }
}
buildConfig {
    val publicKey = gradleLocalProperties(rootDir).getProperty("PUBLIC_KEY")
    val privateKey = gradleLocalProperties(rootDir).getProperty("PRIVATE_KEY")

    buildConfigField("String", "PUBLIC_KEY", publicKey)
    buildConfigField("String", "PRIVATE_KEY", privateKey)
}

android {
    namespace = "br.com.marvelkmp.network"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}