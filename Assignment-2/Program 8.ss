>   (define count 
    (lambda (item lst) 
    (cond 
      ((null? lst) 0)
      ((list? (car lst))
       (equal? item (car lst)) (+ 1(count item (cdr lst))))
      ((equal? item (car lst)) (+ 1 (count item (cdr lst))))
      (else (count item (cdr lst))))))
> (count 'x '(x x (x)))
3
> (count '(p q) '(a (p q) (b ((p q) c)) d))
2
> (count '(p q) '(a (p q) (b ((p q) (p q))) d))
2
> (trace count)
(count)
> (count '(p q) '(a (p q) (b ((p q) (p q))) d))
|(count (p q) (a (p q) (b ((p q) (p q))) d))
|(count (p q) ((p q) (b ((p q) (p q))) d))
| (count (p q) ((b ((p q) (p q))) d))
| |(count (p q) (d))
| |(count (p q) ())
| |0
| 1
|2
2
> 