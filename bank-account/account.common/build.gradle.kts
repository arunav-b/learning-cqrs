plugins {
    id("org.springframework.boot") version ("2.7.3")
    id("io.spring.dependency-management") version ("1.0.13.RELEASE")
    id("my-java-library")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-test")
}

group = "com.techbank"
version = "1.0.0"

configurations {
    compileOnly {
        extendsFrom(annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}
