

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class lockedMeBO {

	// class implementing the Business Operations
	public static int result = 0;

	public void displayFilesInAscending(String directoryPath) {
		try {
			// checking if the directory is valid
			File f = new File(directoryPath);
			boolean exists = f.exists();
			if (exists == false)
				System.out.println("Invalid directoryPath");

			// sorting and listing the files in the given directory
			else {
				int k = 0;
				// Creating an Arraylist having filenames from the given directory
				ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));

				// sorting the Arraaylist using bubble sort algorithm
				int n = names.size();
				String temp;
				for (int i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {

						// to compare one string with other strings
						if (names.get(i).compareTo(names.get(j)) > 0) {
							// swapping
							temp = names.get(i);
							names.add(i, names.get(j));
							names.add(j, temp);
						}
					}
				}

				// Listing the files for the User
				for (String s : names) {
					System.out.println(s);
					k++;
				}
				if (k == 0)
					System.out.println("No files in the directory");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addFileToDirectory(String fileName, String directoryPath) {

		try {
			// creating new file
			File f1 = new File(directoryPath + "/" + fileName);
			if (!f1.exists()) {
				f1.createNewFile();
				System.out.println("File created!");
			} else
				System.out.println("File already exists!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFileFromDirectory(String fileName, String directoryPath) {
		try {
			// deleting an existing file
			File f1 = new File(directoryPath + "/" + fileName);
			String str = f1.getCanonicalFile().getName();

			// for checking case sensitivity
			if ((f1.exists()) && (str.equals(fileName))) {
				f1.delete();
				System.out.println("File Deleted!");
			} else
				System.out.println("File not found!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchAFile(String fileName, String directoryPath) {

		try {
			// searching an existing file
			File f1 = new File(directoryPath);
			File f2 = new File(directoryPath + "/" + fileName);
			ArrayList<String> names = new ArrayList<String>(Arrays.asList(f1.list()));
			int last = (names.size());
			int first = 0;
			Collections.sort(names);

			// performing binary search
			while (first <= last) {
				int mid = (first + last) / 2;
				// for checking case sensitivity
				String str = f2.getCanonicalFile().getName();
				result = fileName.compareTo(names.get(mid));

				// file at position mid
				if ((result == 0) && (str.equals(fileName))) {
					System.out.println("File Exists in the given directory " + directoryPath);
					break;
				}
				// ignore right part
				else if (result > 0)
					first = mid + 1;
				// ignore left part
				else if (result < 0)
					last = mid - 1;
			}
			if (result != 0)
				System.out.println("File does not Exists in the given directory " + directoryPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
