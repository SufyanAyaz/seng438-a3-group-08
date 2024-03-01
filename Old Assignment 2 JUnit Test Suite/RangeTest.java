package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-5, 5);
    }
    
//    ---------------------TESTING intersects(double lower, double upper)---------------------
    
//    This test will imagine a range with a lower bound of -10.0 and an upper bound of 10.0 and will
//    check for an overlap between that range and the exampleRange from -5 to 5.
    @Test
    public void intersectionShouldHappenWhenLowerBoundLessThanUpperBound() {
    	double upper = 10.0;
    	double lower = -10.0;
//    	There is an overlap between the imaginary range and the exampleRange so method should return true for intersection
    	assertTrue("The example range should intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of 2.0 and an upper bound of 10.0 and will
//  check if an overlap can be found with only part of the imaginary range in the exampleRange from -5 to 5.
    @Test
    public void intersectionShouldHappenWhenOnlyOneBoundIsInExampleRange() {
    	double upper = 10.0;
    	double lower = 2.0;
//    	There is an overlap between the imaginary range and the exampleRange so method should return true for intersection
    	assertTrue("The example range should intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of 2.0 and an upper bound of 2.0 and will
//  check if an overlap can be found with an imaginary range of 0 in the exampleRange from -5 to 5.
    @Test
    public void intersectionShouldHappenWhenLowerBoundEqualsUpperBound() {
    	double upper = 2.0;
    	double lower = 2.0;
//    	There is an overlap between the imaginary range and the exampleRange so method should return true for intersection
    	assertTrue("The example range should intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of 5.0 and an upper bound of 10.0 and will
//  check if an overlap can be found with only the bound of the imaginary range in the exampleRange from -5 to 5.
    @Test
    public void intersectionShouldHappenWhenBoundIsOnBoundaryOfExampleRange() {
    	double upper = 10.0;
    	double lower = 5.0;
//    	There is an overlap between the imaginary range and the exampleRange so method should return true for intersection
    	assertTrue("The example range should intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of 6.0 and an upper bound of 10.0 and will
//  check if no overlap can be found when the imaginary range is separate from the exampleRange from -5 to 5.
    @Test
    public void intersectionShouldNotHappenWhenLowerBoundLessThanUpperBound() {
    	double upper = 10.0;
    	double lower = 6.0;
//    	There is no overlap between the imaginary range and the exampleRange so method should return false for intersection
    	assertFalse("The example range should not intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of 10.0 and an upper bound of -10.0 and will
//  check if no overlap can be found when the lower bound of the imaginary range is greater than the upper bound of the imaginary range.
    @Test
    public void intersectionShouldNotHappenWhenLowerBoundGreaterThanUpperBound() {
    	double upper = -10.0;
    	double lower = 10.0;
//    	There is no overlap between the imaginary range and the exampleRange so method should return false for intersection
    	assertFalse("The example range should not intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of NaN and an upper bound of 10.0 and will
//  check if no overlap can be found when the lower bound of the imaginary range is NaN.
    @Test
    public void intersectionShouldNotHappenWhenLowerBoundIsNaN() {
    	double upper = 10.0;
    	double lower = Double.NaN;
//    	There is no overlap between the imaginary range and the exampleRange so method should return false for intersection
    	assertFalse("The example range should not intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of -10.0 and an upper bound of NaN and will
//  check if no overlap can be found when the upper bound of the imaginary range is NaN.
    @Test
    public void intersectionShouldNotHappenWhenUpperBoundIsNaN() {
    	double upper = Double.NaN;
    	double lower = -10.0;
//    	There is no overlap between the imaginary range and the exampleRange so method should return false for intersection
    	assertFalse("The example range should not intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  This test will imagine a range with a lower bound of NaN and an upper bound of NaN and will
//  check if no overlap can be found when the both bounds of the imaginary range are NaN.
    @Test
    public void intersectionShouldNotHappenWhenBothBoundsAreNaN() {
    	double upper = Double.NaN;
    	double lower = Double.NaN;
//    	There is no overlap between the imaginary range and the exampleRange so method should return false for intersection
    	assertFalse("The example range should not intersect with this new range ", exampleRange.intersects(lower, upper));
    }
    
//  ---------------------TESTING getLength()---------------------
    
//    This test will create a range with a lower bound of -10.0 and an upper bound of 10.0 and will find the length of the range.
    @Test
    public void getLengthOfNormalRange() {
    	Range tempRange = new Range(-10.0, 10.0);
//    	This is a valid range so the getLength() method should return 20 as the length
    	assertEquals("Length of range should be 20 ", 20, tempRange.getLength(), 0.000000001d);
    }
    
//  This test will create a range with a lower bound of 0.0 and an upper bound of 0.0 and will find the length of the range.
    @Test
    public void getLengthOfZeroRange() {
    	Range tempRange = new Range(0.0, 0.0);
//    	This is a valid range so the getLength() method should return 0 as the length
    	assertEquals("Length of range should be 0 ", 0, tempRange.getLength(), 0.000000001d);
    }
    
//  This test will create a range with a lower bound of -1000000000000.0 and an upper bound of 1000000000000.0 and will find the length of the range.
    @Test
    public void getLengthOfLargeLargeRange() {
    	Range tempRange = new Range(-1000000000000.0, 1000000000000.0);
//    	This is a valid range so the getLength() method should return 2000000000000 as the length
    	assertEquals("Length of range should be 2000000000000 ", 2000000000000.0, tempRange.getLength(), 0.000000001d);
    }
    
//  This test will create a range with a lower bound of 10.0 and an upper bound of -10.0 and will find the length of the range.
    @Test(expected = IllegalArgumentException.class)
    public void getLengthOfRangeWithLowerBoundGreaterThanUpperBound() {
    	Range tempRange = new Range(10.0, -10.0);
//    	This is an invalid range where the lower bound is greater than the upper bound so the getLength() method should
//    	not even run and an IllegalArgumentException should be thrown.
    	assertEquals("Length of range should not exist", Double.NaN, tempRange.getLength(), 0.000000001d);
    }
    
//  This test will create a range with a lower bound of NaN and an upper bound of 10.0 and will find the length of the range.
    @Test
    public void getLengthOfRangeWithLowerBoundEqualToNaN() {
    	Range tempRange = new Range(Double.NaN, 10.0);
//    	This is an invalid range so the getLength() method should return NaN as the length
    	assertEquals("Length of range should not exist", Double.NaN, tempRange.getLength(), 0.000000001d);
    }
    
//  This test will create a range with a lower bound of -10.0 and an upper bound of NaN and will find the length of the range.
    @Test
    public void getLengthOfRangeWithUpperBoundEqualToNaN() {
    	Range tempRange = new Range(-10.0, Double.NaN);
//    	This is an invalid range so the getLength() method should return NaN as the length
    	assertEquals("Length of range should not exist", Double.NaN, tempRange.getLength(), 0.000000001d);
    }
    
//  This test will create a range with a lower bound of NaN and an upper bound of NaN and will find the length of the range.
    @Test
    public void getLengthOfRangeWithBothBoundsEqualToNaN() {
    	Range tempRange = new Range(Double.NaN, Double.NaN);
//    	This is an invalid range so the getLength() method should return NaN as the length
    	assertEquals("Length of range should not exist", Double.NaN, tempRange.getLength(), 0.000000001d);
    }
    
//  ---------------------TESTING contains(double value)---------------------
    
//    This test will try to see if the exampleRange from -5 to 5 contains the value 3.0
    @Test
    public void containsValueInRange() {
    	double value = 3.0;
//    	3.0 is a valid value that should be in the range so the contains method should return true.
    	assertTrue("The example range contains the value ", exampleRange.contains(value));
    }
    
//    This test will try to see if the value is still contained in the exampleRange if the value is equal to the lower bound
    @Test
    public void containsValueInRangeIfValueIsEqualToLowerBound() {
    	double value = -5.0;
//    	The value being equal to the lower bound still means it is a valid value that should be in the range so the contains method should return true.
    	assertTrue("The example range contains the value ", exampleRange.contains(value));
    }
    
//  This test will try to see if the value is still contained in the exampleRange if the value is equal to the upper bound
    @Test
    public void containsValueInRangeIfValueIsEqualToUpperBound() {
    	double value = 5.0;
//    	The value being equal to the upper bound still means it is a valid value that should be in the range so the contains method should return true.
    	assertTrue("The example range contains the value ", exampleRange.contains(value));
    }
    
//  This test will try to see if the value is still contained in the exampleRange if the value is greater than the upper bound
    @Test
    public void doesNotContainsValueInRangeIfValueIsGreaterThanUpperBound() {
    	double value = 6.0;
//    	The value being greater than the upper bound means it is a valid value that should not be in the range so the contains method should return false.
    	assertFalse("The example range does not contain the value ", exampleRange.contains(value));
    }
    
//  This test will try to see if the value is still contained in the exampleRange if the value is less than the lower bound
    @Test
    public void doesNotContainsValueInRangeIfValueIsLessThanLowerBound() {
    	double value = -6.0;
//    	The value being less than the lower bound means it is a valid value that should not be in the range so the contains method should return false.
    	assertFalse("The example range does not contain the value ", exampleRange.contains(value));
    }
    
//  This test will try to see if the value is still contained in the exampleRange if the value is NaN
    @Test
    public void doesNotContainsValueInRangeIfValueIsNaN() {
    	double value = Double.NaN;
//    	The value being NaN means it is a invalid value that should not be in the range so the contains method should return false.
    	assertFalse("The example range does not contain the value ", exampleRange.contains(value));
    }
    
//  ---------------------TESTING constrain(double value)---------------------
    
//    This test will try to see if the constrained value can be found if the value is in the exampleRange.
    @Test
    public void constrainedValueFoundInRange() {
    	double value = 3.8;
//    	The value being in the range means the constrained value is the value itself so the constrain method should return 3.8
    	assertEquals("Constrained value should be 3.8 ", 3.8, exampleRange.constrain(value), 0.000000001d);
    }
    
//  This test will try to see if the constrained value can be found as the upper bound if the value is equal to the upper bound.

    @Test
    public void constrainedValueFoundWhenValueEqualsUpperBound() {
    	double value = 5.0;
//    	The value being equal to the upper bound means it is still in the range and the constrained value is the value itself, so the constrain method should return 5
    	assertEquals("Constrained value should be 5 ", 5, exampleRange.constrain(value), 0.000000001d);
    }
    
//  This test will try to see if the constrained value can be found as the lower bound if the value is equal to the lower bound.
    @Test
    public void constrainedValueFoundWhenValueEqualsLowerBound() {
    	double value = -5.0;
//    	The value being equal to the lower bound means it is still in the range and the constrained value is the value itself, so the constrain method should return -5
    	assertEquals("Constrained value should be -5 ", -5, exampleRange.constrain(value), 0.000000001d);
    }
    
//  This test will try to see if the constrained value can be found as the upper bound if the value is greater than the upper bound.
    @Test
    public void constrainedValueFoundWhenValueGreaterThanUpperBound() {
    	double value = 6.2;
//    	The value being greater than the upper bound means the constrained value is the upper bound, so the constrain method should return 5
    	assertEquals("Constrained value should be 5 ", 5, exampleRange.constrain(value), 0.000000001d);
    }
    
//  This test will try to see if the constrained value can be found as the upper bound if the value is way greater than the upper bound.
    @Test
    public void constrainedValueFoundWhenValueIsWayLargerThanUpperBound() {
    	double value = 6000000000.2;
//    	The value being way greater than the upper bound still means the constrained value is the upper bound, so the constrain method should return 5
    	assertEquals("Constrained value should be 5 ", 5, exampleRange.constrain(value), 0.000000001d);
    }
    
//  This test will try to see if the constrained value can be found as the lower bound if the value is less than the lower bound.
    @Test
    public void constrainedValueFoundWhenValueLessThanLowerBound() {
    	double value = -6.2;
//    	The value being less than the lower bound means the constrained value is the lower bound, so the constrain method should return -5
    	assertEquals("Constrained value should be -5 ", -5, exampleRange.constrain(value), 0.000000001d);
    }
    
//  This test will try to see if the constrained value can be found as the lower bound if the value is way less than the lower bound.
    @Test
    public void constrainedValueFoundWhenValueIsWayLowerThanLowerBound() {
    	double value = -6000000000.2;
//    	The value being way less than the lower bound still means the constrained value is the lower bound, so the constrain method should return -5
    	assertEquals("Constrained value should be -5 ", -5, exampleRange.constrain(value), 0.000000001d);
    }
    
//  This test will try to see if the constrained value can be found if the value is NaN.
    @Test
    public void constrainedValueNotFoundWhenValueIsNaN() {
    	double value = Double.NaN;
//    	The value being NaN means there is no constrained value for it, so the constrain method should return NaN.
    	assertEquals("No constrained value should be found ", Double.NaN, exampleRange.constrain(value), 0.000000001d);
    }
    
//  ---------------------TESTING combine(Range range1, Range range2)---------------------
    
//    This test will create two non-null ranges and see if they properly combine.
    @Test
    public void combiningTwoNonNullRanges() {
    	Range range1 = new Range(1, 15);
    	Range range2 = new Range(-15, 0);
    	Range combinedRange = Range.combine(range1, range2);
//    	The two non-null ranges are valid ranges and the combine method should return a range with a lower bound of -15 and an upper bound of 15
    	assertEquals("The lower bound of the new range is -15 ", -15, combinedRange.getLowerBound(), 0.000000001d);
    	assertEquals("The upper bound of the new range is 15 ", 15, combinedRange.getUpperBound(), 0.000000001d);
    }
    
//  This test will create range1 as a null and range2 as a non-null range and see if they properly combine.
    @Test
    public void combiningNullRange1WithNonNullRange2() {
    	Range range1 = null;
    	Range range2 = new Range(1, 15);
    	Range combinedRange = Range.combine(range1, range2);
//    	The null range will simply be ignored and the combine method should return the second range back with a lower bound of 1 and an upper bound of 15
    	assertEquals("The lower bound of the new range is 1 ", 1, combinedRange.getLowerBound(), 0.000000001d);
    	assertEquals("The upper bound of the new range is 15 ", 15, combinedRange.getUpperBound(), 0.000000001d);
    }
    
//  This test will create range2 as a null and range1 as a non-null range and see if they properly combine.
    @Test
    public void combiningNullRange2WithNonNullRange1() {
    	Range range1 = new Range(-15, 0);
    	Range range2 = null;
    	Range combinedRange = Range.combine(range1, range2);
//    	The null range will simply be ignored and the combine method should return the first range back with a lower bound of -15 and an upper bound of 0
    	assertEquals("The lower bound of the new range is -15 ", -15, combinedRange.getLowerBound(), 0.000000001d);
    	assertEquals("The upper bound of the new range is 0 ", 0, combinedRange.getUpperBound(), 0.000000001d);
    }
    
//  This test will create two null ranges and see if they properly combine.
    @Test
    public void combiningTwoNullRanges() {
    	Range range1 = null;
    	Range range2 = null;
    	Range combinedRange = Range.combine(range1, range2);
//    	The two null ranges are valid ranges and the combine method should return a null
    	assertNull("The combined range should be null ", combinedRange);
    }
    
//  This test will create range1 as invalid and see if it properly combines with range2.
    @Test(expected = IllegalArgumentException.class)
    public void combiningInvalidRange1WithValidRange2() {
    	Range range1 = new Range(15, 1);
    	Range range2 = new Range(-15, 0);
    	Range combinedRange = Range.combine(range1, range2);
//    	Range1 is invalid so an IllegalArgumentException should be thrown
    }
    
//  This test will create range2 as invalid and see if it properly combines with range1.
    @Test(expected = IllegalArgumentException.class)
    public void combiningInvalidRange2WithValidRange1() {
    	Range range1 = new Range(1, 15);
    	Range range2 = new Range(0, -15);
    	Range combinedRange = Range.combine(range1, range2);
//    	Range2 is invalid so an IllegalArgumentException should be thrown
    }
    
//  This test will create two invalid ranges and see if they properly combine.
    @Test(expected = IllegalArgumentException.class)
    public void combiningTwoInvalidRanges() {
    	Range range1 = new Range(15, 1);
    	Range range2 = new Range(0, -15);
    	Range combinedRange = Range.combine(range1, range2);
//    	The two null ranges are invalid ranges so an IllegalArgumentException should be thrown
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}