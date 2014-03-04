; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 3: Program.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; Evaluate x^n. lst is the list containing (^ n) and x is the value of x
(define evaluate-exponent
   (lambda (lst x)
     (cond
       ((null? lst) x)
       (else (expt x (eval (cadr lst))))
       )))
;
; Multiply multiple coefficients.
(define multiply
    (lambda (lst)
      (if (null? lst)
          1
          (* (eval (car lst)) (multiply (cdr lst))))))

; Return the evaluation of function f with respect to x.
;(map eval f needs to be added to upto x f)
(define evaluate
  (lambda (f x)
    (cond
      ((null? f) 0)
      ((member? '+ f) (evaluate (terminize f) x))
      ((list? (car f)) (+ (evaluate (car f) x) (evaluate (cdr f) x)))
      ((member? 'x f) (* (multiply (upto 'x f)) (evaluate-exponent (after 'x f) x)))
      (else (car f))
    )))
;
; Return the derivative of function f with respect to x.
;
(define evaluate-deriv
  (lambda (f x)
    (cond
    ((null? f) f)
    ((evaluate (deriv f 'x) x))
    )))