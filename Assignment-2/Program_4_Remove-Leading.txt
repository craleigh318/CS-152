; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 4.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; Remove-Leading is a procedure that takes an element and a list as input
; If the element is in the list then a new list will be returned with all
; element that appeiered in the list before the target element removed.
; For example if remove-leading is called with 'x '(a b x g t) then the
; output will be (x g t) with a b removed from the list
(define remove-leading
  (lambda (item lst)
    (cond
      ;if the list is null then return empty list
      ((null? lst) '())
      ;if the first element in the list is the target element
      ;then return the list
      ((equal? item (car lst)) lst)
      ;else recursive call to remove-leading on the cdr of the list
      (else (remove-leading item (cdr lst))))))
;OUTPUT
;> (remove-leading 'x '(a b c x y z))
;(x y z)
;> (remove-leading 'x '(a b c))
;()
;> (remove-leading '(p q) '(a (p q) z))
;((p q) z)
;> (remove-leading '(p q) '((p q) a (p q) z))
;((p q) a (p q) z)
;> 