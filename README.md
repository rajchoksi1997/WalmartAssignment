The program is design for a seating assignment that maximizes both customer satisfaction and customer safety.

<h2>Assumptions</h2>
Seats will be booked in FIFO fasion i.e., on a first-come first-serve basis.<br/>
Initial reservations will have the seats farthest from the screen for better visibility and to ensure maximum customer satisfaction.<br/>
To maximise the customer satisfaction further we book all the seats in a single reservation together.<br/>
If the next available fartest row from the screen can't fit all the seats of a reservation then we move on to the next available row.<br/>
If the no.of seats requested are more than the available seats in the theater we inform the customer that the reservation is full.<br/>
To ensure maximum customer safety we take a buffer of three seats and one row for each reservation.<br/>


<h2>Functionalities of the program</h2>
It allows the users to book their seats and return them with the tickets or appropriate message if the seats are not available or full.

<h3>Classes:</h3>
eachRow: Class for a single row in the theater.<br/>
Theater: Class for theater and all the rows in it.<br/>
movieTheaterInterface: Interface for the theater which has the necessary methods to be implemented by all the classes extending it.<br/>
Driver: This is where the execution of the program begins.<br/>
