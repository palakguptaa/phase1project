package com.app.main;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.app.bo.FileBO;
import com.app.bo.impl.FileBOImpl;
import com.app.exception.BusinessException;
import com.app.model.File;

public class FileMain {

	public static void main(String[] args) {
		System.out.println("\t\t\t\t\t\t\t\tLOCKEDME.COM");
		System.out.println("\t\t\t\t\t\t\t\t*************");
		Scanner scanner = new Scanner(System.in);
		FileBO fileBO = new FileBOImpl();
		System.out.println("\n________________________________________________________________________________________________");		
		int ch,p;
		
		do
		{
			System.out.println("\n\n1. All Files\t  2. Perform Actions\t3. EXIT");
			ch = Integer.parseInt(scanner.nextLine());
			
			
			switch (ch) {
			case 1:
				
				List<File> fileList = fileBO.getAllFiles();
				if (fileList != null && fileList.size() > 0) {
					System.out.println("Total there are " +fileList.size() + " no of files with names as:");
					for (File p1 : fileList) {
						System.out.println(p1);
					}
				} else {
					System.out.println("No files in the app");
				}
				
				break;
			case 2:
				System.out.println("\n________________________________________________________________________________________________");		
				do {
					System.out.println("\n\n1. Add Files\t  2. Search File\t3. Go Back");
					p = Integer.parseInt(scanner.nextLine());
					
					switch(p) {
					
					case 1:
						System.out.println("Enter File details");
						System.out.println("Enter File name with txt extension (eg. name.txt)");
						String name = scanner.nextLine();
						System.out.println("Enter File Text");
						String text = scanner.nextLine();
				        
						try(FileWriter fw=new FileWriter(name, true);
								BufferedWriter bw=new BufferedWriter(fw);
								){
							bw.write(text);

						} catch (IOException e) {
							System.out.println(e);
						}
						
						File file = new File(name, text);
						file = fileBO.createFile(file);
						if (file != null && file.getId() != 0) {
							System.out.println("File created with below details");
							System.out.println(file);
						}
						break;
						
					case 2:
						System.out.println("Enter file ID to search");
						int id = Integer.parseInt(scanner.nextLine());
						try {
							File q = fileBO.getFileById(id);
							if (q != null) {
								System.out.println("Player with id " + id + " found with details ");
								System.out.println(q);
							}
						} catch (BusinessException e) {
							System.out.println(e.getMessage());
						}
						break;
					
					
					}
					
					
				}while(p!=3);

				break;


			}

	}while(ch!=3);
	System.exit(0);

}
}

