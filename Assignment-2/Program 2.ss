; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 2.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; The procedure alternate takes a list as input
; and returns a new list containing everyother 
; element of the original list starting with the
; first element. For example if the user inputs
; (a b (c d) e f) the resulting output would be
; (a (c d) f) with the even elements removed 
; from the list and the odd elements remaining
;
(define alternate
  (lambda (lst)
    (cond
      ;If the list is null return empty list
      ((null? lst) '())
      ;If the cdr of the list is null
      ;add the car of the list to an empty list
      ((null? (cdr lst)) (cons (car lst) '()))
      ; recursive call to alternate with cddr of list
      (else (cons(car lst) (alternate(cddr lst)))))))
;
;OUTPUT
;> (alternate '(a b (c d) e f))
;(a (c d) f)
;> (alternate '())
;()
;> (alternate '(a b (c d) e f (g) (k l) p))
;(a (c d) f (k l))
;> 