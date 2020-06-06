import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections; 
import java.io.*;

public class Main
{
	public static void main(String[] args) 
	{ 
		Map<String, ArrayList<String>> map = new Map<>(); 
        ArrayList<String> all = new ArrayList<>();
    	Scanner input = new Scanner(System.in);
    	String strLine = "";
        // membuka data yang telah disediakan
    	try {
            BufferedReader br = new BufferedReader(new FileReader("../file/data.txt"));
            while (strLine != null)
            {
                //membaca data dari baris ke baris
                	strLine = br.readLine();
                    if(strLine != null){
                    	String[] data = strLine.split(":",2);
                        
                        // mengiris data dan simpan ke dalam hashmap
		                if(map.get(data[0]) == null) //jika data belum ada, simpan ke dalam elemen hash baru
		                {
		                	ArrayList<String> temp =  new ArrayList<>();
		                	temp.add(data[1]);
		                	map.add(data[0], temp);
                            all.add(data[0]);
		                }
		                else{ // jika data ada, tambahkan elemen hash yang ada
		                	map.get(data[0]).add(data[1]);
		                }
                    }
            }
             br.close();

             // Handling the exception
        } catch (FileNotFoundException e) {
            System.err.println("File tidak ditemukan");
        } catch (IOException e) {
            System.err.println("Tidak dapat membaca file");
        }

        // jika argument 'show',  menampilkan semua isi tabel ke dalama HTML
        if(args[0].equals("show")){
            Collections.sort(all);
            System.out.println("<table class='table'>");
            System.out.println("<tr><th>No</th>");
            System.out.println("<th>Nama Editor </th>");
            System.out.println("<th>Jumlah Artikel </th></tr>");
            
            for(int i =0; i<all.size(); i++){
                ArrayList<String> e = map.get(all.get(i));
                System.out.println("<tr><td>"+(i+1)+"</td>");
                System.out.println("<td>"+all.get(i)+"</td>");
                System.out.println("<td>"+e.size()+"</td></tr>");
            }
            System.out.println("</table>");
        
        //jika argumen bukan'show', masukkan nama editor dan liat hashmap nya
        // tampilkan ke dalam halaman HTML
        }else{
             ArrayList<String> result = map.get(args[0]);
             if(result != null) //if data found print it 
            {
                Collections.sort(result);
                System.out.println("<h5 class='mb-3'>Daftar artikel "+args[0]+" </h5>");
                System.out.print("<ul class='list-group'>");
                result.forEach((e)->System.out.print("<li class='list-group-item list-group-item-action'>"+e+"</li>"));
                System.out.print("</ul>");
            }
            else // status: 404
            {
                System.out.println("Data For "+args[0]+" Not Found");
            }
        }
	}  
}   