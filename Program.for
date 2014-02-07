C     ===== CS 152 Section 05 Group: The Phantoms =====
C      ========= Assignment 1 Quadratic.for ==========
C     
C     Calculate the quadratic formula 
c     given inputs A, B, C from input.in
C     The program calculates both the real and imaginary values
C     
C     BY Brandon Rossi, Christopher Raleigh, Naruchin Lohacharoon
C
      DOUBLE PRECISION A, B, C, X, Y, DIS, X1R, X2R, X1I, X2I
      INTEGER COUNT
C      
      COUNT = 0
C
      WRITE (6, 2)
    2 FORMAT ('COUNT     A     B     C     X1R     X1I     X2R     X2I')  
C
C     READ IN THE THREE VARIABLES
    5 READ (5,100) A, B, C
  100 FORMAT (3F10.0)
C
C     IF A IS EQUAL TO 0 THEN QUIT THE PROGRAM
      IF (A .EQ. 0.0) RETURN
C
C     CALCULATE THE DIFFERENT PARTS OF THE FORMULA
C     AND STORE THEM IN TO VARIABLES
      X = -B / (2 * A)
      DIS = (B * B) - (4 * A * C)
      Y = DSQRT (DIS)
C
C     IF THE DISCRIMINANT IS EQUAL TO 0
      IF (DIS .EQ. 0.0) GO TO 200
      GO TO 300
  200 X1R = X
      X2R = X
      X1I = 0
      X2I = 0
      COUNT = COUNT + 1
C     NOT SURE IF I NEED THIS NEXT STATEMENT 
      GO TO 600
C
C     IF THE DISCRIMINANT IS GREATER THEN 0
  300 IF(DIS .GT. 0.0) GO TO 400
      GO TO 500
  400 X1R = (-B + DSQRT((B * B) - 4 * A * C))/(2 * A)
      X2R = (-B - DSQRT((B * B) - 4 * A * C))/(2 * A)
      X1I = 0
      X2I = 0
      COUNT = COUNT + 1
      GO TO 600
C
  500 IF (DIS .LT. 0) GO TO 550
  550 X1R = X
      X2R = X
      X1I = DSQRT (-1 * DIS) / (2 * A)
      X2I = -1 * X1I
      COUNT = COUNT + 1
  600 WRITE (6, 700) A, B, C, X1R, X1I, X2R, X2I
  700 FORMAT (1P7E15.4)
      GO TO 5
C 
      RETURN
      END
C 
C     make a loop by having at the end go back up 
C     to the first read statement to keep reading all of the numbers
C
C     Have a first loop check if A = 0 for the end statement
C
C     Format the output to look good for readability
