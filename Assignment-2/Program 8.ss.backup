> (define count
    (lambda (var lst)
      (cond
        ((null? lst) 0)
        ((eq? var (car lst)) (+ 1 (count(var (cdr lst)))))
        (else (count(var (cdr lst)))))))
> (count 'x '(x))
Exception: attempt to apply non-procedure x
Type (debug) to enter the debugger.
> (count 'x '(x v))
Exception: attempt to apply non-procedure x
Type (debug) to enter the debugger.
> 