Real Estate Management System
This Java application represents a Real Estate Management System, which allows users to perform various operations related to property management. Users can log in, view property details, archive properties, update property information, and export property data to different file formats. The application interacts with a database to store and retrieve property information.
Usage
1.	Login Process: Users are required to log in with a username and password. The system uses an authentication manager to validate user credentials. This was my unique feature I thought it would be complementary to make it so that the users could not update the database as that would make the database insecure
2.	Main Menu: After successful login, users are presented with a menu to perform various operations such as archiving properties, selecting and saving properties, creating data, updating property details, and exiting the application.
3.	Property Operations: Admins can perform operations like updating and archiving properties. For example, archiving a property moves it to an 'Archive' table and deletes it from the 'Properties' table. While Users may only use the Select statement so that they do not change the database unnecessarily.
4.	Exporting Data: Users can export property data to different file formats, including text, JSON, and CSV. The exported files are named based on user input.
Features
•	Login Authentication: Ensures secure access to the system, with a limit on login attempts.
•	Property Management: Allows users to update, archive, and view property details.
•	Data Export: Supports exporting property data to various file formats for external use.
•	Database Interaction: Utilizes JDBC for connecting to a database and performing CRUD operations.
Database Connection
The application uses the doConnection method to establish a connection to the database. Ensure that the database is correctly configured, and connection details are updated in the code.
Authentication
User authentication is managed by the AuthenticationManager class. User credentials are verified against a predefined set of users loaded from the database during application startup.
Property Operations
Users can update property details, archive properties, and view selected property information. The application provides options to filter and order property data based on user input.
Exporting Data
Users can export property data to different file formats, including text, JSON, and CSV. The exported files are named based on user input, and the content is displayed on the console.
