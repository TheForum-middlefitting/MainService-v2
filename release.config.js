module.exports = {
  repositoryUrl: 'https://github.com/middlefitting/semanticTest',
  branches: ['main'],
  plugins: [
    "@semantic-release/commit-analyzer",
    "@semantic-release/release-notes-generator",
    "@semantic-release/npm",
    {
      "npmPublish": false
    }
  ]
}