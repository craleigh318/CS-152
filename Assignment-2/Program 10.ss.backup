; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 10.ss =======
;
; By Christopher Raleigh and Brandon Rossi
;
(define make-intersection
  (lambda (lst1 lst2 intersection)
    (if (or (null? lst1) (null? lst2))
        intersection
        (if (and (member (car lst1) lst2) (not (member (car lst1) intersection)))
            (make-intersection (cdr lst1) lst2 (append intersection (list (car lst1))))
            (make-intersection (cdr lst1) lst2 intersection)))))

(define intersect
  (lambda (lst1 lst2)
    (make-intersection lst1 lst2 '())))