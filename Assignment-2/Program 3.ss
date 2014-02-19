(define next-same?
  (lambda (element1 lst)
    (cond
      ((null? lst) #t)
      ((equal? element1 (car lst)) (next-same? element1 (cdr lst)))
      (else #f))))

(define all-same?
  (lambda (lst)
    (if (null? lst) #t
        (next-same? (car lst) (cdr lst)))))