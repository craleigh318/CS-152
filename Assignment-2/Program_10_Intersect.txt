; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 10.ss =======
;
; By Christopher Raleigh and Brandon Rossi
;
; Procedure intersect takes two lists as input and produces that intersection of both lists
; For example the input '(a b (c)) '(a (c) d) will produce the output of (a b (c) d)
; The procedure uses a helper function called make-intersection
;
;make-intersection does the bulk of the work for this procedure it takes three parameters
;the two lists and the resulting intersection of the two lists
;the parameter intersection is a new list that contains the intersection of the two lists 
(define make-intersection
  (lambda (lst1 lst2 intersection)
    ;if either the first or second list are null then return an empty list 
    (if (or (null? lst1) (null? lst2)) 
        intersection
        ;otherwise if the first element of list one is in list two
        ;and the first element of list one is not in the intersection list then
        ;append it to the list intersection and recursively call make-intersection
        ;with the cdr of the first list, the second list, and the new intersection list
        (if (and (member (car lst1) lst2) (not (member (car lst1) intersection)))
            (make-intersection (cdr lst1) lst2 (append intersection (list (car lst1))))
            ;if the first element of the first list is in the intersection then 
            ;recursively call make-intersection with the cdr of the first list,
            ;the second list and the list intersection.
            (make-intersection (cdr lst1) lst2 intersection)))))
;
;The prodecure intersect takes two parameters and calls the helper function
;with those two parameters and an empty list
(define intersect
  (lambda (lst1 lst2)
    (make-intersection lst1 lst2 '())))
;
;OUTPUT
;> (intersect '(a b c) '())
;()
;> (intersect '(a b c) '(a b c))
;(a b c)
;> (intersect '(a b c) '(a b c g))
;(a b c)
;> (intersect '(a g c k l (g)) '(l a (g) b c g))
;(a g c l (g))
;> (intersect '(a b (c)) '(a (c) d))
;(a (c))
;> (intersect '(a b b c) '(b c c d))
;(b c)
;> (intersect '(a b c) '((c) d e))
;()
;> 