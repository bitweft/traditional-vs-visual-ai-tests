## Traditional vs Visual AI Tests

This repo is to see how testing a basic login and home page using Visual AI differs from the traditional approach 

#### Pre-requisites
- Install the correct version of [chrome driver](https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver)
- Set environment variable `APPLITOOLS_API_KEY` with the correct value

#### Directory structure
- `traditional_tests`: This directory contains tests written using the traditional approach
- `visual_ai_tests`: This directory contains tests using visual AI approach (using Applitools eyes SDK)

#### Run Tests
- traditional_tests: `./gradlew clean test --tests "*TraditionalTest*"`
- visual_ai_tests: `./gradlew clean test --tests "*VisualAiTest*"`
- to run all tests: `./gradlew clean test`
