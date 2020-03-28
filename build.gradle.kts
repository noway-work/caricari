import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.5.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

//ext {
//	postgresqlVersion = '42.1.4'
//	springBootDomaVersion = '1.1.1'
//	domaVersion = '2.19.0'
//}

repositories {
	mavenCentral()
}

processResources.destinationDir = compileJava.destinationDir
compileJava.dependsOn processResources

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
	compile("org.springframework.boot:spring-boot-devtools")

	// -------------------------------------------
	// postgresql
	// -------------------------------------------
	//compile "org.postgresql:postgresql:${postgresqlVersion}"

	// -------------------------------------------
	// Doma2
	// -------------------------------------------
	//compile "org.seasar.doma.boot:doma-spring-boot-starter:${springBootDomaVersion}"
	//compile "org.seasar.doma:doma:${domaVersion}"	
}
	   
tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
