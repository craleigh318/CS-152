; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 5.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; The procedure Subst-First takes three parameters the first two are elements
; and the third is a list. The procedure will replace the first occurrences 
; of the second elemt with the first element. For example 'great 'bad '(today is a bad day)
; will output (today was a great day).
; The procedure uses a helper function called subst-first-suffix that takes 4
; parameters. It takes the three parameters from the subst-first procedure
; and an empty list. Prefix is the empty list that will become the new list
; suffix is the original list passed into the subst-first procedure
;
;
(define subst-first-suffix
  (lambda (new old prefix suffix)
    (cond
      ;if the suffix is null the return the prefix 
      ((null? suffix) prefix)
      ;check to see if the element to be replaced (old) is equal to the
      ;first element of the original list. if it is create a new list with
      ;the cdr of the original list
      ((equal? old (car suffix)) (append prefix (list new) (cdr suffix)))
      ;otherwise recursive call to subst-first-suffix with the new element
      ;the old element, the car of the old list now the(prefix) and the cdr
     ;of the original list, now the suffix
      (else (subst-first-suffix new old (append prefix (list (car suffix))) (cdr suffix))))))
;
;Calls the helper function with the parameters passed in pluss an empty list
(define subst-first
  (lambda (new old lst)
    (subst-first-suffix new old '() lst)))
;
;OUTPUT
;
;> (subst-first 'great 'bad '(today was a bad day))
;(today was a great day)
;> (subst-first 'dog 'cat '(my cat is smart))
;(my dog is smart)
;> (subst-first 'dog 'cat '(my cat is as smart as your cat))
;(my dog is as smart as your cat)
;> 