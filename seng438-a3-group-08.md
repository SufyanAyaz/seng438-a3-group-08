**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group: 08      |
|-----------------|
| Student 1: Sufyan Ayaz                |   
| Student 2: Muhammad Haris Kashif              |   
| Student 3: Faisal Islam               |   
| Student 4: Taha Khan                |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text…

# 2 Manual data-flow coverage calculations for calculateColumnTotal() and constrain() methods

## DataUtilities Class Data-Flow Coverage: calculateColumnTotal(Values2D data, int column) Method

### Data Flow Graph

![calculateColumnTotal Data Flow Graph](data-flow-images/calculateColumnTotalDataFlowGraph.jpg)

### The Def-Use Sets per Statement

| Node | Statement                                        | Def     | C-Use           | P-Use          |
|------|--------------------------------------------------|---------|-----------------|----------------|
| 1    | public static double calculateColumnTotal(Values2D data, int column) | {data, column} | {} | {} |
| 2    | ParamChecks.nullNotPermitted(data, "data"); | {} | {} | {data} |
| 3    | double total = 0.0; | {total} | {} | {} |
| 4    | int rowCount = data.getRowCount(); | {rowCount} | {data} | {} |
| 5    | for (int r = 0; r < rowCount; r++) | {r} | {r} | {r, rowCount} |
| 6    | Number n = data.getValue(r, column); | {n} | {data, r, column} | {} |
| 7    | if (n != null) | {} | {} | {n} |
| 8    | total += n.doubleValue(); | {total} | {total, n} | {} |
| 9    | for (int r2 = 0; r2 > rowCount; r2++) | {r2} | {r2} | {r2, rowCount} |
| 10   | Number n = data.getValue(r2, column); | {n} | {data, r2, column} | {} |
| 11   | if (n != null) | {} | {} | {n} |
| 12   | total += n.doubleValue(); | {total} | {total, n} | {} |
| 13   | return total; | {} | {total} | {} |


### List of all DU-Pairs per Variable

| Variable | Node(s) Defined | Node(s) Used       | DU Pairs |
|----------|-----------------|--------------------|----------|
| data | 1 | {2, 4, 6, 10} | ({1, 2}, {1, 4}, {1, 6}, {1, 10}) |
| column | 1 | {6, 10} | ({1, 6}, {1, 10}) |
| total | {3, 8, 12} | {8, 12, 13} | ({3, 8}, {3, 12}, {3, 13}, {8, 8}, {8, 12}, {8, 13}, {12, 12}, {12, 13}) |
| rowCount | 4 | {5, 9} | ({4, 5}, {4, 9}) |
| r  | 5 | {5, 6} | ({5, 5}, {5, 6}) |
| n | {6, 10} | {7, 8, 11, 12} | ({6, 7}, {6, 8}, {10, 11}, {10, 12}) |
| r2 | 9 | {9, 10} | ({9, 9}, {9, 10}) |


### Test Cases and the DU-Pairs They Cover

| Test Case Name | Set of DU Pairs Covered By Test |
|----------------|---------------------------------|
| calculateColumnTotalForTwoValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 8}, {8, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {6, 8}, {9, 9}) |
| calculateColumnTotal_positiveValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 8}, {8, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {6, 8}, {9, 9}) |
| calculateColumnTotal_negativeValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 8}, {8, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {6, 8}, {9, 9}) |
| calculateColumnTotal_mixedValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 8}, {8, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {6, 8}, {9, 9}) |
| calculateColumnTotal_zeroValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 8}, {8, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {6, 8}, {9, 9}) |
| calculateColumnTotal_singleValue() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 13}, {4, 5}, {4, 9}, {6, 7}, {6, 8}, {9, 9}) |
| calculateColumnTotal_emptyValues2D() | ({1, 2}, {1, 4}, {3, 13}, {4, 5}, {4, 9}, {5, 5}, {9, 9}) |
| calculateColumnTotal_NaNValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {9, 9}) |
| calculateColumnTotal_largeValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 8}, {8, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {6, 8}, {9, 9}) |
| calculateColumnTotal_infinityValues() | ({1, 2}, {1, 4}, {1, 6}, {3, 8}, {8, 8}, {8, 13}, {4, 5}, {4, 9}, {5, 5}, {5, 6}, {6, 7}, {6, 8}, {9, 9}) |


### DU-Pair Coverage Calculation

23 pairs. Before displaying the calculations for DU-Pair coverage, we would like to point out that of the 24 DU-Pairs, 9 pairs would never be covered. This lack of coverage is due to a flaw in the logic of the second for loop in the calculateColumnTotal method, which makes it redundant, and not due to a lack of proper test cases being written. In order to have reached the code inside the second for loop, and cover the 9 missing DU-Pairs, the method would have to be re-written and the logic would have to be fixed. Therefore, the following 9 DU-Pairs are impossible to cover with the method written as it currently is, and can therefore be disregarded from the coverage calculation without consequence: 

- data: {1, 10}
- column: {1, 10}
- total: {3, 12}, {8, 12}, {12, 12}, {12, 13}
- n: {10, 11}, {10, 12}
- r2: {9, 10}

After disgarding the redundant DU-Pairs, we can use the remaining pairs to calculate the DU_Pair coverage as follows:

> DU-Pair Coverage = (Number of DU Pairs Covered / Total Number of DU Pairs Found) * 100% = (15 / 15) * 100% = 100%

As it can be see by the calculation stated above, the constrain(double value) method from the Range class has 100% coverage of the DU-Pairs associated with it.


## Range Class Data-Flow Coverage: constrain(double value) Method

### Data Flow Graph

![constrain Data Flow Graph](data-flow-images/constrainMethodDataFlowGraph.jpg)

### The Def-Use Sets per Statement

| Node | Statement                      | Def     | C-Use        | P-Use        |
|------|--------------------------------|---------|--------------|--------------|
| 1    | public double constrain(double value) | {value} | {} | {} |
| 2    | double result = value;         | {result} | {value} | {} |
| 3    | if (!contains(value))          | {} | {} | {value} |
| 4    | if (value > this.upper)        | {} | {} | {value, upper} |
| 5    | result = this.upper;           | {result} | {upper} | {} |
| 6    | else if (value < this.lower)   | {} | {} | {value, lower} |
| 7    | result = this.lower;           | {result} | {lower} | {} |
| 8    | return result;                 | {} | {result} | {} |


### List of all DU-Pairs per Variable

| Variable | Node(s) Defined | Node(s) Used | DU Pairs |
|----------|-----------------|--------------|----------|
| value    | 1 | {2, 3, 4, 6} | ({1, 2}, {1, 3}, {1, 4}, {1, 6}) |
| result   | {2, 5, 7} | 8 | ({2, 8}, {5, 8}, {7, 8}) |


### Test Cases and the DU-Pairs They Cover

| Test Case Name | Set of DU Pairs Covered By Test |
|----------------|---------------------------------|
| constrainedValueFoundInRange() | ({1, 2}, {1, 3}, {2, 8}) |
| constrainedValueFoundWhenValueEqualsUpperBound() | ({1, 2}, {1, 3}, {2, 8}) |
| constrainedValueFoundWhenValueEqualsLowerBound() | ({1, 2}, {1, 3}, {2, 8}) |
| constrainedValueFoundWhenValueGreaterThanUpperBound() | ({1, 2}, {1, 3}, {1, 4}, {5, 8}) |
| constrainedValueFoundWhenValueIsWayLargerThanUpperBound() | ({1, 2}, {1, 3}, {1, 4}, {5, 8}) |
| constrainedValueFoundWhenValueLessThanLowerBound() | ({1, 2}, {1, 3}, {1, 4}, {1, 6}, {7, 8}) |
| constrainedValueFoundWhenValueIsWayLowerThanLowerBound() | ({1, 2}, {1, 3}, {1, 4}, {1, 6}, {7, 8}) |
| constrainedValueNotFoundWhenValueIsNaN() | ({1, 2}, {1, 3}, {1, 4}, {1, 6}, {2, 8}) |


### DU-Pair Coverage Calculation

The DU-Pair coverage is calculated as follows:

> DU-Pair Coverage = (Number of DU Pairs Covered / Total Number of DU Pairs Found) * 100% = (7 / 7) * 100% = 100%

As it can be see by the calculation stated above, the calculateColumnTotal(Values2D data, int column) method from the DataUtilities class has 100% coverage of the DU-Pairs associated with it.

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

## combineIgnoringNaNAndNull()
```java
    @Test
    public void combineIgnoringNaNAndNull() {
    	double nan = Double.NaN;
    	Range range1 = new Range(nan, nan);
    	Range range2 = null;
    	Range range3 = Range.combineIgnoringNaN(range1, range2);
    	assertEquals("Range should just be null", null, range3);
    }
```
For this test case we defined the first range as a NaN range and the second as a null range so that the case where range2 is null and range1 is a NaN range would be covered, so that the return null statement in the nested conditional would be reached. This in turn increased our Statement and Branch coverage. 

## testEqualsWithUnequalUpperBound()
```java
    @Test
    public void testEqualsWithUnequalUpperBound() {
        Range range1 = new Range(0.0, 10.0);
        Range range2 = new Range(0.0, 5.0); // Different upper bound
        boolean eq = range1.equals(range2);
        assertFalse("Range 1 and Range 2 are not equal", eq);
    }
```
For this test cased we defined range1 and range2 with the same lower bounds but different upper bounds so that the case where range1 and range2 have the same lower bound but different upper bounds is not equal would be covered, so that the second conditional and its body pertaining to the upper bounds would execute after skipping the first conditional pertaining to the lower bounds. This in turn increased our Statement and Branch Coverage.


# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

## Range Class

### Statement/Line Coverage

![Range Statement/Line Coverage](Range-Coverage-Images/RangeStatement_LineCoverage.jpg)

### Branch Coverage

![Range Branch Coverage](Range-Coverage-Images/RangeBranchCoverage.jpg)

### Method (Condition) Coverage

![Range Method/Condition Coverage](Range-Coverage-Images/RangeMethodCoverage.jpg)

## DataUtilities Class

### Statement/Line Coverage

![DataUtilities Statement/Line Coverage](DataUtilitie-Coverage-Images/DataUtilitiesStatement_LineCoverage.jpg)

### Branch Coverage

![DataUtilities Branch Coverage](DataUtilitie-Coverage-Images/DataUtilitiesBranchCoverage.jpg)

### Method (Condition) Coverage

![DataUtilities Method/Condition Coverage](DataUtilitie-Coverage-Images/DataUtilitiesMethodCoverage.jpg)

# 6 Pros and Cons of coverage tools used and Metrics you report

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Sufyan: Overall, I felt that this lab was a great introduction to coverage testing and how important it is when developing software. The lab made it very easy to aclimate to the new EclEmma technology, and was very helpful in allowing me to understand white-box testing through its hands-on approach. Coverage was something I had never considered when debugging/testing code in the past, and so it was very useful with helping me understand how to create full-coverage tests in an intuitive and easy-to-understand way. 
