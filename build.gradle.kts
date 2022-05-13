plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "de.niklas"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation("org.jetbrains:annotations:20.1.0")

    // lombok
    implementation("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}