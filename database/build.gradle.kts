import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
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
            baseName = "database"
            isStatic = true
        }
    }

    jvm("desktop")

    js {
        browser()
        useEsModules()
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.android.driver)
        }
        iosMain.dependencies {
            implementation(libs.native.driver)
        }
        desktopMain.dependencies {
            implementation(libs.sqldelight.sqlite.driver)
        }
        jsMain.dependencies {
            implementation(libs.sqldelight.web.worker.driver)
            implementationNpm(libs.sqljs)
            implementationNpm(libs.sqldelight.sqljs.worker)
            implementationDevNpm(libs.copy.webpack.plugin)
        }
    }
}

android {
    namespace = "br.com.marvelkmp.database"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

sqldelight {
    databases {
        create("MarvelDatabase") {
            packageName.set("br.com.marvelkmp.database")
            generateAsync.set(true)
        }
    }
}

fun KotlinDependencyHandler.implementationNpm(dependency: Provider<MinimalExternalModuleDependency>) =
    with(dependency.get()) { implementation(npm(module.name, version.orEmpty())) }

fun KotlinDependencyHandler.implementationDevNpm(dependency: Provider<MinimalExternalModuleDependency>) =
    with(dependency.get()) { implementation(devNpm(module.name, version.orEmpty())) }
