The program is design for a seating assignment that maximizes both customer satisfaction and customer safety.

Assumptions
Seats will be booked in FIFO fasion i.e., on a first-come first-serve basis.
Initial reservations will have the seats farthest from the screen for better visibility and to ensure maximum customer satisfaction.
To maximise the customer satisfaction further we book all the seats in a single reservation together.
If the next available fartest row from the screen can't fit all the seats of a reservation then we move on to the next available row.
If the no.of seats requested are more than the available seats in the theater we inform the customer that the reservation is full.
When the requested no.of seats in a reservation is more than 20 i.e., maximum of row capacity we inform the customer to consult the box office since it will be marked as a bulk booking.
To ensure maximum customer safety we take a buffer of three seats and one row for each reservation.

Functionalities of the program
It allows the users to book their seats and return them with the tickets or appropriate message if the seats are not available or full.

Classes:
eachRow: Class for a single row in the theater.
Theater: Class for theater and all the rows in it.
movieTheaterInterface: Interface for the theater which has the necessary methods to be implemented by all the classes extending it.
TheaterUnitTest: Unit test cases class to test different scenarios in the program.
Driver: This is where the execution of the program begins.
