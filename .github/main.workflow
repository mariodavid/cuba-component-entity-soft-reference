workflow "Build and Test" {
  on = "push"
  resolves = ["Build"]
}

action "Build" {
  uses = "MrRamych/gradle-actions@1.0"
  args = "startDb createTestDb check assemble"
}

workflow "Release" {
  resolves = ["Execute Gradle task"]
  on = "release"
}

action "Execute Gradle task" {
  uses = "MrRamych/gradle-actions@1.0"
  args = "clean assemble bintrayUpload --debug"
  secrets = ["UPLOAD_REPOSITORY_PASSWORD", "UPLOAD_REPOSITORY_USERNAME"]
}
