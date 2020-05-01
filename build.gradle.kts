// NOTE: last checked date: 2019-Jan-31

plugins {
    id("java")
    id("jacoco")
    id("idea")

    id("com.github.spotbugs") version "3.0.0"
    id("io.franzbecker.gradle-lombok") version "3.2.0"
}

apply(plugin = "java")
apply(plugin = "jacoco")
apply(plugin = "com.github.spotbugs")
apply(plugin = "io.franzbecker.gradle-lombok")

val projectGroup = "com.github.wgx731"
val projectVersion = "1.0.0"

val jacocoVersion = "0.8.5"
val spotbugsVersion = "3.1.12"

val lombokVersion = "1.18.10"
val log4j2Version = "2.13.2"

val junitVersion = "5.6.0"
val assertjVersion = "3.15.0"
val mockitoVersion = "3.3.3"

repositories {
    mavenCentral()
    jcenter()
}

group = "${projectGroup}"
version = "${projectVersion}"

jacoco {
    version = "${jacocoVersion}"
}

lombok {
    version = "${lombokVersion}"
}

spotbugs {
    toolVersion = "${spotbugsVersion}"
    effort = "max"
    reportLevel = "low"
    tasks.spotbugsTest {
        isEnabled = false
    }
}


java {
    sourceCompatibility = org.gradle.api.JavaVersion.VERSION_11
    targetCompatibility = org.gradle.api.JavaVersion.VERSION_11
}

dependencies {
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    implementation("com.github.spotbugs:spotbugs:${spotbugsVersion}")
    implementation("org.apache.logging.log4j:log4j-core:${log4j2Version}")
    implementation("org.apache.logging.log4j:log4j-api:${log4j2Version}")
    implementation("org.apache.logging.log4j:log4j-slf4j18-impl:${log4j2Version}")

    testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
    testImplementation("org.assertj:assertj-core:${assertjVersion}")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
