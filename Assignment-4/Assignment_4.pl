%== CS 152 Section 05 Group: The Phantoms ==
%======= Assignment 4: Program.pl ========
%By Christopher Raleigh and Brandon Rossi

%Facts
male(professor_plum).
male(colonel_mustard).
male(mr_green).
male(dr_black).
female(miss_scarrlet).
female(ms_peacock).
female(mrs_white).

person(professor_plum, botanist).
person(colonel_mustard, colonel).
person(colonel_mustard, cook).
person(miss_scarrlet, assistant).
person(ms_peacock, unknown).
person(mr_green, land_scaper).
person(mrs_white, maid).
person(dr_black, home_owner).

is_resident(dr_black).
is_resident(mrs_white).

killed(dr_black, candlestick, ballroom).

weapon(candlestick).
weapon(pipe).
weapon(revolver).
weapon(spanner).
weapon(knife).

location(eating, dining_room).
location(work, study).
location(cooking, kitchen).
location(relaxing, lounge).
location(walking, hall).
location(dancing, ballroom).
location(plants, conservatory).
location(books, library).
location(billiards, billiard_room).

likes(dr_black, dancing).
likes(dr_black, books).
likes(dr_black, billiards).
likes(dr_black, plants).
likes(professor_plum, work).
likes(professor_plum, relaxing).
likes(professor_plum, dancing).
likes(professor_plum, books).
likes(colonel_mustard, cooking).
likes(colonel_mustard, eating).
likes(colonel_mustard, billiards).
likes(miss_scarrlet, dancing).
likes(miss_scarrlet, walking).
likes(ms_peacock, relaxing).
likes(ms_peacock, plants).
likes(ms_peacock, work).
likes(mr_green, plants).
likes(mr_green, billiards).
likes(mrs_white, billiards).
likes(mrs_white, books).
likes(mrs_white, cooking).

%Rules
married(Suspect1, Suspect2) :- shares_hobby(Suspect1, Suspect2, Hobby1),
	shares_hobby(Suspect1, Suspect2, Hobby2),
	Hobby1 \= Hobby2,
	Suspect1 \= miss_scarrlet,
	Suspect2 \= miss_scarrlet,
	Suspect1 \= Suspect2,
	opposite_sex(Suspect1, Suspect2).
%shares any hobby
shares_hobby(Suspect1, Suspect2) :- likes(Suspect1, Hobby1),
	likes(Suspect2, Hobby1),
	Suspect1 \= Suspect2.
%shares specific hobby
shares_hobby(Suspect1, Suspect2, Hobby) :- likes(Suspect1, Hobby),
	likes(Suspect2, Hobby),
	Suspect1 \= Suspect2.

opposite_sex(Suspect1, Suspect2) :- ((male(Suspect1),
				      female(Suspect2));
				    (male(Suspect2),
				     female(Suspect1))).

preferred_weapon(Suspect1, revolver) :- person(Suspect1, colonel).
preferred_weapon(Suspect1, knife) :- person(Suspect1, cook).
preferred_weapon(Suspect1, candlestick) :- (likes(Suspect1, dancing);
					   likes(Suspect1, relaxing)).
preferred_weapon(Suspect1, pipe) :- is_strong(Suspect1).
preferred_weapon(Suspect1, spanner) :- (person(Suspect1, botanist);
				       preferred_weapon(Suspect1, pipe)).

person(Suspect1, cook) :- person(Suspect1, maid).
preferred_weapon(Suspect1, spanner) :- person(Suspect1, land_scaper).

is_strong(Suspect1) :- male(Suspect1).

is_visitor(Suspect1) :- \+ is_resident(Suspect1).

is_suspect(Suspect1) :- Suspect1 \= dr_black.

likes(Suspect1, cleaning) :- person(Suspect1, maid).
