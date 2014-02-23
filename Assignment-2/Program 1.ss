; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 1.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; nest is a procedure that constructs a nested
; set of lists based on the number passed into
; the procedure by the user. For example if a user
; passes in the number Two to procedure nest then 
; the resulting output will be ((())).
(define nest
    (lambda (number)
      (if (<= number 0) '()
          (list (nest (- number 1))))))
; OUTPUT
;> (nest 1)
;(())
;> (nest 2)
;((()))
;> (nest 5)
;(((((())))))
;> (nest 10)
;((((((((((()))))))))))
;> 