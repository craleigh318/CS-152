> (define count 
    (lambda (item lst) 
    (cond 
      ((null? lst) 0)
      ((equal? item (car lst)) (+ 1 (count item (cdr lst))))
      ((list? (car lst))(count item (car lst)))
      (else (count item (cdr lst))))))
> (count 'x '(x (x) (x)))
2
> (count 'x '(x (x x) (x)))
3
> (trace count)
(count)
> (count 'x '(x (x x) (x)))
|(count x (x (x x) (x)))
| (count x ((x x) (x)))
| (count x (x x))
| |(count x (x))
| | (count x ())
| | 0
| |1
| 2
|3
3
> (count 'x '(x (x) (x)))
|(count x (x (x) (x)))
| (count x ((x) (x)))
| (count x (x))
| |(count x ())
| |0
| 1
|2
2
> (count 'x '(x g x h x))
|(count x (x g x h x))
| (count x (g x h x))
| (count x (x h x))
| |(count x (h x))
| |(count x (x))
| | (count x ())
| | 0
| |1
| 2
|3
3
> 