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
                jvmTarget = "11"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "networkCore"
            isStatic = true
        }
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }
        desktopMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.kotlinx.datetime)

            implementation(project.dependencies.platform(libs.crypto.bom))
            implementation(libs.crypto)
            implementation(libs.crypto.md)

            implementation(libs.bignum)

            implementation(project(":core"))
            implementation(project(":logging"))
        }
        commonTest.dependencies {
            implementation(libs.ktor.client.mock)
        }
    }
}
buildConfig {
    val publicKey = gradleLocalProperties(rootDir, providers).getProperty("PUBLIC_KEY")
    val privateKey = gradleLocalProperties(rootDir, providers).getProperty("PRIVATE_KEY")

    buildConfigField("String", "PUBLIC_KEY", publicKey)
    buildConfigField("String", "PRIVATE_KEY", privateKey)
}

android {
    namespace = "br.com.marvelkmp.network.core"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
