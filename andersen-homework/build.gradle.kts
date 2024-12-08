plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}


dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.jetbrains:annotations:24.0.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation ("org.hibernate:hibernate-core:6.2.14.Final")


    runtimeOnly ("com.h2database:h2:2.1.214")


    implementation ("org.slf4j:slf4j-api:2.0.9")
    runtimeOnly ("org.slf4j:slf4j-simple:2.0.9")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
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

