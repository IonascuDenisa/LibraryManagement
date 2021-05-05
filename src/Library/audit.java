package Library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class audit {

    int nr;
    Calendar calendar = Calendar.getInstance();

    public audit(int nr) throws IOException {
        this.nr=nr;
        String path = "D:\\LABORATOARE EAP\\Library\\audit.csv";
        FileWriter writer=new FileWriter(path,true);
        BufferedWriter bw = new BufferedWriter(writer);
        PrintWriter pw = new PrintWriter(bw);

        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String data = form.format(calendar.getTime());
        if(nr==1){
            pw.println("new client added"+","+data);
        }
        if(nr==2){
            pw.println("new book added"+","+data);
        }
        if(nr==3){
            pw.println("new loan added"+","+data);
        }
        pw.flush();
        pw.close();
    }
}
