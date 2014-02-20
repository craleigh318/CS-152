> (define count 
    (lambda (var lst) 
    (cond 
      ((null? lst) 0) 
      ((equal? var (car lst)) (+ 1 (count var (cdr lst))))
      (else (count var (cdr lst))))))
> (count 'x '(x))
1
> (count 'x '(x x x))
3
> (count 'x '(x x x g g h))
3
> (count 'x '(x x x g g h x))
4
; This should be 5 not working yet
> (count 'x '(x x x g g h x (x)))
4
> 