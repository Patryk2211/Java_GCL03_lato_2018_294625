public class ScatterSystem {
    public double makeOperation(double [] input)
    {
        double result = 0;

        int size = input.length;

        for(int i = 0; i < size; i++)
        {
            result += Math.cos(input[i]) * Math.sin(input[i]);
        }

        return  result;
    }
}
