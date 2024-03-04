# Intructions to Get the StoneBridge Login Page Code Working:

0. Ensure Mavin & Java Environment Paths are Correct
	a. The environment variable paths should be set for Java 21's & Maven 3.9.6's bin files
	b. Here is what my Java environment path looks like: 'C:\Program Files\Eclipse Adoptium\jdk-21.0.1.12-hotspot\bin'
	c. And here is my Maven one: 'C:\Program Files\Maven\apache-maven-3.9.6-bin\apache-maven-3.9.6\bin'

1. Install MySQL Community with Installer
	a. Choose 'Full' setup type (so the workstation is included)
	b. Download & Install products
	c. Accept default settings 
	d. Make the root password: 'dwayneTheDwayneDwayneson!' (This can be something different if you are willing to change the application.properties file)
	e. Add a user for yourself with the DB admin role (so you can use the workstation)
	f. Continue process with default settings (just keep hitting 'next' or 'finish')
	g. Connect to the server with the rock password
	h. Continue to hit finish until the workstation launches
	
2. Install MySQL connecter Driver for Java
	a. Download .tar file titled 'mysql-connector-j-8.3.0.tar.gz'
	b. Open the command prompt and type 'tar -xvf ' (include the space at the end)
	c. Click and drag your .tar file to the end of your command to enter it's absolute path
	d. Hit enter and the driver should be installed
	
3. Set up 'loremaster_db' in MySQL Workstation
	a. Open MySQL Workstation (if it's not already open)
	b. Log in to the the root user with the rock password (should be at the bottom of the screen)
	c. Run the following SQL command in the query pane: CREATE DATABASE `loremaster_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
	d. Right-click the left navigation widow and clik 'refresh' to see the 'loremaster_db' Database and select it by clicking it
	e. Run the SQL command below:
	
	CREATE TABLE `lm_user` (
	  `user_id` bigint NOT NULL,
	  `username` varchar(255) DEFAULT NULL,
	  `user_email` varchar(255) DEFAULT NULL,
	  `user_password` varchar(255) DEFAULT NULL,
	  PRIMARY KEY (`user_id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	
4. Open the Loremaster Program in VSCode and run it
	a. If you didn't use 'dwayneTheDwayneDwayneson!' as the database's password, go to application.properties (if you did, skip to step c)
	b. Replace the password after the 'spring.datasource.password=' property to whatever you made it
	c. Run the code and visit 'http://localhost:8080/' in a web browser. (Don't accidentally put https instead of http!)
