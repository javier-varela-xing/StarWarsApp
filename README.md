# Star Wars App

## Table of contents
1. [Description](#description)
2. [Continuous integration](#continuous-integration)
3. [Testing](#testing)

## Description
Small project to play with the Star Wars API: https://studio.apollographql.com/public/star-wars-swapi/variant/current/home

## Continuous integration
I use GitHub Actions to automate the execution of tests every time a pull request is made to the `main` branch as part of our continuous integration (CI) process.

The automated workflow includes:
- Unit tests
- Integration tests
- Screenshot tests

## Testing

### Unit tests
Ensure that individual components of our code function as expected, guaranteeing the robustness of the smallest building blocks of the system.

### Integration tests
Verify that different modules or services within our application interact correctly with one another, helping us identify issues at critical interaction points.

### Screenshot tests
Validate the visual consistency of the application by comparing automated screenshots, ensuring no design or UI regressions occur.

