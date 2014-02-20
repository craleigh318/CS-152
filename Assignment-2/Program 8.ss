 (define count 
    (lambda (item lst) 
    (cond 
      ((null? lst) 0)
      ((list? (car lst))
       (equal? item (car lst)) (+ 1 (count item (cadar lst))))
      ((equal? item (car lst)) (+ 1 (count item (cdr lst))))
      (else (count item (cdr lst))))))
> (count 'x '(x x g x (a x)))
4
> (count 'x '(x x g x ))
3
> (count 'x '(x x g x (x)))
4
> (count 'x '(x x g x (x x))) ; this is wrong
4
> (count 'x '(x x g x (a x))) ; this is wrong
4
> (count 'x '(x x g x (a a))) ; this is wrong
4
> (trace count)
(count)
> (count 'x '(x x g x (a a)))
|(count x (x x g x (a a)))
| (count x (x g x (a a)))
| |(count x (g x (a a)))
| |(count x (x (a a)))
| | (count x ((a a)))
| | |(count x ())
| | |0
| | 1
| |2
| 3
|4
4
> (count 'x '(g g g g (a a)))
|(count x (g g g g (a a)))
|(count x (g g g (a a)))
|(count x (g g (a a)))
|(count x (g (a a)))
|(count x ((a a)))
| (count x ())
| 0
|1
1