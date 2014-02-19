> (define alternate
    (lambda (lst)
      (cond
       ((null? lst) '())
       ((null? (cdr lst)) (cons (car lst) '())) 
       (else (cons(car lst) (alternate(cddr lst)))))))
> (alternate '(a b c d e))
(a c e)
> (alternate '(a b (c d) e f (a (b c))a))
(a (c d) f a)
> (alternate '(a b c d))
(a c)
> (alternate '(a b c))
(a c)
> (alternate '(a b))
(a)
> 