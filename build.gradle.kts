import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
  mavenCentral()
  maven("https://jitpack.io")
}
plugins {
  kotlin("jvm") version "1.8.0"
  id("com.github.johnrengelman.shadow") version "7.1.2"
}
dependencies {
  implementation("org.jsoup:jsoup:1.15.3")
  implementation("com.github.ajalt.clikt:clikt:3.5.1")
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("io.mockk:mockk:1.13.2")
}
tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "17"
}
tasks.test {
  useJUnitPlatform()
}
tasks.jar {
  isZip64 = true
  manifest.attributes("Main-Class" to "UtilityKt")
}
tasks.shadowJar {
  minimize() // if build is unsuccessful, you can disable it
  // also, if build still unsuccessful, you can try to add mergeServiceFiles() call
}
tasks.build {
  dependsOn(tasks.shadowJar)
}
