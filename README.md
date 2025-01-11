# JWT Authentication Lesson

This repository is part of a lesson on implementing JWT (JSON Web Token) authentication in an application. It demonstrates how to integrate JWT-based authentication in both frontend and backend systems. The repository contains two versions of the application: a basic unsecured version and a secured version.

## Repository Structure

The repository is organized into the following structure:

```
.
|-- FrontEnd/     # Angular frontend application
|-- BackEnd/      # Spring Boot backend application
```

### Frontend
- A dashboard application built with Angular.
- Displays a list of data retrieved from the backend.

### Backend
- A Spring Boot application.
- Exposes an endpoint to provide data for the frontend.

## Branches

### Master Branch
The `master` branch contains the basic version of the application without any security. The purpose of this version is to demonstrate the functionality before integrating authentication.

- **Frontend**: Loads a list of data from the backend and displays it on the dashboard.
- **Backend**: Provides a data endpoint for the frontend.

### SecuredApp Branch
The `SecuredApp` branch contains the secured version of the application, where JWT-based authentication has been added.

- **Frontend**:
  - Implements user login functionality.
  - Includes JWT token storage and usage for authenticated API calls.
  - Ensures restricted access to the dashboard.

- **Backend**:
  - Protects the data endpoint with JWT authentication.
  - Includes user authentication and token generation.

## Supporting Materials

This repository is accompanied by:

- **Video**: A step-by-step walkthrough of the implementation process.
- **Presentation**: Slides explaining the key concepts and implementation details of JWT authentication.

## How to Use This Repository

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Switch between branches to explore the unsecured and secured versions:
   ```bash
   git checkout master       # To view the unsecured version
   git checkout SecuredApp   # To view the secured version
   ```

3. Run the applications:

   ### Backend
   - Navigate to the `backend` folder:
     ```bash
     cd backend
     ```
   - Run the Spring Boot application:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Alternatively, you can run the backend using IntelliJ IDEA or Eclipse:
     - **IntelliJ IDEA**:
       1. Open the `backend` folder as a project in IntelliJ IDEA.
       2. Locate the `Application` class (usually in the `src/main/java` folder).
       3. Right-click on the class and select `Run 'Application'`.
     - **Eclipse**:
       1. Import the `backend` folder as an existing Maven project.
       2. Locate the `Application` class in the `src/main/java` folder.
       3. Right-click on the class and select `Run As > Java Application`.

   ### Frontend
   - Navigate to the `frontend` folder:
     ```bash
     cd frontend
     ```
   - Install dependencies and start the Angular application:
     ```bash
     npm install
     ng serve
     ```

4. Follow the video and presentation to understand how the JWT authentication has been implemented.

## License
This project is for educational purposes only and is licensed under the MIT License. Feel free to use and modify it as needed.

---

Happy coding! 🎉

