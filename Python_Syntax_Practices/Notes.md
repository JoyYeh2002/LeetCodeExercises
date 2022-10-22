# Notes for Basic Python Syntax and Programming
- Updated 10.22.2022

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

# 02: Even or odd
- User inputs, control loops

```

num = int(input("Number input:\n"))
div = int(input("Number to divide by:\n"))

# Determine even or odd
if num % 2 == 0:
    print("This number is even.")
else:
    print("This number is odd.")
    
# Determine divisibility by 4
if num % 4 == 0:
    print("Num is also divisible by 4.")

# Check division evenness
if num % div == 0:
    print("Num and div divides nicely.")
```

# 03. Key press to exit loop
- One-liner list manipulation: [val for val in list if val < num]

```
import keyboard
import time
import sys

li = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]

exitProgram = False

# Implement the quit() function
def quit():
    global exitProgram
    exitProgram = True
    
# Set hotkey
keyboard.add_hotkey('q', lambda: quit())

# Main loop
while not exitProgram:
    
    num = int(input("What's the number to compare to?\n"))
    
    #except ValueError:
    #    print("Enter a number between 1 and 100:")
    #    continue
    
    if num >= 1 and num <= 100:
        print(f'You entered: {num}')
        
    else:
        print('Num must be in range.')
    
    ''' msvcrt isn't working...
    if msvcrt.kbhit():
        if ord(msvcrt.getch() == 32):
            print("You pressed space key to exit the program. Goodbye!")
            break
    '''
        
    print([elem for elem in li if elem < int(num)])
    time.sleep(1)

# Now we're out of the main loop
print("Bye! You pressed the q key to exit the program.")
sys.exit()
```
