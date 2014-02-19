> (define remove-leading
    (lambda (item lst)
      (cond
        ((null? lst) '())
        ((equal? item (car lst)) lst)
        ((not (equal? item (car lst)) remove-leading(item (cdr lst))))
        (else remove-leading(item (cdr lst))))))
> (remove-leading 'x '(x))
(x)
> (remove-leading 'x '(x g))
(x g)
> (remove-leading 'x '(a x g))
Exception: attempt to apply non-procedure x
Type (debug) to enter the debugger.
> 