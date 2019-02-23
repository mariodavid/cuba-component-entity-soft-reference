workflow "Build and Test" {
  on = "push"
  resolves = ["Build"]
}

action "Build" {
  uses = "MrRamych/gradle-actions@1.0"
  args = "startDb createTestDb check assemble"
}
