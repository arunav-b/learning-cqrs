pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
}

rootProject.name = "bank-account"

include("account.cmd", "account.common", "account.query", "cqrs.core")
