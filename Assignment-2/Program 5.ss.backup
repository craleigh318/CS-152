; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 5.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
(define subst-first-suffix
  (lambda (new old prefix suffix)
    (cond
      ((null? suffix) prefix)
      ((equal? old (car suffix)) (append prefix (list new) (cdr suffix)))
      (else (subst-first-suffix new old (append prefix (list (car suffix))) (cdr suffix))))))

(define subst-first
  (lambda (new old lst)
    (subst-first-suffix new old '() lst)))