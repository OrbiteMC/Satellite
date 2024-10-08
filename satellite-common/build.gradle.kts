plugins {
    `java-library`
    `maven-publish`
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    compileOnly(libs.annotations)
    api(libs.remapper)
    api(libs.mappingio)
    api(libs.diffpatch)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            this.groupId = "io.github.cabernetmc"
            this.version = rootProject.version.toString()
            from(components["java"])
        }
    }

    repositories {
        maven("https://maven.miles.sh/snapshots") {
            credentials {
                this.username = System.getenv("CABERNETMC_REPOSILITE_USERNAME")
                this.password = System.getenv("CABERNETMC_REPOSILITE_PASSWORD")
            }
        }
    }
}
