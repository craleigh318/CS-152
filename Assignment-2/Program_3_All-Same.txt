; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 3.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; All-Same is a procedure that takes a list as input and
; tests if the elements of the list are the same.
; If the elements are the same then the
; procedure will return true (#t), if at least one is different
; the procedure will return false (#f). For example ((a b) (a b))
; will return #t and ((a b) (a)) will return #f
; This procedure uses a helper function called next-same that takes as input
; the first element of the list (the first parameter) and checks it with 
; the remaining elements of the list (cdr lst) passed in as the second parameter.  
;
; Helper function for all-same takes two parameters (car list) (cdr list)
(define next-same?
  (lambda (element1 lst)
    (cond
      ;if the rest of the list is null then element is the only item in the list
      ((null? lst) #t)
      ;if the element equals the next element in the list recursive call to check the next
      ((equal? element1 (car lst)) (next-same? element1 (cdr lst)))
      ;otherwise return false if one element is different
      (else #f))))
;
;All-Same is a procedure that takes a list as input and returns true if
;all the elements in the list are the same and false if at least one is different
(define all-same?
  (lambda (lst)
    ;if the list is null return true
    (if (null? lst) #t
        ;else call the helper function with the first element of the list
        ;and the rest of the list
        (next-same? (car lst) (cdr lst)))))
;OUTPUT
;> (all-same? '(a))
;#t
;> (all-same? '(a b))
;#f
;> (all-same? '((a b) (a b)))
;#t
;> (all-same? '((a b) (a g)))
;#f
;> (all-same? '((a b) (a b) (a b)))
;#t
;> (all-same? '((a b) (a b) (a b) g))
;#f
;> 