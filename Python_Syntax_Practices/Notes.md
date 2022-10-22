# Notes for Basic Python Syntax and Programming#
# Updated 10.22.2022#

# 01. User Input

PYthon Exercise 01: Character Inputs

- datetime, input, convert str() and int()

- datetime.datetime.today().year
- [var] = input("prompt")

```
import datetime

name = input("What is your name?")
age = int(input("How old are you?"))

this_year = datetime.datetime.today().year
this_month= datetime.datetime.today().month
this_day = datetime.datetime.today().day

years = str(this_year + 100 - age)
print("OK " + name + ", you will be 100 years old in " + years)
print("Today is " + str(this_month) + "/" + str(this_day) + "/" + str(this_year))
```
