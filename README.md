# Online Score Update App

The **Online Score Update App** is an Android application designed to provide live updates and details about sports fixtures. It is built using modern Android development practices and follows a clean architecture approach.

---

## Architecture Overview

The application is structured using **Clean Architecture** principles, ensuring separation of concerns and scalability. Below are the key layers and their responsibilities:

### 1. **Presentation Layer**
   - **Purpose**: Handles the UI and user interactions.
   - **Components**:
     - **Jetpack Compose**: Used for building the UI.
     - **ViewModels**: Manage UI-related data and handle business logic for the presentation layer.
     - **State Management**: Uses `StateFlow` for reactive UI updates.
   - **Files**:
     - `FixtureScreen.kt`: Displays the list of fixtures.
     - `FixtureDetailsScreen.kt`: Displays detailed information about a specific fixture.

### 2. **Domain Layer**
   - **Purpose**: Contains the core business logic and use cases.
   - **Components**:
     - **Use Cases**: Encapsulate business logic (e.g., `GetFixtureDetailsUseCase`).
     - **Models**: Define domain-specific data structures (e.g., `FixtureInfoItem`, `FixtureResult`).
   - **Files**:
     - `GetFixtureDetailsUseCase.kt`: Fetches fixture details from the repository.

### 3. **Data Layer**
   - **Purpose**: Handles data operations, including API calls and data transformations.
   - **Components**:
     - **Repositories**: Abstract data sources (e.g., `FixtureRepository`).
     - **Network Models**: Represent API responses (e.g., `FixturesNetworkResponse`).
     - **Mappers**: Convert network models to domain models.
   - **Files**:
     - `FixtureRepository.kt`: Interface for fetching fixtures and fixture details.
     - `FixturesNetworkResponse.kt`: Represents the API response for fixtures.

---

## Features

- **Live Fixture Updates**: Displays a list of ongoing and upcoming fixtures.
- **Fixture Details**: Provides detailed information about a selected fixture, including scores, teams, and events.
- **Search Functionality**: Allows users to search for fixtures by team names.

---

## Tech Stack

- **Kotlin**: Programming language.
- **Jetpack Compose**: UI toolkit.
- **Hilt**: Dependency injection.
- **Coroutines & Flow**: Asynchronous programming.
- **Retrofit**: API communication.
- **Gson**: JSON parsing.
- **Material Design 3**: UI design principles.

---

## Building the Application

Follow these steps to build and run the application from the Git repository:

### Prerequisites

1. **Android Studio**: Install the latest version.
2. **JDK 11**: Ensure Java 11 is installed.
3. **Git**: Ensure Git is installed on your system.

### Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/borgaveakshay/matchscoreapp.git
   cd OnlineScoreUpdateApp
   ```

2. **Open in Android Studio**:
   - Open Android Studio.
   - Select "Open an Existing Project" and navigate to the cloned repository.

3. **Sync Gradle**:
   - Android Studio will automatically sync the Gradle files. If not, click on `File > Sync Project with Gradle Files`.

4. **Build the Project**:
   - Select `Build > Make Project` or press `Ctrl + F9`.

5. **Run the Application**:
   - Connect an Android device or start an emulator.
   - Click on the `Run` button or press `Shift + F10`.
