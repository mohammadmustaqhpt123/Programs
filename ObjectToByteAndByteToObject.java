package programming;
import java.util.*;
import java.io.*;
public class ToStringSample {

    public static void main( String [] args )  throws IOException,
                                                      ClassNotFoundException {
        String string = toString( new SomeClass() );
        System.out.println(" Encoded serialized version " );
        System.out.println("\n");
        byte[] ar = convertToByte(new SomeClass()); // convert to object to byte
        
        System.out.println();
        System.out.println();
        SomeClass name = (SomeClass)convertToObject(ar); // convert byte to object
        System.out.println(name);
        System.out.println(ar.length);
         for (byte a : ar) {
			System.out.print(a);
		}
         System.out.println("\n");
        System.out.println( string );
        SomeClass some = ( SomeClass ) fromString( string );
        System.out.println( "\n\nReconstituted object");
        System.out.println( some );


    }

    /** Read the object from Base64 string. */
   private static Object fromString( String s ) throws IOException ,
                                                       ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );    //decode  using base64
        ObjectInputStream ois = new ObjectInputStream( 
                                        new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
   }

   public static Object convertToObject(byte[] by) throws IOException, ClassNotFoundException
   {
	   ByteArrayInputStream baos = new ByteArrayInputStream(by);
       ObjectInputStream oos = new ObjectInputStream( baos );
       Object obj = oos.readObject();
       oos.close();
       return obj;
   }
   public static byte[] convertToByte(Serializable o) throws IOException
   {
	   ByteArrayOutputStream baos = new ByteArrayOutputStream();
       ObjectOutputStream oos = new ObjectOutputStream( baos );
       oos.writeObject(o);
       oos.close();
	return baos.toByteArray();
	   
   }
    /** Write the object to a Base64 string. */
    private static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray()); // encoding concept with base64
    }
}

/** Test subject. A very simple class. */ 
class SomeClass implements Serializable {

    private final static long serialVersionUID = 1; // See Nick's comment below

    int i    = Integer.MAX_VALUE;
    String s = "ABCDEFGHIJKLMNOP";
    Double d = new Double( -1.0 );
    public String toString(){
        return  "SomeClass instance says: Don't worry, " 
              + "I'm healthy. Look, my data is i = " + i  
              + ", s = " + s + ", d = " + d;
    }
}
