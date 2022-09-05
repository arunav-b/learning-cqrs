plugins {
    id("org.springframework.boot") version ("2.7.3")
    id("io.spring.dependency-management") version ("1.0.13.RELEASE")
    id("java")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(":account.common"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.kafka:spring-kafka")

    compileOnly("org.projectlombok:lombok")
    runtimeOnly("mysql:mysql-connector-java")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.kafka:spring-kafka-test")
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

// plugins {
// 	id 'org.springframework.boot' version '2.7.3'
// 	id 'io.spring.dependency-management' version '1.0.13.RELEASE'
// 	id 'java'
// }
//
// group = 'com.techbank'
// version = '0.0.1-SNAPSHOT'
// sourceCompatibility = '17'
//
// configurations {
// 	compileOnly {
// 		extendsFrom annotationProcessor
// 	}
// }
//
// repositories {
// 	mavenCentral()
// }
//
// dependencies {
// 	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
// 	implementation 'org.springframework.boot:spring-boot-starter-web'
// 	implementation 'org.springframework.kafka:spring-kafka'
// 	compileOnly 'org.projectlombok:lombok'
// 	runtimeOnly 'mysql:mysql-connector-java'
// 	annotationProcessor 'org.projectlombok:lombok'
// 	testImplementation 'org.springframework.boot:spring-boot-starter-test'
// 	testImplementation 'org.springframework.kafka:spring-kafka-test'
// }
//
// tasks.named('test') {
// 	useJUnitPlatform()
// }
