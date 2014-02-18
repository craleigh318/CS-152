(define nest
  (lambda (n lst)
    (if (> n 1)
        (nest (n - 1))
        (cons '())))) (define nest
    (lambda (number)
      (if (= number 0) '()
          (list (nest (- number 1))))))