; == CS 152 Section 05 Group: The Phantoms ==
; ======= Assignment 2: Program 6.ss ========
;
; By Christopher Raleigh and Brandon Rossi
;
;Translate is a procedure that translates the input word to the
;word that it is associated with in the list. For example to call
;translate 'baseball ((car race) (baseball sport)) would result in the
;out put sport
;
(define translate
  (lambda (word dictionary)
    (cond
      ;if the list is null then return the target word
      ((null? dictionary) word)
      ;if the target word equals the first word in the caar of the list
      ;return the cadar of the list, that is if the target word equals
      ;the first word of the first list return the second word of the first list
      ((equal? word (caar dictionary)) (cadar dictionary))
      ;otherwise recursively call translate with the cdr of the list,
      ;the second list 
      (else (translate word (cdr dictionary))))))
;
;OUTPUT
;> (translate 'cat '((dog chien) (cat chat)))
;chat
;> (translate 'dog '((dog chien) (cat chat)))
;chien
;> (translate 'dog '((race car) (baseball sport)))
;dog
;> (translate 'race '((race car) (baseball sport)))
;car
;> (translate 'baseball '((race car) (baseball sport)))
;sport
;> 