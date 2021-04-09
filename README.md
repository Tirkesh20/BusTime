The goal of this exercise is to create a console application to solve the problem described in the next
section and to do it in a way that shows understanding of programming concepts and structures. Console
application must take one argument — the path to input file and must generate “output.txt” as result.
Source code must be available on any public git repository

Given the information in the joint timetable, write a program to produce two modified timetables, one for
Posh Bus Company and one for Grotty Bus Company, each satisfying the following requirements:
1. All entries in each timetable are in order of departure time.
2. Any service longer than an hour shall not be included.
3. The provided timetable is valid for any day, i.e. tomorrow it will be the same.
4. There can be entries with departure time greater than arrival time. This means that the bus will arrive
tomorrow. E.g.: 23:03 00:01 defines that this service takes 58 minutes and the arrival will be tomorrow.
5. Only efficient services shall be added to the timetable. A service is considered efficient if there are no
other services that are more efficient compared to it. A service is considered more efficient compared to
the other one:
o If it starts at the same time and reaches earlier, or 

o If it starts later and reaches at the same time, or
o If it starts later and reaches earlier.
6. If both companies offer a service having the same departure and arrival times then always choose Posh
Bus Company over Grotty Bus Company, since Grotty Bus Company busses are not as comfortable as
those of Posh Bus Company
