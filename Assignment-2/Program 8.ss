>   (define count 
    (lambda (item lst) 
    (cond 
      ((null? lst) 0)
      ((list? (car lst))(count item (car lst)))
      ((equal? item (car lst)) (+ 1 (count item (cdr lst))))
      (else (count item (cdr lst))))))
> (count 'x '(x h x (x h (x)) g))
4
> (count 'x '(x h x (x h (x)) x))
4
> 