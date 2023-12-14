package uk.ac.manchester.tornado.api.types;

/**
 * This class represents a float-16 instance (half float). The data is stored in a short field, to be
 * compliant with the representation for float-16 used in the {@link Float} class. The class encapsulates
 * methods for getting the data in float-16 and float-32 format, and for basic arithmetic operations (i.e.
 * addition, subtraction, multiplication and division).
 */
public class HalfFloat {

    private short halfFloatValue;

    /**
     * Constructs a new instance of the {@code HalfFloat} out of a float value.
     * To convert the float to a float-16, the floatToFloat16 function of the {@link Float}
     * class is used.
     *
     * @param halfFloat
     *     The float value that will be stored in a half-float format.
     */
    public HalfFloat(float halfFloat) {
        this.halfFloatValue = Float.floatToFloat16(halfFloat);
    }

    /**
     * Constructs an empty {@code HalfFloat} object.
     * It is used internally in a {@link #createHalfFloatFromShort(short) createHalfFloatFromShort} method.
     */
    private HalfFloat() {
    }

    /**
     * Creates a new {@code HalfFloat} instance out of a float-16 (represented by a short value).
     * This is used by the {@link uk.ac.manchester.tornado.api.types.arrays.HalfFloatArray#get(int) get}
     * method of the {@link uk.ac.manchester.tornado.api.types.arrays.HalfFloatArray} class, to create
     * a new {@code HalfFloat} object using the value is extracted from the segment,
     * without converting it to float-32 first.
     *
     * @param halfFloatValue
     * @return
     */
    public static HalfFloat createHalfFloatFromShort(short halfFloatValue) {
        HalfFloat halfFloat = new HalfFloat();
        halfFloat.halfFloatValue = halfFloatValue;
        return halfFloat;
    }

    /**
     * Gets the half-float stored in the class.
     *
     * @return The half float value stored in the {@code HalfFloat} object.
     */
    public short getHalfFloatValue() {
        return this.halfFloatValue;
    }

    /**
     * Gets the half-float stored in the class in a 32-bit representation.
     *
     * @return The float-32 equivalent value the half float stored in the {@code HalfFloat} object.
     */
    public float getFloat32() {
        return Float.float16ToFloat(halfFloatValue);
    }

    /**
     * Takes two half float values, converts them to a 32-bit representation and performs an addition.
     *
     * @param a
     *     The first float-16 input for the addition.
     * @param b
     *     The second float-16 input for the addition.
     * @return The result of the addition.
     */
    private static float addHalfFloat(short a, short b) {
        float floatA = Float.float16ToFloat(a);
        float floatB = Float.float16ToFloat(b);
        return floatA + floatB;
    }

    /**
     * Takes two {@code HalfFloat} objects and returns a new {@HalfFloat} instance
     * that contains the results of the addition.
     *
     * @param a
     *     The first {@code HalfFloat} input for the addition.
     * @param b
     *     The second {@code HalfFloat} input for the addition.
     * @return A new {@HalfFloat} containing the results of the addition.
     */
    public static HalfFloat add(HalfFloat a, HalfFloat b) {
        float result = addHalfFloat(a.getHalfFloatValue(), b.getHalfFloatValue());
        return new HalfFloat(result);
    }

    /**
     * Takes two half float values, converts them to a 32-bit representation and performs a subtraction.
     *
     * @param a
     *     The first float-16 input for the subtraction.
     * @param b
     *     The second float-16 input for the subtraction.
     * @return The result of the subtraction.
     */
    private static float subHalfFloat(short a, short b) {
        float floatA = Float.float16ToFloat(a);
        float floatB = Float.float16ToFloat(b);
        return floatA - floatB;
    }

    /**
     * Takes two {@code HalfFloat} objects and returns a new {@HalfFloat} instance
     * that contains the results of the subtraction.
     *
     * @param a
     *     The first {@code HalfFloat} input for the subtraction.
     * @param b
     *     The second {@code HalfFloat} input for the subtraction.
     * @return A new {@HalfFloat} containing the results of the subtraction.
     */
    public static HalfFloat sub(HalfFloat a, HalfFloat b) {
        float result = subHalfFloat(a.getHalfFloatValue(), b.getHalfFloatValue());
        return new HalfFloat(result);
    }

    /**
     * Takes two half float values, converts them to a 32-bit representation and performs a multiplication.
     *
     * @param a
     *     The first float-16 input for the multiplication.
     * @param b
     *     The second float-16 input for the multiplication.
     * @return The result of the multiplication.
     */
    private static float multHalfFloat(short a, short b) {
        float floatA = Float.float16ToFloat(a);
        float floatB = Float.float16ToFloat(b);
        return floatA * floatB;
    }

    /**
     * Takes two {@code HalfFloat} objects and returns a new {@HalfFloat} instance
     * that contains the results of the multiplication.
     *
     * @param a
     *     The first {@code HalfFloat} input for the multiplication.
     * @param b
     *     The second {@code HalfFloat} input for the multiplication.
     * @return A new {@HalfFloat} containing the results of the multiplication.
     */
    public static HalfFloat mult(HalfFloat a, HalfFloat b) {
        float result = multHalfFloat(a.getHalfFloatValue(), b.getHalfFloatValue());
        return new HalfFloat(result);
    }

    /**
     * Takes two half float values, converts them to a 32-bit representation and performs a division.
     *
     * @param a
     *     The first float-16 input for the division.
     * @param b
     *     The second float-16 input for the division.
     * @return The result of the division.
     */
    private static float divHalfFloat(short a, short b) {
        float floatA = Float.float16ToFloat(a);
        float floatB = Float.float16ToFloat(b);
        return floatA / floatB;
    }

    /**
     * Takes two {@code HalfFloat} objects and returns a new {@HalfFloat} instance
     * that contains the results of the division.
     *
     * @param a
     *     The first {@code HalfFloat} input for the division.
     * @param b
     *     The second {@code HalfFloat} input for the division.
     * @return A new {@HalfFloat} containing the results of the division.
     */
    public static HalfFloat div(HalfFloat a, HalfFloat b) {
        float result = divHalfFloat(a.getHalfFloatValue(), b.getHalfFloatValue());
        return new HalfFloat(result);
    }

}
