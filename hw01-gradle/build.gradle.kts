plugins {
	id ("java")
	id ("org.springframework.boot") version "3.4.1"
	id ("io.spring.dependency-management") version "1.1.7"
}

group = "ru.kolesnikov"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

dependencies {
	val guavaVersion = "33.4.0-jre"

	implementation ("com.google.guava:guava:$guavaVersion")
	testRuntimeOnly ("org.junit.platform:junit-platform-launcher")
}


tasks.register("customFatJar", Jar::class) {
	archiveBaseName.set("fat-jar")
	archiveVersion.set("0.1")
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE

	manifest {
		attributes["Main-Class"] = "ru.kolesnikov.hw01gradle.Hw01GradleApplication"
	}

	from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
	with(tasks.jar.get())
}
