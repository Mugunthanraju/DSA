# Introduction of Data Structures & Algorithms

### Abstract Data Types (ADTs)

1) For user-defined data types we also need to define operations. The implementation for these operations can be done when we want to use them. In general, User Defined Data Types are defined along with their operations.
2) To simply the process of solving problems, we combine the data structures[all possible DS which you think] with their operations and we call this Abstract Data Types(ADTs) which consist of two types (i) Declaration of Data (ii) Declaration of Operations.

### Algorithm

**An algorithm is the step by step unambiguous instructions to solve a given problem.**

*Judging of `Algorithm` is based on (i) `Correctness` and (ii) `Efficiency`.*

**Comparing Algorithms :-** *`Running Time` is considered but neither Execute Time nor Number of Statement.*

**Rate of Growth :-** *The rate at which the running time increases as a function of input is called `Rate of Growth`.*

**2²^n <- n! <- 4^n <- 2^n <- n² <- n log n <- log(n!) <- n <- 2^log n <- log²n <-(log n)½ <- log log n <- 1**

### Types of Analysis :-
 
 **Worst Case (Big O):-**
* Defines the input for which the algorithm takes a `long time`.
* Input is the one for which the algorithm runs the `slowest`.

 **Best Case (Omega Ω):-**
* Defines the input for which the algorithm takes the `least time`.
* Input is the one for which the algorithm runs the `fastest`.

**Average Case (Theta θ):-**
* Provides a prediction about the running time of the algorithm.
* Run the algorithm many times, using many different inputs that come
  from some distribution that generates these inputs, compute the total
  running time (by adding the individual times), and divide by the
  number of trials.
* Assumes that the input is random.

#### `Lower Bound <= Average Time <= Upper Bound`

### Asymptotic Notation :-

**Big O Notation [Upper Bounding Function] :-**
* This notation gives the tight upper bound of the given function. Generally, it is represented as f(n) = O(g(n)). That means, at larger values of n, the upper     bound of f(n) is g(n).

**Omega Ω Notation [Lower Bounding Function] :-**
* This notation gives the tighter lower bound of the given algorithm and we represent it as f(n) = Ω(g(n)). That means, at larger values of n, the tighter lower bound of f(n) is g(n).

**Theta θ Notation [Order Function] :-**
* This notation decides whether the upper and lower bounds of a given function (algorithm) are the same. The average running time of an algorithm is always between the lower bound and the upper bound. If the upper bound (O) and lower bound (Ω) give the same result, then the Θ notation will also have the same rate of growth.

### Guidelines for Asymptotic Analysis :_

**There are some general rules to help us determine the running time of an algorithm.**

1) **Loops:** The running time of a loop is, at most, the running time of the statements inside the loop (including tests) multiplied by the number of iterations.

```cpp
// executes n times
for(int i =1; i<=n; i++)
  m = m+2;
```
Total time = a constant c x n = cn = O(n).

2) **Nested loops:** Analyze for the inside out. Total running time is the product of the sizes of all the loops.

```cpp
//outer loop executed n times
for (i=1; i<=n; i++)
{
  //inner loop executes n times
  for(j=1; j<=n; j++)
  {
    k = k + 1; //constant time.
  }
}
```
Total time = c x n x n = cn² = O(n²).

3) Consecutive statements: Add the time complexities of each statements.

```cpp
x = x+1; //constant time
// executes n times
for(i=1; i<=n; i++){
  m = m + 2;
}
for(i=1; i<=n; i++){
  //inner loop executed n times
  for(j=1; j<=n; j++){
    k = k+1; //constant time
  }
}
```

Total time = c₀ + c₁n + c₂n² = O(n²).

4) **If-then-else statements:** Worst-case running time: the test, plus either the then part or the else part(whichever is the larger).
```cpp
//test:constant
if(length()==0) {
  return false; //then part: constant
}
else {
  // else part: (constant + constant) * n
  for(int n = 0; n < length(); n++) {
    // another if: constant + constant (no else part)
    if(!list[n].equals(otherList.list[n]))
    //constant
    return false;
  }
}
```
Total time = c₀ + c₁ + (c₂ + c₃) * n = O(n).

5) **Logarithmic Complexity:** An algorithm is O(log n) if it takes a constant time to cut the problem size by a fraction (usually by ½).

```cpp
for(i=1; i<=n;){
  i = i*2;
}
```
