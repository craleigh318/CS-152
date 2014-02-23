; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 7.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; Sandwich-First is a procedure that takes three inputs, two elements
; and a list. The procedure replaces the first occurrence of two successive
; ellements in the list, that match the second input element, with a "sandwhich"
; of the second input element then the first input element and finally the second
; input element. For example 'dog 'cat '(a cat is an animal a cat cat is not an animal)
; will produce the output of, a cat is an animal a cat dog cat is not an animal
; This procedure uses a helper function called sandwhich-first-suffix
;
;The helper function for sandwich-first takes 4 parameters
;two elements a and b, a new list, and the original list
(define sandwich-first-suffix
  (lambda (a b prefix suffix)
    (cond
      ;if the new list is null then return the old list
      ;this happens if the target word is not found in the list
      ((null? suffix) prefix)
      ;if there is no second element in the original list then return the old list
      ((null? (cdr suffix)) (append prefix suffix))
      ;checks for two occurrences of the second element in the list, if there is
      ;replace it with the sandwiched elements
      ((and (equal? b (car suffix)) (equal? b (cadr suffix))) (append prefix (list (car suffix)) (list a) (cdr suffix)))
      ;otherwise recursively call sandwich-first-suffix with the the two elements, a new list, and the cdr of the original list
      (else (sandwich-first-suffix a b (append prefix (list (car suffix))) (cdr suffix))))))
;
;The procedure sandwich-first calls the helper method with the 4 parameters
(define sandwich-first
  (lambda (a b lst)
    (sandwich-first-suffix a b '() lst)))
;
;OUTPUT
;> (sandwich-first 'cat 'dog '())
;()
;> (sandwich-first 'cat 'dog '(g))
;(g)
;> (sandwich-first 'cat 'dog '(a cat is an animal a cat cat is not an animal))
;(a cat is an animal a cat cat is not an animal)
;> (sandwich-first 'dog 'cat '(a cat is an animal a cat cat is not an animal))
;(a cat is an animal a cat dog cat is not an animal)
;> (sandwich-first 'meat 'bread '(bread cheese bread bread mustard))
;(bread cheese bread meat bread mustard)
;> 