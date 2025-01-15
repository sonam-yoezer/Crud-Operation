# Crud Operation
- This task requires to develop a Java-based application for managing a Student Database.

# Core Features
### Add a Student:

Allow users to input student details such as:
- Student ID
- Name
- Age
- Course
- Save these details in the application.

### Update Student Information:

- Enable users to modify the details of an existing student using their Student ID.

### Delete a Student:

- Provide functionality to remove a student from the database using their Student ID.

### Search for a Student:

- Allow users to search for a specific student by their Student ID.

### Display All Students:

- Provide a way for users to view a list of all students currently stored in the database.

### Data Persistence:

- Save the student data to a file so that it can be retrieved when the application is restarted.
- Use file handling for saving and loading data (preferably with ObjectOutputStream and ObjectInputStream).

### Technical Requirements
- Use an ArrayList to store student objects in memory.

### Define a Student class with attributes:
- Student ID
- Name
- Age
- Course
- Implement CRUD operations (Create, Read, Update, Delete).
- Create a menu-driven interface so users can interact with the program through options.
- Handle basic exceptions:
- Invalid input
- Non-existent student IDs for update/delete operations
- Provide user-friendly messages and prompts.

### Program Goals
- Perform all CRUD operations on student data.
- Ensure data persistence by storing and retrieving data from a file.
- Validate user input and handle errors gracefully.
- Allow users to view the current list of students.
