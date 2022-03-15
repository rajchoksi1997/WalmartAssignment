package MovieTheaterSeating.movieTheaterSeater;

public class row {

  private char rowName;
  private int seatsEmpty;
  private int indexFilled;
  private boolean isFilled;


  /* constructor for the class which initializes the row with 20 empty seats and a rowName. */
  public row(char rowName) {
    this.rowName = rowName;
    this.seatsEmpty = 20;
    this.indexFilled = 0;
  }

  /* method to fill the seats in a particular row of the theater. */
  public String[] fillSeats(int numberOfSeats, String reservationNumber, Integer totalSeats) {

    StringBuilder result = new StringBuilder();
    int iters = Math.min(numberOfSeats, seatsEmpty);
    result.append(rowName).append(++indexFilled);
    for (int i = 1; i < iters; i++) {
      result.append("," + rowName).append(++indexFilled);
    }
    this.indexFilled += 3;

    this.seatsEmpty = this.seatsEmpty - (iters + 3);
    if(this.seatsEmpty < 0 ){
      totalSeats = totalSeats - (iters + this.seatsEmpty + 3);

    }else{

      totalSeats = totalSeats - (iters + 3);
    }
    System.out.println(totalSeats + " "+ numberOfSeats);

    if (this.seatsEmpty < 0) {
      isFilled = true;
    }
    String[] toReturn = new String[2];
    toReturn[0]= result.toString();
    toReturn[1]= Integer.toString(totalSeats);
    return toReturn;
  }

  /* getter method to check whether the row is filled completely. */
  public boolean isFilled() {
    return isFilled;
  }

  /* method to get the rowName of the row. */
  public char getName() {
    return rowName;
  }

  /* method to get the number of empty seats. */
  public int getEmptySeats() {
    return seatsEmpty;
  }

}
