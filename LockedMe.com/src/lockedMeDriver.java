
import java.io.File;
import java.util.Scanner;

public class lockedMeDriver {

	public static void main(String[] args) {
		// The driver
		lockedMeBO BO = new lockedMeBO();
		Scanner scint = new Scanner(System.in);
		Scanner scstring = new Scanner(System.in);
		String directoryPath;
		String fileName;

		System.out.println("Welcome to LockedMe.com");
		System.out.println("Developer:Anjali Gopalakrishnan");
		int ch = 0;
		int i = 0;

		do {

			System.out.println("\n" + "---Enter your choice---");
			System.out.println("1.List files in ascending order");
			System.out.println("2.Perform file operations");
			System.out.println("3.Exit");
			if (scint.hasNextInt()) {
				ch = scint.nextInt();

				switch (ch) {
				// display files in ascending order
				case 1: {
					System.out.println("Enter the Directory Path without spaces eg(d:/java)");
					directoryPath = scstring.next();
					BO.displayFilesInAscending(directoryPath);
					break;
				}
				case 2: {
					do {
						System.out.println("\n" + "---Enter your choice---");
						System.out.println("1.Add file to the application");
						System.out.println("2.Delete file from the application");
						System.out.println("3.Search file in the application");
						System.out.println("4.Go back to Main menu");
						if (scint.hasNextInt()) {
							i = scint.nextInt();
							switch (i) {
							case 1: {
								// add a file to application
								System.out.println("Enter the Directory Path eg(d:/java)");
								directoryPath = scstring.next();
								File f = new File(directoryPath);
								boolean exists = f.exists();
								if (exists == false) {
									System.out.println("Invalid directoryPath");
									break;
								}
								System.out.println("Enter the filename");
								fileName = scstring.next();
								BO.addFileToDirectory(fileName, directoryPath);
								break;
							}
							case 2: {
								// delete file from application
								System.out.println("Enter the Directory Path eg(d:/java)");
								directoryPath = scstring.next();
								File f = new File(directoryPath);
								boolean exists = f.exists();
								if (exists == false) {
									System.out.println("Invalid directoryPath");
									break;
								}
								System.out.println("Enter the filename");
								fileName = scstring.next();
								BO.deleteFileFromDirectory(fileName, directoryPath);
								break;

							}
							case 3: {
								// search for a file
								System.out.println("Enter the Directory Path eg(d:/java)");
								directoryPath = scstring.next();
								File f = new File(directoryPath);
								boolean exists = f.exists();
								if (exists == false) {
									System.out.println("Invalid directoryPath");
									break;
								}
								System.out.println("Enter the full filename (eg:test.java)");
								fileName = scstring.next();
								BO.searchAFile(fileName, directoryPath);
								break;
							}
							case 4: {
								System.out.println("Going back to main menu.Enter your choice");
								break;
							}
							default: {
								System.out.println("Wrong Choice.Try again");
								i = 0;
							}
							}

						} else
							System.out.println("Invalid input.Enter an integer");
						scint = new Scanner(System.in);
						scstring = new Scanner(System.in);
					} while (i >= 0 && i <= 3);
					break;
				}
				case 3: {
					System.out.println("End of Application");
					break;
				}
				default:
					System.out.println("Enter right choice");
					ch = 0;
				}

			} else
				System.out.println("Invalid input.Enter an integer");
			scint = new Scanner(System.in);
			scstring = new Scanner(System.in);
		} while (ch >= 0 && ch < 3);

	}
}
