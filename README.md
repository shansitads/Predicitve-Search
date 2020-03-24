# Predictive Searching Algorithm
### A test for @shansitads 's predictiveSearch algorithm <br>
I used a defaulting function to ensure that predictive search does not work if the array is geometrically progressing I did not implement some high-fi methods a s I was(am) a little tired and my brain is toast as of now.<br>The default method is in the function doSafetyCheck(), by implementing this I can (to some extent) ensure that your algorithm is safer and has a low chance of spouting errors, their is only one condition in which my function will fail and that is when someone enters a sequence like this
```java
0,10,10,10,10,10,10,10,10,10
```
if this is the input then my safety valve and your predictive search both will fail, it is possible to stop this by randomly checking the array but then it will make the code less efficient.<br>
Okay looks like I [gotta go](https://github.com/shansitads/GottaGo)
