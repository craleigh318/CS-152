(define nest
  (lambda (n lst)
    (if (> n 1)
        (nest (n - 1))
        (cons '())))) (define nest
    (lambda (number)
      (if (= number 0) '()
          (list (nest (- number 1))))))

> (nest 0)
()
> (nest 1)
(())
> (nest 2)
((()))
> (nest 3)
(((())))
> (nest 4)
((((()))))
> (nest 5)
(((((())))))
> 

