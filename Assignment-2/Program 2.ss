(define alternate
    (lambda (lst)
      (if (null? lst)
          ('())
          (caddar alternate(lst)))))