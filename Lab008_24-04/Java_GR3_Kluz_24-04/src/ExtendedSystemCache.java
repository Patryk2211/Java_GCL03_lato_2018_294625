import com.sun.jdi.Value;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExtendedSystemCache extends SystemCache implements Serializable {

    class Container
    {
        double [] input;
        double output;

        public Container(double[] input, double output) {
            this.input = input;
            this.output = output;
        }
    }

    ArrayList <Container> list = new ArrayList();

    private double [] inTab;
    //private double outVar;

    public ExtendedSystemCache(double[] inTab) {
        this.inTab = inTab;
        //this.outVar = outVar;
    }

    public ExtendedSystemCache()
    {
        this.inTab = null;
        //this.outVar = 0;
    }

    public double[] getInTab() {
        return inTab;
    }

    public void setInTab(double[] inTab) {
        this.inTab = inTab;
    }

    @Override
    public void put(double[] input, double output )
    {
        super.put( input, output );
        this.list.add(new Container(input, output));
    }

    void exportCSV(String path) throws IOException {
        File file = new File(path);
        file.createNewFile();
        exportCSV(file);
    }

    void exportCSV( File file ) throws IOException{
        FileOutputStream output = new FileOutputStream(file);
        exportCSV(output);
        output.close();
    }

    void exportCSV( OutputStream stream ) throws IOException{
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(stream));

        for(int i = 0; i < list.size(); i++) {
            int size = list.get(i).input.length;
            for(int j = 0; j < size; j++)
            {
                write.write(String.valueOf(list.get(i).input[j]) + ",");
            }
            write.write(String.valueOf(list.get(i).output));
        }
        write.close();
    }

    void importCSV( String path ) throws IOException {
        File file = new File(path);
        importCSV(file);
    }
    void importCSV( File file ) throws IOException {
        FileInputStream input = new FileInputStream(file);
        importCSV(input);
        input.close();
    }
    void importCSV( InputStream stream ) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(stream));
        String line = read.readLine();

            StringTokenizer token = new StringTokenizer(line, ",");
            StringTokenizer tokenTrial = new StringTokenizer(line, ",");
            int size = 0;

            while (tokenTrial.hasMoreTokens()) {
                size++;
                tokenTrial.nextToken();
            }

            double[] tab = new double[size - 1];
            double var = 0;

            for (int i = 0; i < size - 1; i++) {
                tab[i] = Double.parseDouble(token.nextToken());
            }

            var = Double.parseDouble(token.nextToken());

            put(tab, var);
        read.close();
        }

    void serialize( String path ) throws IOException{
        File file = new File(path);
        serialize(file);

    }
    void serialize ( File file ) throws IOException{
        FileOutputStream output = new FileOutputStream(file);
        serialize(output);
        output.close();
    }
    void serialize ( OutputStream stream ) throws IOException{
        ObjectOutputStream outSer = new ObjectOutputStream(stream);
        outSer.writeObject(inTab);
        outSer.writeObject(get(inTab));
        outSer.close();
    }

    void deserialize( String path ) throws IOException, ClassNotFoundException{
        File file = new File(path);
        deserialize(file);
    }
    void deserialize( File file ) throws IOException, ClassNotFoundException{
        FileInputStream deser = new FileInputStream(file);
        deserialize(deser);
        deser.close();
    }
    void deserialize( InputStream stream ) throws IOException, ClassNotFoundException{
        ObjectInputStream inDeser = new ObjectInputStream(stream);
        System.out.println(inDeser.readObject());
        inDeser.close();
    }
}
