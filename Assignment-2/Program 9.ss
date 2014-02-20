 (define contains
    (lambda (var lst2)
      (cond
        ((null? lst2) #f)
        ((equal? var (car lst2)) #t)
        (else (contains var (cdr lst2)))
        )))
 (define union
    (lambda (lst1 lst2)
      (cond
        ((null? lst1) lst2)
        ((null? lst2) lst1)
        (else #f)
        )))