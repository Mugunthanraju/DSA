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
* Input is the one for which the algorithm runs the fastest.

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
