# Reflection Questions

### Which solutions were easier to read: loop-based or stream-based?

I found stream-based solutions easier to read because they require less code and are more concise. Using methods such as
"filter()", "map()", and "count()" makes it easier to understand what the code is doing. However, loop-based solutions
were easier to understand initially because they show each step clearly which is helpful for beginners.

Example:Counting adults using Stream API
```java
long adultCount = people.stream()
.filter(p -> p.getAge() >= 18)
.count();
IO.println("Number of adults: " + adultCount);
```

With loops, we need to create a counter, check each person and increment the counter manually. However, Stream API 
requires less code and clearly expresses what we want to achieve.




### Which operations felt like transformations and which felt like side effects?

Operations such as "map()", "filter()", and "sorted()" felt like transformations because they produce new results
without changing the original data. On the other hand, "forEach()" felt like a side effect when used to print 
information to the console, because it performs an action rather than creating a new result.



### Where did Predicate, Function, and Consumer fit naturally?

I found that "Predicate" fits naturally with "filter()" because it checks conditions and returns a boolean value. 
"Function" fits with "map()" because it transforms data from one form into another, such as converting a Person object 
into a name. "Consumer" fits with "forEach()" because it performs an action, such as printing names, without returning 
a value.


