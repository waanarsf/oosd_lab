public class Mixer {
    private int[] arr;
    private int cap;

    // Constructor
    public Mixer(int mm) {
        cap = mm;
        arr = new int[cap];
    }

    // Method to accept array elements
    public void input(int[] elements) {
        if (elements.length <= cap) {
            // Corrected variable name from 'element' to 'elements'
        System.arraycopy(elements, 0, arr, 0, elements.length);
        } else {
            System.arraycopy(elements, 0, arr, 0, cap);
        }
    }

    // Method to mix the first 3 elements from two Mixer objects
    public Mixer mix(Mixer P, Mixer Q) {
        // The resultant array will have a capacity of 6 (3 from P and 3 from Q)
        Mixer resultant = new Mixer(6);
        int index = 0;

        // Copy first 3 elements from P
        for (int i = 0; i < 3 && i < P.arr.length; i++) {
            resultant.arr[index++] = P.arr[i];
        }

        // Copy first 3 elements from Q
        for (int i = 0; i < 3 && i < Q.arr.length; i++) {
            resultant.arr[index++] = Q.arr[i];
        }
        
        // This method should return the 'resultant' object it created
        return resultant; 
    }

    // Method to display the array
    public void display() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Create Mixer objects
        Mixer m1 = new Mixer(5);
        m1.input(new int[]{78, 90, 100, 45, 67});
        Mixer m2 = new Mixer(4);
        m2.input(new int[]{10, 67, 200, 90});

        // Create a temporary object to call the mix method
        // The capacity of this object doesn't matter since 'mix' returns a new object
        Mixer tempMixer = new Mixer(0); 

        // Mix the first 3 elements of m1 and m2
        Mixer resultantMixer = tempMixer.mix(m1, m2);

        // Display the result
        System.out.print("Array 1: ");
        m1.display();
        System.out.print("Array 2: ");
        m2.display();
        System.out.print("Resultant Array: ");
        resultantMixer.display();
    }
}