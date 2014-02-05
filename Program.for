C     ===== HILBERT MAIN PROGRAM =====
C
C     INVERT A 5-BY-5 HILBERT MATRIX AND THEN INVERT THE INVERSE.
C
C     TEST SUBROUTINES THAT SOLVE SYSTEMS OF LINEAR EQUATIONS
C     USING LU DECOMPOSITION (WITHOUT ITERATIVE IMPROVEMENT).
C
C     AN EXAMPLE FORTRAN IV PROGRAM WRITTEN BY RON MAK FOR CS 152.
C     REFERENCE: COMPUTER SOLUTION OF LINEAR ALGEBRAIC SYSTEMS
C                BY GEORGE FORSYTHE AND CLEVE B. MOLER
C
      DOUBLE PRECISION A, B, C, X, Y, Z
      DOUBLE PRECISION H(5, 5)
      INTEGER N
      DOUBLE PRECISION DENOM
C
      N = 5
C
C     COMPUTE THE HILBERT MATRIX.
      DO 200 I = 1, N
          DO 100 J = 1, N
              DENOM = I + J - 1
              H(I, J) = 1.0/DENOM
  100     CONTINUE
  200 CONTINUE
C
      WRITE (6, 300)
  300 FORMAT (/'HILBERT MATRIX'/)
      CALL PRINT (H, N)
C
      CALL INVERT(N, H, H)
C
      WRITE (6, 400)
  400 FORMAT (/'HILBERT MATRIX INVERTED:'/)
      CALL PRINT (H, N)
C
      CALL INVERT (N, H, H)
C
      WRITE (6, 500)
  500 FORMAT (/'INVERSE HILBERT MATRIX INVERTED:'/)
      CALL PRINT (H, N)
C
      PAUSE
      STOP
      END
C
C     ===== SUBROUTINE DECOMP =====
C
      SUBROUTINE DECOMP (N, A, LU)
      INTEGER N
      DOUBLE PRECISION A(5, 5), LU(5, 5), SCALES(5), PS(5)
C
      INTEGER I, J, K, PIVOTX, NM1, PSI, PSK, PSN, KP1
      DOUBLE PRECISION NRMROW, PIVOT, SIZE, BIGGST, MULT
      COMMON PS
C
C     INITIALIZE PS, LU, AND SCALES.
      DO 200 I = 1, N
          PS(I) = I
          NRMROW = 0.0
C
          DO 100 J = 1, N
              LU(I, J) = A(I, J)
C
C             FIND THE LARGEST ROW ELEMENT.
              IF (NRMROW .GE. DABS(LU(I, J))) GO TO 100
                  NRMROW = DABS(LU(I, J))
  100     CONTINUE
C
C         SET THE SCALING FACTOR FOR ROW EQUILIBRATION.
          IF (NRMROW .NE. 0) GO TO 110
              SCALES(I) = 0.0
              CALL SINGLR(0)
              GO TO 200
C
  110     SCALES(I) = 1.0/NRMROW
  200 CONTINUE
C
C     GAUSSIAN ELIMINATION WITH PARTIAL PIVOTING.
C     PIVOT ROW K.
      NM1 = N-1
      DO 400 K = 1, NM1
          PIVOTX = 0
          BIGGST = 0.0
C
C         GO DOWN ROWS FROM ROW K.
          DO 300 I = K, N
              PSI = PS(I)
C
C             DIVIDE BY THE BIGGEST ROW ELEMENT.
              SIZE = DABS(LU(PSI, K))*SCALES(PSI)
C
              IF (BIGGST .GE. SIZE) GO TO 300
                  BIGGST = SIZE
                  PIVOTX = I
  300     CONTINUE
C
          IF (BIGGST .NE. 0.0) GO TO 310
              CALL SINGLR(1)
              GO TO 400
C
  310     IF (PIVOTX .EQ. K) GO TO 350
C
C             EXCHANGE ROWS.
              J = PS(K)
              PS(K) = PS(PIVOTX)
              PS(PIVOTX) = J
C
C         PIVOT ELEMENT.
  350     PSK = PS(K)
          PIVOT = LU(PSK, K)
C
C         GO DOWN REST OF ROWS.
          KP1 = K+1
          DO 380 I = KP1, N
              PSI = PS(I)
              MULT = LU(PSI, K)/PIVOT
              LU(PSI, K) = MULT
C
              IF (MULT .EQ. 0.0) GO TO 380
C
C                 INNER LOOP. ONLY THE COLUMN SUBSCRIPT VARIES.
                  DO 360 J = KP1, N
                      LU(PSI, J) = LU(PSI, J) - MULT*LU(PSK, J)
  360             CONTINUE
  380     CONTINUE
  400 CONTINUE
C
C     CHECK THE BOTTOM RIGHT ELEMENT OF THE PERMUTED MATRIX.
      PSN = PS(N)
      IF (LU(PSN, N) .EQ. 0.0) CALL SINGLR(2)
c
      RETURN 
      END
C
C     ===== SUBROUTINE SOLVE =====
C
      SUBROUTINE SOLVE(N, LU, B, X)
      INTEGER N
      DOUBLE PRECISION LU(5, 5), B(5), X(5), PS(5)
C
      INTEGER I, J, IM1, PSI, NP1, IBACK, IP1
      DOUBLE PRECISION DOT
      COMMON PS
C
C     LY = B : SOLVE FOR Y.
      DO 200 I = 1, N
          IM1 = I-1
          PSI = PS(I)
C
          DOT = 0.0
          DO 100 J = 1, IM1
              DOT = DOT + LU(PSI, J)*X(J)
  100     CONTINUE
          X(I) = B(PSI) - DOT
  200 CONTINUE
C
C     UX = Y : SOLVE FOR X
      NP1 = N+1
      DO 400 IBACK = 1, N
          I = NP1-IBACK
C         I = N, N-1, N-2, ..., 2, 1
C
          IP1 = I+1
          PSI = PS(I)
C
          DOT = 0.0
          DO 300 J = IP1, N
              DOT = DOT + LU(PSI, J)*X(J)
  300     CONTINUE
          X(I) = (X(I) - DOT)/LU(PSI, I)
  400 CONTINUE
C
      RETURN
      END
C
C     ===== SUBROUTINE INVERT =====
C
      SUBROUTINE INVERT(N, A, AINV)
      INTEGER N
      DOUBLE PRECISION A(5, 5), AINV(5, 5)
C
C     COMPUTE AINV = INVERSE(A). NOTE THAT A AND AINV
C     ARE OFTEN PASSED THE SAME MATRIX.
C
      DOUBLE PRECISION LU(5, 5), B(5), X(5)
      INTEGER I, J
C
      CALL DECOMP(N, A, LU)
C
      DO 300 J = 1, N
          DO 100 I = 1, N
              B(I) = 0.0
              IF (I .EQ. J) B(I) = 1.0
  100     CONTINUE
c
          CALL SOLVE(N, LU, B, X)
C
          DO 200 I = 1, N
              AINV(I, J) = X(I)
  200     CONTINUE
  300 CONTINUE
C
      RETURN
      END
C
C     ===== SUBROUTINE SINGLR =====
C
      SUBROUTINE SINGLR(WHY)
      INTEGER WHY
C
      GO TO (1, 2, 3), WHY
C
    1 WRITE (6, 10)
   10 FORMAT ('MATRIX WITH ZERO ROW IN DECOMPOSE.')
      RETURN
C
    2 WRITE (6, 20)
   20 FORMAT ('SINGULAR MATRIX IN DECOMPOSE.')
      RETURN
C
    3 WRITE (6, 30)
   30 FORMAT ('NO CONVERGENCE IN IMPROVE.')
      RETURN
C
      END
C
C     ===== SUBROUTINE PRINT =====
C
      SUBROUTINE PRINT (A, N)
      INTEGER N
      DOUBLE PRECISION A(5, 5)
C
      INTEGER I, J
C
      DO 100 I = 1, N
          WRITE (6, 10) (A(I, J), J = 1, N)
   10     FORMAT(5F15.6)
  100 CONTINUE
C
      RETURN
      END
