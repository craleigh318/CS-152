;
; NOT WORKING YET
;
> (define contains
    (lambda (var lst2)
      (cond
        ((null? lst2) #f)
        ((equal? var (car lst2)) #t)
        (else (contains var (cdr lst2)))
        )))
> (define union
    (lambda (lst1 lst2)
      (cond
        ((null? lst1) lst2)
        ((null? lst2) lst1)
        ((not (contains (car lst1) lst2)) (cons (car lst1) lst2))
        ((contains (car lst1) lst2) (union (cdr lst1) lst2))
        )))
> (union '(x g) '(o p))
(x o p)
> (union '(a b (c)) '(b (c) d))
(a b (c) d)
> (union '() '(a b c))
(a b c)
> (union '(x y z) '(a b c))
(x a b c)
> 