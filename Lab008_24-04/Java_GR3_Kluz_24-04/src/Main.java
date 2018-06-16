import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {
    public static void main(String [] args)
    {
        /*SystemCache test = new SystemCache();

        double[] inTab =
                {
                        13.4,
                        20.1,
                        37.1,
                        41.5,
                        59.8
                };
        double out = 1.2;

        test.put(inTab, out);

        ExtendedSystemCache testIm = new ExtendedSystemCache();
        try {
            testIm.importCSV("new1.csv");
        }
        catch (IOException e)
        {
            System.out.println("errorerror");
        }

        double [] tablica =
                {
                        1.1,2.1,3.1
                };

        ExtendedSystemCache testEx = new ExtendedSystemCache(tablica);

        try {
            testEx.exportCSV("wynik.csv");
        }
        catch (IOException e)
        {
            System.out.println("Blad");
        }
        System.out.println(testIm.get(tablica));*/

        // *****************************************************************************

        ScatterSystem system = new ScatterSystem(); // można umieścić wewnątrz dowolną funkcję matematyczną
        SystemCache cache = new SystemCache();

        Random pick = new Random();
        double[] input = {
                pick.nextDouble()*10,
                pick.nextDouble()*10,
                pick.nextDouble()*10,
                pick.nextDouble()*10
        };

        Double output = cache.get( input );
        if( output == null )
        {
            output = system.makeOperation( input );
            cache.put( input, output );
        }

        System.out.println(output);

        //System.out.println(cache.get(input));

        /*ExtendedSystemCache serializeTest = new ExtendedSystemCache(input);
        try {
            serializeTest.serialize("serialize.txt");
        }
        catch (IOException e)
        {
            System.out.println("Serialize IO error!");
        }

        try{
            serializeTest.deserialize("serialize.txt");
        }
        catch (IOException e)
        {
            System.out.println("Serialize IO error!");
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Serialize CNF error!");
        }*/

        ExtendedSystemCache exportTest = new ExtendedSystemCache(input);
        ExtendedSystemCache importTest = new ExtendedSystemCache(input);

        try{
            exportTest.exportCSV("eksport.csv");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        try{
            importTest.importCSV("eksport.csv");
            System.out.println(importTest.getInTab());
            System.out.println(importTest.get(importTest.getInTab()));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
