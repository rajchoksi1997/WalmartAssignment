package MovieTheaterSeating.movieTheaterSeater;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;


public class Theater implements movieTheater {


  private List<row> rows;
  private List<row> sortedList;
  private Integer totalSeats;

  /* This is a constructor which initializes a theater with 10 rows and 200 empty seats that can be filled. */
  
  public Theater(int numberOfRows) {
    rows = new ArrayList<row>();
    int actualRows = (numberOfRows + 1) / 2;
    totalSeats = actualRows * 20;
    
    for (char ch = 'J'; ch > 'J' - numberOfRows; ch--) {
      rows.add(new row(ch));
    }

  }


  public String fillRows(String reservationNumber, int numberOfSeats) {
    StringBuilder result = new StringBuilder();
    if (numberOfSeats < 0 || reservationNumber == null) {

      result.append("Wrong input; either reservation number is null or number of seats is negative\n");
      return result.toString();
    }
    List<String> assignedSeats = new ArrayList<>();

    if (totalSeats.intValue() < numberOfSeats) {
      result.append(reservationNumber + " ").append("Sorry, the requested number of seats are not available at the moment in theater\n");
      return result.toString();
    }

    // To maximize the customer satisfaction further we book all the seats in a single reservation together and farthest from the screen.

    for(int i = 1;i<rows.size()+1;i=i+2) {
      if (rows.get(i).getEmptySeats() >= numberOfSeats) {
        String[] assigned = rows.get(i).fillSeats(numberOfSeats, reservationNumber, totalSeats);
        assignedSeats.add(assigned[0]);
        totalSeats =Integer.parseInt(assigned[1]);
        break;
      }
    }

    // When seats are not available in same row we split the seats.
    if (assignedSeats.isEmpty()) {

      sortedList = rows.stream().filter(row -> row.getName() % 2 != 0)
              .collect(Collectors.toList());
      Collections.sort(sortedList, (a, b) -> b.getEmptySeats() - a.getEmptySeats());
      int j = 0;

      while (j < sortedList.size() && numberOfSeats > 0) {
        if (!sortedList.get(j).isFilled()) {
          int temp = sortedList.get(j).getEmptySeats();
          String[] assigned = sortedList.get(j).fillSeats(numberOfSeats, reservationNumber,
                  totalSeats);
          assignedSeats.add(assigned[0]);
          totalSeats = Integer.parseInt(assigned[1]);
          numberOfSeats = numberOfSeats - Math.min(temp, numberOfSeats);
        }
        j++;
      }
    }

    result.append(reservationNumber).append(" ")
            .append(String.join(",", assignedSeats))
            .append("\n");
    return result.toString();

  }

  /* method to get the list of all rows in a theater.  */
  public List<row> getRow() {
    return rows;
  }

  /* method to get total available seats in the theater.  */
  public int getTotalNoOfSeats() {
    return totalSeats.intValue();
  }

}
