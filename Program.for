C     ===== CS 152 Section 05 Group: The Phantoms =====
C      ========= Assignment 1 Quadratic.for ==========
C     
C     CALCULATE THE QUADRATIC FORMULA
c     GIVEN INPUTS A, B, C FROM INPUT.IN
C     THE PROGRAM CALCULATES BOTH THE REAL AND IMAGINARY VALUES
C     AND OUTPUTS THE RESULTS
C     
C     BY Brandon Rossi, Christopher Raleigh, Naruchin Lohacharoon
C
      DOUBLE PRECISION A, B, C, X1R, X2R, X1I, X2I, DIS, X
      INTEGER COUNT
C      
      COUNT = 0
C
C     PRINTS THE FORMATTED HEADER FOR THE OUTPUT
C     (AN & IN COL 6 MEANS THAT THE FOLLOWING IS A CONTINUATION)
      WRITE (6, 2)
    2 FORMAT (/,1X,'COUNT'
     &,9X,'A',14X,'B',14X,'C',12X,'X1 REAL',8X,'X1 IMG',9X,'X2 REAL'
     &,8X,'X2 IMG',/)
C
C     READ IN THE THREE VARIABLES
    5 READ (5,100) A, B, C
  100 FORMAT (3F10.0)
C
C     IF A IS EQUAL TO 0 THEN QUIT THE PROGRAM
      IF (A .EQ. 0.0) GO TO 800
C
C     CALCULATE THE DIFFERENT PARTS OF THE FORMULA
C     AND STORE THEM IN TO VARIABLES
      X = -B / (2 * A)
      DIS = (B * B) - (4 * A * C)
C
C     IF THE DISCRIMINANT IS EQUAL TO 0
      IF (DIS .EQ. 0.0) GO TO 200
      GO TO 300
  200 X1R = X
      X2R = X
      X1I = 0
      X2I = 0
      COUNT = COUNT + 1 
      GO TO 600
C
C     IF THE DISCRIMINANT IS GREATER THAN 0
  300 IF(DIS .GT. 0.0) GO TO 400
      GO TO 500
  400 X1R = (-B + DSQRT((B * B) - 4 * A * C))/(2 * A)
      X2R = (-B - DSQRT((B * B) - 4 * A * C))/(2 * A)
      X1I = 0
      X2I = 0
      COUNT = COUNT + 1
      GO TO 600
C
C     IF THE DISCRIMINANT IS LESS THAN 0
  500 IF (DIS .LT. 0) GO TO 550
  550 X1R = X
      X2R = X
      X1I = DSQRT (-1 * DIS) / (2 * A)
      X2I = -1 * X1I
      COUNT = COUNT + 1
C     
C     PRINTS THE RESULTS OF THE CALCULATIONS 
  600 WRITE (6, 700) COUNT, A, B, C, X1R
      IF (X1I .NE. 0.0) WRITE (6, 750) X1I
      WRITE (6, 750) X2R
      IF (X2I .NE. 0.0) WRITE (6, 750) X2I
  700 FORMAT ('  ', I2, ': ', 1P4E15.4)
  750 FORMAT (E15.4)
      GO TO 5
  800 WRITE (6, 850) COUNT
  850 FORMAT (/, '  END OF PROGRAM: ', I2, ' CARDS READ.')   
C 
      RETURN
      END
