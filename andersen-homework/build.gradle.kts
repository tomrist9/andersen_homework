plugins {
    id("org.springframework.boot") version "3.1.2" // Previous version before 3.1.3
    id("io.spring.dependency-management") version "1.1.2" // Compatible with Spring Boot 3.1.2
    kotlin("jvm") version "1.9.10" // Include if you're using Kotlin
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("org.projectlombok:lombok:1.18.26")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")



    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.2" )// Replace with the latest version if needed

}

tasks.test {
    useJUnitPlatform()
}
tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<Test> {
    jvmArgs = listOf("--enable-preview")
}

