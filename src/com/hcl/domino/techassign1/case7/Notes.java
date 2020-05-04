package com.hcl.domino.techassign1.case7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class illustrates file CRUD operations i.e, Creating, Reading ,
 * Updating, Deleting the file upon user request.
 */
public class Notes {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// Displaying the program to the user.
				if (args.length == 0||args[0].equals("-h")||args[0].equals("--help")||args[0].equals("-H")||args[0].equals("--HELP"))  {
			System.out.println(
					"The description of the program\nThe program is used for performing the file operations\nEnter 1 to run the program");
		} else if (args[0].equals("1")) {
			// Asking for user input
			try {
				System.out.println(
						"select an option \n1.Add the config details\n2.Update the config details\n3.List the config details");

				int result = s.nextInt();
				switch (result) {
				case 1:
					addConfig();
					break;
				case 2:
					updateConfig();
					break;
				case 3:
					listConfig();
					break;
				default:
					System.out.println("Invalid input");
				}
			} catch (InputMismatchException | IOException ie) {
				System.out.println("Enter the valid input");
			}
		}
	}

	private static String DominoServer, cDirectory, iKitType, iInstallType, iPartitionNo, iControlStatusWindow, HCLDominoServer, faultRecovery, iTimezone, iDST,
			iDSTLaw, cFileDlgDir;

	/**
	 * This method adds the user input details to the file. It also checks for the
	 * file existence. If not present creates a new file at specified position.
	 * 
	 * @return null
	 * @throws IOException
	 */
	private static void addConfig() throws IOException {
		char moreRecords, ch;
		// Creating a file object at specific location
		File file = new File("notes.ini");
		// Checking for file existence
		if (!file.exists()) {
			// Create a new file if not exists.
			file.createNewFile();
			System.out.println("file is Created");
		}

		do {

			System.out.println("NotesProgram= ");
			DominoServer = s.next();
			System.out.println("Directory= ");
			cDirectory = s.next();
			System.out.println("KitType= ");
			iKitType = s.next();
			System.out.println("InstallType= ");
			iInstallType = s.next();
			System.out.println("PartitionNumber= ");
			iPartitionNo = s.next();
			System.out.print("ShowControllerStatusWindow= ");
			iControlStatusWindow = s.next();
			System.out.println("ServiceName= ");
			HCLDominoServer = s.next();
			System.out.println("FaultRecovery_Build= ");
			faultRecovery = s.next();
			System.out.print("Timezone= ");
			iTimezone = s.next();
			System.out.println("DST= ");
			iDST = s.next();
			System.out.println("DSTLAW= ");
			iDSTLaw = s.next();
			System.out.println("FileDlgDirectory= ");
			cFileDlgDir = s.next();
			// Asking for change in data entered
			System.out.println("Enter 'y' to save above information");
			ch = s.next().toLowerCase().charAt(0);
			if (ch == 'y') {
				// Creating the file writer object to write the data to file
				FileWriter fw = new FileWriter(file, true);
				// Creating the print writer object to write the data from console to file
				PrintWriter out = new PrintWriter(fw);
				out.println("NotesProgram=" + DominoServer);
				out.print("Directory= " + cDirectory);
				out.print("KitType=" + iKitType);
				out.print("InstallType=" + iInstallType);
				out.print("PartitionNumber=" + iPartitionNo);
				out.print("showControllerStatusWindow=" + iControlStatusWindow);
				out.print("ServiceName=" + HCLDominoServer);
				out.print("FaultRecovery_Build=" + faultRecovery);
				out.print("Timezone=" + iTimezone);
				out.print("DST=" + iDST);
				out.print("DSTLAW=" + iDSTLaw);
				out.print("FileDlgDirectory=" + cFileDlgDir);
				out.close();
				System.out.println("Information added");
			} else {
				addConfig();
			}
			// Asking for more records
			System.out.print("Do you want to add more records? (Y/N)");
			moreRecords = s.next().toLowerCase().charAt(0);
		} while (moreRecords == 'y');
	}

	/**
	 * This method is used to update the data present in the file
	 * 
	 * @return null
	 * @throws Exception
	 */
	private static void updateConfig() {
		try {

			// Get the name of the key to be updated
			System.out.println("Enter the key ");
			String Key = s.next();
			// Get the value to be updated
			System.out.println("Enter the value to be updated");
			String value = s.next();
			String KeyValueString, name;
			int index;
			// Using file pointer creating the file.
			File file = new File("notes.ini");
			if (!file.exists()) {
				// Create a new file if not exists.
				file.createNewFile();
			}
			// Opening file in reading and write mode.
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;
			// Checking whether the key already exists.
			// getFilePointer() give the current offset value from start of the file.
			while (raf.getFilePointer() < raf.length()) {
				// reading line from the file.
				KeyValueString = raf.readLine();
				if (KeyValueString.contains(Key)) {
					found = true;
					break;
				}
			}

			// Update the value if record exists.
			if (found == true) {
				// Creating a temporary file with file pointer as tmpFile.
				File tmpFile = new File("temp.ini");
				// Opening this temporary file in ReadWrite Mode
				RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw");
				// Set file pointer to start
				raf.seek(0);
				// Traversing the notes.ini file
				while (raf.getFilePointer() < raf.length()) {
					// Reading from the file
					KeyValueString = raf.readLine();
					index = KeyValueString.indexOf('=');
					name = KeyValueString.substring(0, index);
					// Check if the fetched key is the one to be updated
					if (name.equals(Key)) {
						// Update the value
						KeyValueString = name + "=" + value;
					}

					// Add this field in the temporary file
					tmpraf.writeBytes(KeyValueString);
					// Add the line separator in the temporary file
					tmpraf.writeBytes(System.lineSeparator());
				}

				// Since the value has been updated copy the updated content from the temporary
				// file to original file.
				// Set both files pointers to start
				raf.seek(0);
				tmpraf.seek(0);
				// Copy the contents from the temporary file to original file.
				while (tmpraf.getFilePointer() < tmpraf.length()) {
					raf.writeBytes(tmpraf.readLine());
					raf.writeBytes(System.lineSeparator());
				}

				// Set the length of the original file to that of temporary.
				raf.setLength(tmpraf.length());
				// Closing the resources.
				tmpraf.close();
				raf.close();
				// Deleting the temporary file
				tmpFile.delete();
				System.out.println(" File updated ");
			}
			// The key to be updated could not be found
			else {
				// Closing the resources.
				raf.close();
				System.out.println(" Key does not exists ");
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * This method is used to display the data present in the file
	 * 
	 * @return null
	 * @throws Exception
	 */
	private static void listConfig() {
		try {
			// open file to read
			File file = new File("notes.ini");
			Scanner scanner = new Scanner(file);

			if (!scanner.hasNextLine()) {
				scanner.close();
				file.delete();
				System.out.println("file deleted");
			} else {
				// read until end of file (EOF)
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
				}

				// close the scanner
				scanner.close();

			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);

		}
	}
}