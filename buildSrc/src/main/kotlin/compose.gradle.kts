import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val libs = the<LibrariesForLibs>()

plugins {
   id("org.jetbrains.kotlin.plugin.compose")
}

val stableClassesFile = project.layout.settingsDirectory.file("config/global_compose_stable_classes.txt")
composeCompiler {
   stabilityConfigurationFiles.add(stableClassesFile)
}

dependencies {
   add("implementation", libs.jetbrains.compose.ui)
   add("implementation", libs.jetbrains.compose.ui.graphics)
   add("implementation", libs.jetbrains.compose.ui.tooling.preview)
   add("implementation", libs.jetbrains.compose.material3)
   add("implementation", libs.androidx.lifecycle.compose)
   add("implementation", libs.kotlinova.compose)

   add("debugRuntimeOnly", libs.androidx.compose.ui.test.manifest)
   add("debugImplementation", libs.jetbrains.compose.ui.tooling)
   add("debugImplementation", libs.rebugger)
}
