/* -----------------------------------------------------------------;
 * $source   : / $
 * $revision : 1.0 $
 * $author   : wyr@null.co.za $
 * $date     : 2024/05/24 22:31:00 SAST $
 * $desc     : $
 * $log      : $
 *
 * -----------------------------------------------------------------;
 */ 
 
import java.io.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
 
class dye 
{	
	List<String> lines;
	ArrayList<String> output = new ArrayList<String>();
	
	public String output_file_name = "sorted-names-list.txt";
	public String input_file_name;
	
	// -------------------------------------------------------------;
	// @write_file_list - write vaules out to stdout. 
	// -------------------------------------------------------------;
	
	public int write_file_list () 
	{
	    try
            {
	        FileWriter fileWriter = new FileWriter(output_file_name);
			
                for (String str : output)
	        {
		    fileWriter.write(str + System.lineSeparator());
		}
		fileWriter.close();
            }
	    catch (Exception e)
	    {
	        System.out.println (e);
            }
	    return 1;
        }
	
	// -------------------------------------------------------------;
	// @read_file_list - read values in from stdin.
	// -------------------------------------------------------------;

	public int read_file_list () 
	{
	    Path file_path = Paths.get(".", input_file_name);
	    Charset charset = Charset.forName("UTF-8");

	    try
	    {
	        lines = Files.readAllLines(file_path, charset);
	    }
	    catch (Exception e)
	    {
                System.out.println (e);
            }
            return 1;
	}
	
	// -------------------------------------------------------------;
	// @list_sorted - sort through the list, -- append values to list.
	// -------------------------------------------------------------;
	
	public int list_sorted () 
	{
            int n = lines.size();
       
            String temp;
	    String [] t;
	    String [] f = new String[lines.size()];
		
	    ArrayList<String> c = new ArrayList<String>();

            for (int i = 0; i < n; i++) 
	    {
	        t    = lines.get(i).split(" ");
		f[i] = lines.get(i);
			
	        c.add (t[t.length - 1]);
	    }  
            String[] str = new String[c.size()];
 
            for (int i = 0; i < c.size(); i++) 
	    {
                str[i] = c.get(i);
            }	

            for (int i = 0; i < n; i++) 
	    {
                for (int j = i + 1; j < n; j++)
	        {               
                    if (str[i].compareTo(str[j]) > 0) 
		    {
                        temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                    }
                }
            }
		
            for (int i = 0; i < n; i++) 
	    {
	        for (int s = 0; s < n; s++) 
		{
		    if (f[s].contains(str[i]))
		    {
		        System.out.println(f[s]);
		        output.add (f[s]);
		    }
	        }
            }
            return 1;
	}
	
	// -------------------------------------------------------------;
	// @parse_arguments - input values from stdin. 
	// -------------------------------------------------------------;

	public boolean parse_arguments (String[] args) 
	{
	    if (args.length > 0) 
	    {
	        input_file_name = args[0];
		return true;
	    } 
	    else
	    {
                return false;
	    }
        }
	
	
	// -------------------------------------------------------------;
	// @main - entry point. 
	// -------------------------------------------------------------;
	
    	public static void main(String[] args)
    	{
	    try
	    {
	        dye c = new dye();
			
	        if (c.parse_arguments (args)) 
		{
	            c.read_file_list ();
		    c.list_sorted ();
		    c.write_file_list ();
		}
		else 
		{
		    System.out.println("Please provide a relevant input file.");
		}
			
	    }
	    catch (Exception e)
	    {
	        System.out.println (e);
            }
        }
    }
