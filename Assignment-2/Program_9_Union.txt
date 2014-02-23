; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 9.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; Procedure union takes two lists as input and returns the union of the two lists
; For example if the inputs are '(a b c) '(x y z) the the output would be
; (a b c x y z)
;
(define union
  (lambda (lst1 lst2)
    (cond
      ;if the first list is null then return the second list
      ((null? lst1) lst2)
      ;if the second list is null then return the first list
      ((null? lst2) lst1) 
      (else
        ;otherwise test to see if the first element of the second
        ;list is a member of the first list. If it is a member
        ;then recursively call union with first list and the 
        ;cdr of the second list. If its not a member of then 
        ;recursively calls union with a new list that contains the
        ;first list and the first element of the second list appended to each other
        ;and the cdr of the second list
        (if (member (car lst2) lst1)
            (union lst1 (cdr lst2));if it is a member
            ;not a member
            (union (append lst1 (list (car lst2))) (cdr lst2)))))))
;
;OUTPUT
;> (union '(a b (c)) '(b (c) d))
;(a b (c) d)
;> (union '() '(a b c))
;(a b c)
;> (union '(a b c d) '(a b c))
;(a b c d)
;>