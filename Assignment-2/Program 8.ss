; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 8.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
; Count is a process that takes two inputs a target element and a list
; and counts the number of times the target element appears in the list
; the procedure uses a helper function called count-n that takes the target
; element and the list as well as a variable to keep track of the count
;
;helper function for count, takes an item a list and a variable for keeping count
(define count-n
  (lambda (item lst n)
    (cond
      ;if the list is null return n
      ((null? lst)
       n)
      ;if the target element is equal to the first item in the list
      ;recursively call count-n with the target element the cdr of the list
      ;and add 1 to the count
      ((equal? item (car lst))
       (count-n item (cdr lst) (+ n 1)))
      ;otherwise if the first item in the list is a list then recursively call
      ;count-n with the item the first element of the list which is itself a list
      ;and add that result with the count of a call to count-n with the cdr of
      ;the original list
      (else
        (if (list? (car lst))
            (+ (count-n item (car lst) 0)  (count-n item (cdr lst) n))
            ;else if its not a list then recursively call count-n on cdr of list
            (count-n item (cdr lst) n))))))
;
;procedure count takes a target item and a list to search and calls the helper function
(define count
  (lambda (item lst)
    (count-n item lst 0)))
; OUTPUT
;> (count 'x '())
;0
;> (count 'x '(x))
;1
;> (count 'x '(x g h x))
;2
;> (count 'x '(x g h x l x))
;3
;> (count 'x '(x g h x l x (x)))
;4
;> (count 'x '(x g h x l x (x x)))
;5
;> (count 'x '(x g h x l x (x g x)))
;5
;> (count 'x '(x g h x l x (x g x) j t p x))
;6
;> (count 'x '(x g h x l x (x g x) j t p x (h (x))))
;7
;> 