pluginManagement {
    repositories.gradlePluginPortal()
    includeBuild("../cqrs-es/cqrs.core")
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
//    repositories.mavenCentra
}

rootProject.name = "bank-account"

include("account.cmd", "account.common", "account.query")
