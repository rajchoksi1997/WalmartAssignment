package MovieTheaterSeating.movieTheaterSeater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Solution {

  /* It reads input fills the theater and passes the output to output file  */


	
  public static void main(String[] args) {

    final String INPUT = "G:\\CodingAssignment\\src\\main\\java\\MovieTheaterSeating\\seating\\Reservations.txt";
    final String OUTPUT = "G:\\CodingAssignment\\src\\main\\java\\MovieTheaterSeating\\seating\\output.txt";
    //To read the contents of a file
    try (BufferedReader br = new BufferedReader(new FileReader(INPUT))) {
      movieTheater theatre = new Theater(10);
      StringBuilder result = new StringBuilder();
      String line = br.readLine();
      while (line != null) {
        String[] parse = line.split(" ");
        int noOfSeats = Integer.parseInt(parse[1]);
        String reservationNo = parse[0];
        result.append(theatre.fillRows(reservationNo, noOfSeats));
        line = br.readLine();
      }

      File file = new File(OUTPUT);
      BufferedWriter bwr = new BufferedWriter(new FileWriter(file));
      //writes the contents of StringBuffer to a file
      bwr.write(result.toString());
      //flushing the stream
      bwr.flush();
      //closing the stream
      bwr.close();
      System.out.println("\nOutput is at: "+file.getAbsoluteFile());

    }
    catch (FileNotFoundException e) {
      System.out.println("Caught Exception: File not found");
      e.printStackTrace();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }
}

