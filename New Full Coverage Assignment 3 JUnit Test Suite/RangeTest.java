package org.jfree.data;

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
    
    /*           NEW TESTS (Assignment 3 Increased Coverage)          */

//  ---------------------TESTING combineIgnoringNaN(Range range1, Range range2)---------------------

    /**
     * Test case for combining ranges while ignoring null parameters.
     * Tests the behavior when one of the ranges is null.
     */
    @Test
    public void combineIgnoringNullRange1() {
        Range range1 = new Range(1, 10);
        // Combining null and a valid range should ignore the null range.
        Range.combineIgnoringNaN(null, range1);
    }

    /**
     * Test case for combining ranges while ignoring null parameters.
     * Tests the behavior when one of the ranges is null.
     */
    @Test
    public void combineIgnoringNullRange2() {
        Range range1 = new Range(1, 10);
        // Combining a valid range and null should ignore the null range.
        Range.combineIgnoringNaN(range1, null);
    }

    /**
     * Test case for combining valid ranges.
     * Tests the behavior when both ranges are valid.
     */
    @Test
    public void combineIgnoringValidRanges() {
        Range range1 = new Range(1, 15);
        Range range2 = new Range(-15, 0);
        // Combining two valid ranges should yield the combined range.
        Range.combineIgnoringNaN(range1, range2);
    }

    /**
     * Test case for combining ranges with NaN as upper bound.
     * Tests the behavior when one range has NaN as its upper bound.
     */
    @Test
    public void combineIgnoringUpperNaN1() {
        double nan = Double.NaN;
        Range range1 = new Range(nan, 5);
        Range range2 = new Range(5, 10);
        // Combining a range with upper bound NaN should yield the other range.
        Range range3 = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Range should just be range2", range2, range3);
    }

    /**
     * Test case for combining ranges with NaN as lower bound.
     * Tests the behavior when one range has NaN as its lower bound.
     */
    @Test
    public void combineIgnoringLowerNaN1() {
        double nan = Double.NaN;
        Range range1 = new Range(5, nan);
        Range range2 = new Range(5, 10);
        // Combining a range with lower bound NaN should yield the other range.
        Range range3 = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Range should just be range2", range2, range3);
    }

    /**
     * Test case for combining ranges with NaN as upper bound.
     * Tests the behavior when one range has NaN as its upper bound.
     */
    @Test
    public void combineIgnoringUpperNaN2() {
        double nan = Double.NaN;
        Range range1 = new Range(5, 10);
        Range range2 = new Range(nan, 10);
        // Combining a range with upper bound NaN should yield the other range.
        Range range3 = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Range should just be range1", range1, range3);
    }

    /**
     * Test case for combining ranges with NaN as lower bound.
     * Tests the behavior when one range has NaN as its lower bound.
     */
    @Test
    public void combineIgnoringLowerNaN2() {
        double nan = Double.NaN;
        Range range1 = new Range(5, 10);
        Range range2 = new Range(5, nan);
        // Combining a range with lower bound NaN should yield the other range.
        Range range3 = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Range should just be range1", range1, range3);
    }

    /**
     * Test case for combining ranges with both bounds as NaN.
     * Tests the behavior when both ranges have NaN as bounds.
     */
    @Test
    public void combineIgnoringBothNaN() {
        double nan = Double.NaN;
        Range range1 = new Range(nan, nan);
        Range range2 = new Range(nan, nan);
        // Combining two ranges with both bounds NaN should yield null.
        Range range3 = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Range should just be null", null, range3);
    }

    /**
     * Test case for combining ranges with NaN and null.
     * Tests the behavior when one range is null and the other has NaN as bounds.
     */
    @Test
    public void combineIgnoringNaNAndNull() {
        double nan = Double.NaN;
        Range range1 = new Range(nan, nan);
        Range range2 = null;
        // Combining a range with NaN and null should yield null.
        Range range3 = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Range should just be null", null, range3);
    }

    /**
     * Test case for combining ranges with null and NaN.
     * Tests the behavior when one range has NaN as bounds and the other is null.
     */
    @Test
    public void combineIgnoringNullAndNaN() {
        double nan = Double.NaN;
        Range range1 = null;
        Range range2 = new Range(nan, nan);
        // Combining a range with null and NaN should yield null.
        Range range3 = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Range should just be null", null, range3);
    }

    
//  ---------------------TESTING equals(Object obj)---------------------

    /**
     * Test case for testing equality between two ranges with the same bounds.
     * Tests if the equals() method returns true for identical ranges.
     */
    @Test
    public void equalsSameRange() {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(1, 10);
        boolean eq = range1.equals(range2);
        assertTrue("Range 1 and Range 2 are equal", eq);
    }

    /**
     * Test case for testing inequality between two ranges with different bounds.
     * Tests if the equals() method returns false for different ranges.
     */
    @Test
    public void equalsDifferentRange() {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(5, 10);
        boolean eq = range1.equals(range2);
        assertFalse("Range 1 and Range 2 are not equal", eq);
    }

    /**
     * Test case for testing inequality between two ranges with negative bounds.
     * Tests if the equals() method returns false for different ranges.
     */
    @Test
    public void equalsNegativeRange() {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(-10, -1);
        boolean eq = range1.equals(range2);
        assertFalse("Range 1 and Range 2 are not equal", eq);
    }

    /**
     * Test case for testing inequality between a range and null.
     * Tests if the equals() method returns false when comparing a range to null.
     */
    @Test
    public void equalsNullRange() {
        Range range1 = new Range(1, 10);
        boolean eq = range1.equals(null);
        assertFalse("Range 1 is not null", eq);
    }
    
    /**
     * Test case for checking equality between ranges with unequal upper bounds.
     * Tests if ranges with different upper bounds are considered not equal.
     */
    @Test
    public void testEqualsWithUnequalUpperBound() {
        Range range1 = new Range(0.0, 10.0);
        Range range2 = new Range(0.0, 5.0); // Different upper bound
        boolean eq = range1.equals(range2);
        assertFalse("Range 1 and Range 2 are not equal", eq);
    }
    
//  ---------------------TESTING expand(Range range, double lowerMargin, double upperMargin)---------------------
    
    /**
     * Test case for expanding a positive range.
     * Tests if the expand() method correctly expands the range by a specified percentage.
     */
    @Test
    public void expandPositiveRange() {
        Range range1 = new Range(0, 100);
        Range range1_e = Range.expand(range1, 0.1, 0.1);
        Range range2 = new Range(-10, 110);

        boolean eq = range1_e.equals(range2);
        assertTrue("Range 1 is expanded by 10%", eq);
    }

    /**
     * Test case for expanding a negative range.
     * Tests if the expand() method correctly expands the range by a specified percentage.
     */
    @Test
    public void expandNegativeRange() {
        Range range1 = new Range(-100, 0);
        Range range1_e = Range.expand(range1, 0.1, 0.1);
        Range range2 = new Range(-110, 10);

        boolean eq = range1_e.equals(range2);
        assertTrue("Range 1 is expanded by 10%", eq);
    }

    /**
     * Test case for condensing a positive range.
     * Tests if the expand() method correctly condenses the range by a specified negative percentage.
     */
    @Test
    public void expandNegativeFactor() {
        Range range1 = new Range(0, 100);
        Range range1_e = Range.expand(range1, -0.1, -0.1);
        Range range2 = new Range(10, 90);

        boolean eq = range1_e.equals(range2);
        assertTrue("Range 1 is condensed by 10%", eq);
    }

    /**
     * Test case for expanding a range with a negative length.
     * Tests if an IllegalArgumentException is thrown when attempting to expand such a range.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExpandRangeWithNegativeLength() {
        Range range = new Range(3.0, 5.0);
        double lowerMargin = 0.1;
        double upperMargin = -3.0;
        Range.expand(range, lowerMargin, upperMargin);
    }

    /**
     * Test case for expanding a null range.
     * Tests if an IllegalArgumentException is thrown when attempting to expand a null range.
     */
    @Test(expected = IllegalArgumentException.class)
    public void expandNullRange() {
        Range range1 = null;
        Range.expand(range1, 0.1, 0.1);
    }
    
//  ---------------------TESTING expandToInclude(Range range, double value)---------------------
    
    /**
     * Test case for expanding a range to include a lower value.
     * Tests if a range is expanded to include a lower value correctly.
     */
    @Test
    public void expandToIncludeLowerValue() {
        Range range1 = new Range (0, 10);
        Range range1_e = Range.expandToInclude(range1, -5);
        Range range2 = new Range (-5, 10);
        
        boolean eq = range1_e.equals(range2);
        assertTrue("Range 1 is expanded to fit -5", eq);
    }

    /**
     * Test case for expanding a range to include a higher value.
     * Tests if a range is expanded to include a higher value correctly.
     */
    @Test
    public void expandToIncludeHigherValue() {
        Range range1 = new Range (0, 10);
        Range range1_e = Range.expandToInclude(range1, 15);
        Range range2 = new Range (0, 15);
        
        boolean eq = range1_e.equals(range2);
        assertTrue("Range 1 is expanded to fit 15", eq);
    }

    /**
     * Test case for expanding a range to include an already included value.
     * Tests if a range remains unchanged when trying to include a value it already contains.
     */
    @Test
    public void expandToIncludeIncludedValue() {
        Range range1 = new Range (0, 10);
        Range range1_e = Range.expandToInclude(range1, 5);
        Range range2 = new Range (0, 10);
        
        boolean eq = range1_e.equals(range2);
        assertTrue("Range 1 remains the same", eq);
    }

    /**
     * Test case for expanding a null range to include a value.
     * Tests if a null range is expanded to include a value correctly.
     */
    @Test
    public void expandToIncludeNullRange() {
        Range range1 = null;
        Range range1_e = Range.expandToInclude(range1, 5);
        Range range2 = new Range (5, 5);
        
        boolean eq = range1_e.equals(range2);
        assertTrue("Range 1 expanded to fit 5 and only 5", eq);
    }

    
//  ---------------------TESTING getCentralValue()---------------------
    
    /**
     * Test case for calculating the central value in a range spanning both positive and negative values.
     * Tests if the central value is correctly calculated for a range from -10 to 10.
     */
    @Test
    public void centralValueInPositiveNegativeRange() {
        Range range1 = new Range(-10, 10);
        assertEquals("Expected value is 0", 0, range1.getCentralValue(), 0.000000001d);
    }

    /**
     * Test case for calculating the central value in a range with only positive values.
     * Tests if the central value is correctly calculated for a range from 0 to 10.
     */
    @Test
    public void centralValueInPositivePositiveRange() {
        Range range1 = new Range(0, 10);
        assertEquals("Expected value is 5", 5, range1.getCentralValue(), 0.000000001d);
    }

    /**
     * Test case for calculating the central value in a range with only negative values.
     * Tests if the central value is correctly calculated for a range from -20 to -10.
     */
    @Test
    public void centralValueInNegativeNegativeRange() {
        Range range1 = new Range(-20, -10);
        assertEquals("Expected value is -15", -15, range1.getCentralValue(), 0.000000001d);
    }

    /**
     * Test case for calculating the central value in a range with the same upper and lower bound.
     * Tests if the central value is correctly calculated for a range with bounds at 1.
     */
    @Test
    public void centralValueInSameRange() {
        Range range1 = new Range(1, 1);
        assertEquals("Expected value is 1", 1, range1.getCentralValue(), 0.000000001d);
    }

    /**
     * Test case for calculating the central value in a null range.
     * Tests if an exception is thrown when attempting to calculate the central value of a null range.
     */
    @Test(expected = NullPointerException.class)
    public void centralValueInNullRange() {
        Range range1 = null;
        range1.getCentralValue();
    }

    
//  ---------------------TESTING getLowerBound()---------------------
    
    /**
     * Test case for retrieving the lower bound of a valid range.
     * Tests if the lower bound of the range [0, 10] is correctly returned as 0.
     */
    @Test
    public void getLowerBoundValidRange() {
        Range range1 = new Range(0, 10);
        assertEquals("The lower bound of the range is 0", 0, range1.getLowerBound(), 0.000000001d);
    }

    /**
     * Test case for retrieving the lower bound of a range with a negative lower bound.
     * Tests if the lower bound of the range [-10, 1] is correctly returned as -10.
     */
    @Test
    public void getLowerBoundNegativeLowerBound() {
        Range range1 = new Range(-10, 1);
        assertEquals("The lower bound of the range is -10", -10, range1.getLowerBound(), 0.000000001d);
    }

    /**
     * Test case for retrieving the lower bound of a range with the same upper and lower bounds.
     * Tests if the lower bound of the range [5, 5] is correctly returned as 5.
     */
    @Test
    public void getLowerBoundSameBoundsRange() {
        Range range1 = new Range(5, 5);
        assertEquals("The lower/upper bound of the range is 5", 5, range1.getLowerBound(), 0.000000001d);
    }

    
//  ---------------------TESTING getUpperBound()---------------------
    
    /**
     * Test case for retrieving the upper bound of a valid range.
     * Tests if the upper bound of the range [0, 10] is correctly returned as 10.
     */
    @Test
    public void getUpperBoundValidRange() {
        Range range1 = new Range(0, 10);
        assertEquals("The upper bound of the range is 10", 10, range1.getUpperBound(), 0.000000001d);
    }

    /**
     * Test case for retrieving the upper bound of a range with a negative upper bound.
     * Tests if the upper bound of the range [-20, -10] is correctly returned as -10.
     */
    @Test
    public void getUpperBoundNegativeUpperBound() {
        Range range1 = new Range(-20, -10);
        assertEquals("The upper bound of the range is -10", -10, range1.getUpperBound(), 0.000000001d);
    }

    /**
     * Test case for retrieving the upper bound of a range with the same upper and lower bounds.
     * Tests if the upper bound of the range [5, 5] is correctly returned as 5.
     */
    @Test
    public void getUpperBoundSameBoundsRange() {
        Range range1 = new Range(5, 5);
        assertEquals("The lower/upper bound of the range is 5", 5, range1.getUpperBound(), 0.000000001d);
    }

    
//  ---------------------TESTING hashCode()---------------------
    
    /**
     * Test case for generating the hash code of a valid range.
     * Tests if the hash code generated for the range [0, 10] matches the expected value.
     */
    @Test
    public void hashCodeValidRange() {
        Range range1 = new Range(0, 10);
        int hashed = range1.hashCode();
        int num = 1076101120;
        assertEquals("The hash code for the range should be 1076101120", num, hashed, 0.000000001d);
    }

    /**
     * Test case for generating the hash code of the same range.
     * Tests if the hash code generated for the same range [0, 10] is consistent.
     */
    @Test
    public void hashCodeSameRange() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);
        int hashed1 = range1.hashCode();
        int hashed2 = range1.hashCode();
        assertEquals("The hash code for the range should be 1076101120", hashed1, hashed2, 0.000000001d);
    }

    /**
     * Test case for generating the hash code of a null range.
     * Tests if an exception is thrown when attempting to generate the hash code of a null range.
     */
    @Test(expected = NullPointerException.class)
    public void hashCodeNullRange() {
        Range range1 = null;
        int hashed1 = range1.hashCode();
    }

    
//  ---------------------TESTING intersects(Range range)---------------------
    
    /**
     * Test case for checking intersection between two valid ranges.
     * Tests if the ranges [1, 10] and [6, 12] intersect with each other.
     */
    @Test
    public void intersectsValidRanges() {
        Range range1 = new Range (1, 10);
        Range range2 = new Range (6, 12);
        boolean is = range1.intersects(range2);
        assertTrue("Range 1 and 2 should intersect with each other", is);
    }

    /**
     * Test case for checking intersection between two valid ranges where there is no intersection.
     * Tests if the ranges [1, 10] and [11, 12] do not intersect with each other.
     */
    @Test
    public void intersectsValidRangesFalse() {
        Range range1 = new Range (1, 10);
        Range range2 = new Range (11, 12);
        boolean is = range1.intersects(range2);
        assertFalse("Range 1 and 2 should not intersect with each other", is);
    }

    /**
     * Test case for checking intersection involving a null range.
     * Tests if an exception is thrown when attempting to check intersection involving a null range.
     */
    @Test(expected = NullPointerException.class)
    public void intersectsNullRange() {
        Range range1 = new Range (1, 10);
        Range range2 = null;
        boolean is = range1.intersects(range2);
    }

    
    
//  ---------------------TESTING isNaNRange()---------------------
    
    /**
     * Test case for checking if a valid range contains NaN values.
     * Tests if the range [1, 10] does not contain NaN values.
     */
    @Test 
    public void isNaNValidRange() {
        Range range1 = new Range (1, 10);
        assertFalse("Range has valid bounds", range1.isNaNRange());
    }

    /**
     * Test case for checking if a range with one valid and one NaN bound contains NaN values.
     * Tests if the range [NaN, 10] does not contain NaN values.
     */
    @Test 
    public void isNaNPartiallyValidRange() {
        double value = Double.NaN;
        Range range1 = new Range (value, 10);
        assertFalse("Range has valid bounds", range1.isNaNRange());
    }

    /**
     * Test case for checking if an invalid range with both bounds as NaN contains NaN values.
     * Tests if the range [NaN, NaN] contains NaN values.
     */
    @Test 
    public void isNaNInvalidRange() {
        double value = Double.NaN;
        Range range1 = new Range (value, value);
        assertTrue("Range has valid bounds", range1.isNaNRange());
    }

    /**
     * Test case for checking if a null range contains NaN values.
     * Tests if an exception is thrown when attempting to check NaN values in a null range.
     */
    @Test(expected = NullPointerException.class)
    public void isNaNNullRange() {
        Range range1 = null;
        range1.isNaNRange();
    }

    
//  ---------------------TESTING scale(Range base, double factor)---------------------
    
    /**
     * Test case for scaling a range up by a positive factor.
     * Tests if the range [1, 10] scaled up by a factor of 10 equals [10, 100].
     */
    @Test 
    public void scalePositiveFactor() {
        Range range1 = new Range (1, 10);
        Range range2 = new Range (10, 100);
        assertEquals("Scale Range 1 up by a factor of 10", range2, Range.scale(range1, 10));
    }

    /**
     * Test case for scaling a negative range up by a positive factor.
     * Tests if the range [-20, -10] scaled up by a factor of 10 equals [-200, -100].
     */
    @Test 
    public void scalePositiveFactorNegativeRange() {
        Range range1 = new Range (-20, -10);
        Range range2 = new Range (-200, -100);
        assertEquals("Scale Range 1 up by a factor of 10", range2, Range.scale(range1, 10));
    }

    /**
     * Test case for attempting to scale a range by a negative factor.
     * Tests if an exception is thrown when attempting to scale a range by a negative factor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void scaleNegativeFactor() {
        Range range1 = new Range (10, 100);
        Range.scale(range1, -10);
    }

    /**
     * Test case for attempting to scale a null range.
     * Tests if an exception is thrown when attempting to scale a null range.
     */
    @Test(expected = IllegalArgumentException.class)
    public void scaleNullRange() {
        Range range1 = null;
        Range.scale(range1, 10);
    }

    
//  ---------------------TESTING shift(Range base, double delta)---------------------
    
    /**
     * Test case for shifting a positive range forward by a positive delta.
     * Tests if the range [1, 10] shifted forward by 2 units equals [3, 12].
     */
    @Test
    public void shiftPositiveDeltaPositiveRange() {
        Range range1 = new Range (1, 10);
        Range range2 = new Range (3, 12);
        assertEquals("Range 1 should be shifted forward 2 units", range2, Range.shift(range1, 2));
    }

    /**
     * Test case for shifting a positive range backward by a negative delta.
     * Tests if the range [2, 10] shifted backward by 2 units equals [0, 8].
     */
    @Test
    public void shiftNegativeDeltaPositiveRange() {
        Range range1 = new Range (2, 10);
        Range range2 = new Range (0, 8);
        assertEquals("Range 1 should be shifted backwards 2 units", range2, Range.shift(range1, -2));
    }

    /**
     * Test case for attempting to shift a range backward past zero.
     * Tests if the range [1, 10] cannot be shifted backwards by 2 units past zero.
     */
    @Test
    public void shiftNegativeDeltaPastZero() {
        Range range1 = new Range (1, 10);
        Range range2 = new Range (-1, 8);
        Range range1_s = Range.shift(range1, 2);
        boolean eq = range1_s.equals(range2);
        assertFalse("Cannot shift backwards past zero", eq);
    }

    /**
     * Test case for shifting a negative range forward by a positive delta.
     * Tests if the range [-20, -10] shifted forward by 5 units equals [-15, -5].
     */
    @Test
    public void shiftPositiveDeltaNegativeRange() {
        Range range1 = new Range (-20, -10);
        Range range2 = new Range (-15, -5);
        assertEquals("Range 1 should be shifted forward 5 units", range2, Range.shift(range1, 5));
    }

    /**
     * Test case for shifting a negative range backward by a negative delta.
     * Tests if the range [-20, -10] shifted backward by 5 units equals [-25, -15].
     */
    @Test
    public void shiftNegativeDeltaNegativeRange() {
        Range range1 = new Range (-20, -10);
        Range range2 = new Range (-25, -15);
        assertEquals("Range 1 should be shifted backward 5 units", range2, Range.shift(range1, -5));
    }

    /**
     * Test case for shifting a zero range forward by a positive delta.
     * Tests if the range [0, 0] shifted forward by 5 units equals [5, 5].
     */
    @Test
    public void shiftPositiveDeltaZeroRange() {
        Range range1 = new Range (0, 0);
        Range range2 = new Range(5, 5);
        assertEquals("Range 1 should be shifted forward 5 units", range2, Range.shift(range1, 5));
    }

    /**
     * Test case for attempting to shift a null range.
     * Tests if an exception is thrown when attempting to shift a null range.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shiftNullRange() {
        Range range1 = null;
        Range.shift(range1, 5);
    }

    /**
     * Test case for attempting to shift a range by a NaN delta.
     * Tests if an exception is thrown when attempting to shift a range by a NaN delta.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shiftNaNDelta() {
        Range range1 = new Range(1, 10);
        Range.shift(range1, Double.NaN);
    }

    
    
//  ---------------------TESTING shift(Range base, double delta, boolean allowZeroCrossing)---------------------
    
    /**
     * Test case for shifting a range backward by a negative delta with zero-crossing enabled.
     * Tests if the range [1, 10] shifted backward by 2 units with zero-crossing enabled equals [-1, 8].
     */
    @Test
    public void shiftNegativeDeltaZeroCrossTrue() {
        Range range1 = new Range (1, 10);
        Range range2 = new Range (-1, 8);
        assertEquals("Range 1 should be shifted backwards 2 units", range2, Range.shift(range1, -2, true));
    }

    /**
     * Test case for shifting a range backward by a negative delta with zero-crossing disabled.
     * Tests if the range [1, 10] shifted backward by 2 units with zero-crossing disabled equals [0, 8].
     */
    @Test
    public void shiftNegativeDeltaZeroCrossFalse() {
        Range range1 = new Range (1, 10);
        Range range2 = new Range (0, 8);
        assertEquals("Range 1 should be shifted backwards 2 units", range2, Range.shift(range1, -2, false));
    }

    
//  ---------------------TESTING toString()---------------------
    
    /**
     * Test case for converting a positive range to a string representation.
     * Tests if the string representation of the range [1, 10] is "Range[1.0,10.0]".
     */
    @Test
    public void toStringPositiveRange() {
        Range range1 = new Range (1, 10);
        String r_string = range1.toString();
        assertEquals("String should be Range[1.0,10.0]", "Range[1.0,10.0]", r_string);
    }

    /**
     * Test case for converting a negative range to a string representation.
     * Tests if the string representation of the range [-20, -10] is "Range[-20.0,-10.0]".
     */
    @Test
    public void toStringNegativeRange() {
        Range range1 = new Range (-20, -10);
        String r_string = range1.toString();
        assertEquals("String should be Range[-20.0,-10.0]", "Range[-20.0,-10.0]", r_string);
    }

    /**
     * Test case for attempting to convert a null range to a string representation.
     * Tests if an exception is thrown when attempting to convert a null range to a string.
     */
    @Test(expected = NullPointerException.class)
    public void toStringNullRange() {
        Range range1 = null;
        String r_string = range1.toString();
    }

    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}