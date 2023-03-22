
plugins {
  `java-library`
  id("io.github.kobylynskyi.graphql.codegen") version "5.7.0"
}

tasks.named<io.github.kobylynskyi.graphql.codegen.gradle.GraphQLCodegenGradleTask>("graphqlCodegen").configure {
  graphqlSchemaPaths = listOf(
    "$projectDir/schema.graphqls"
  )
  outputDir = File("$buildDir/generated")

  customAnnotationsMapping = mutableMapOf(
    Pair("ReproInput.reproField", listOf("""@com.fasterxml.jackson.annotation.JsonProperty("reproField")"""))
  )

  generatedAnnotation = "javax.annotation.Generated"
}

