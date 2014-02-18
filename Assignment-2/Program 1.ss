(define nest
    (lambda (number)
      (if (<= number 0) '()
          (list (nest (- number 1))))))