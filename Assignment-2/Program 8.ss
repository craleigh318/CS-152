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
(define count
  (lambda (item lst)
    (cond
      ((null? lst) 0)
      ((equal? item (car lst)) (+ 1 (count item (cdr lst))))
      ((list? (car lst))(count item (car lst)))
      (else (count item (cdr lst))))))
; OUTPUT
;|3
;3
;> (count '(p q) '(a (p q) (b ((p q) (p q))) 
;d))
;|(count (p q) (a (p q) (b ((p q) (p q))) d))
;|(count (p q) ((p q) (b ((p q) (p q))) d))
;| (count (p q) ((b ((p q) (p q))) d))
;| (count (p q) (b ((p q) (p q))))
;| (count (p q) (((p q) (p q))))
;| (count (p q) ((p q) (p q)))
;| |(count (p q) ((p q)))
;| | (count (p q) ())
;| | 0
;| |1
;| 2
;|3
;3
;> (count '(p q) '(a (p q) (b ((p q) c)) d))
;|(count (p q) (a (p q) (b ((p q) c)) d))
;|(count (p q) ((p q) (b ((p q) c)) d))
;| (count (p q) ((b ((p q) c)) d))
;| (count (p q) (b ((p q) c)))
;| (count (p q) (((p q) c)))
;| (count (p q) ((p q) c))
;| |(count (p q) (c))
;| |(count (p q) ())
;| |0
;| 1
;|2
;2